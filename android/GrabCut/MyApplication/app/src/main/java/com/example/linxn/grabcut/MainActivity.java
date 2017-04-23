package com.example.linxn.grabcut;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.OutputStream;


import java.util.Vector;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;



//public class MainActivity extends AppCompatActivity  implements View.OnClickListener
public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    static{ System.loadLibrary("opencv_java"); }



    private ImageView image;
    private Paint paint;
    private Canvas canvas;
    private Bitmap bitmap;
    private Bitmap alterBitmap;
    private Bitmap rectBitmap;
    private Button choose;
    private Button save;
    private Button change;
    private Button start;
    private final static int RESULT = 0;

    private float downx = 0, downy = 0, upx = 0, upy = 0;
    private int f_or_b = 0; //前景或者背景  前景TRUE 背景FALSE
    private boolean if_rect = false;
    //private GrabCut gc;

    //rect
    float x, y;
    float top, bottom, left, right;

    public enum State{ NOT_SET , IN_PROCESS , SET };
    public static final int radius = 5;
    public static final int thickness = -1;

    final Scalar RED = new Scalar(255,0,0);
    final Scalar PINK = new Scalar(230,130,255);
    final Scalar BLUE = new Scalar(0,0,255);
    final Scalar LIGHTBLUE = new Scalar(160,255,255);
    final Scalar GREEN = new Scalar(0,255,0);

    Mat image1;
    Mat mask;
    Mat bgdModel = null, fgdModel = null;
    Mat temp, res, binMask;
    Bitmap showBitmap;

    State rectState, lblsState, prLblsState;
    public boolean isInitialized;

    Rect rect = new Rect();
    Vector<Point> fgdPxls = new Vector<Point>();
    Vector<Point> bgdPxls = new Vector<Point>();
    Vector<Point> prFgdPxls = new Vector<Point>();
    Vector<Point> prBgdPxls = new Vector<Point>();
    int iterCount;

    public void reset(){
        if( !mask.empty() )
            mask.setTo(Scalar.all(Imgproc.GC_BGD));
        bgdPxls.clear(); fgdPxls.clear();
        prBgdPxls.clear();  prFgdPxls.clear();

        isInitialized = false;
        rectState = State.NOT_SET;
        lblsState = State.NOT_SET;
        prLblsState = State.NOT_SET;
        iterCount = 0;
    }

    public void setImage(Bitmap bitmap)
    {
        if (bitmap == null)
            return;
        Log.e("bit",bitmap.getWidth()+" "+bitmap.getHeight());
        Mat tempimage = new Mat();

        Utils.bitmapToMat(bitmap, tempimage);
        Mat image = new Mat();
        Imgproc.cvtColor(tempimage, image, Imgproc.COLOR_RGBA2RGB);
        this.image1 = image;
        mask = new Mat(image.size(), CvType.CV_8UC1);
        mask.setTo(Scalar.all(Imgproc.GC_BGD));
        temp = new Mat(image.size(), CvType.CV_8UC1);
        temp.setTo(Scalar.all(1));
        bgdModel = new Mat(); fgdModel = new Mat();
        showBitmap = Bitmap.createBitmap(bitmap);

        binMask = new Mat(image.size(), CvType.CV_8UC1);
        reset();
    }

    private final void getBinMask( Mat comMask, Mat binMask )
    {
        if( comMask.empty() || comMask.type()!=CvType.CV_8UC1 )
//      CV_Error( CV_StsBadArg, "comMask is empty or has incorrect type (not CV_8UC1)" );
            Log.e("error","comMask is empty or has incorrect type (not CV_8UC1)");
        if( binMask.empty() || binMask.rows() != comMask.rows() || binMask.cols() != comMask.cols() )
            binMask.create( comMask.size(), CvType.CV_8UC1 );
//  binMask = comMask & 1;
        Core.bitwise_and(comMask, temp, binMask);
    }

    public Bitmap showImage()
    {
        if( image1.empty() )
            return null;

        res = new Mat();
        if( !isInitialized )
            image1.copyTo( res );
        else
        {
            getBinMask( mask, binMask );
            image1.copyTo( res, binMask);
        }

        for( Point it : bgdPxls)
            Core.circle( res, it, radius, BLUE, thickness );
        for( Point it : fgdPxls)
            Core.circle( res, it, radius, RED, thickness );
        for( Point it : prBgdPxls)
            Core.circle( res, it, radius, LIGHTBLUE, thickness );
        for( Point it : prFgdPxls)
            Core.circle( res, it, radius, PINK, thickness );

        if( rectState == State.IN_PROCESS || rectState == State.SET )
            Core.rectangle( res, new Point( rect.x, rect.y ), new Point(rect.x + rect.width, rect.y + rect.height ), GREEN, 5);

        Utils.matToBitmap(res, showBitmap);
        return showBitmap;
        //   imshow( *winName, res );
    }

    public int nextIter()
    {
        if( isInitialized )
            Imgproc.grabCut( image1, mask, rect, bgdModel, fgdModel, 1 );
        else
        {
            if( rectState != State.SET )
                return iterCount;

            if( lblsState == State.SET || prLblsState == State.SET )
                Imgproc.grabCut( image1, mask, rect, bgdModel, fgdModel, 1, Imgproc.GC_INIT_WITH_MASK );
            else
                Imgproc. grabCut( image1, mask, rect, bgdModel, fgdModel, 1, Imgproc.GC_INIT_WITH_RECT );

            isInitialized = true;
        }
        iterCount++;

        bgdPxls.clear(); fgdPxls.clear();
        prBgdPxls.clear(); prFgdPxls.clear();

        return iterCount;
    }

    public int getIterCount() { return iterCount; }

    private void setRectInMask(){
        assert( !mask.empty() );
        mask.setTo( new Scalar(Imgproc.GC_BGD));
        rect.x = Math.max(0, rect.x);
        rect.y = Math.max(0, rect.y);
        rect.width = Math.min(rect.width, image1.cols()-rect.x);
        rect.height = Math.min(rect.height, image1.rows()-rect.y);
        (mask.submat(rect)).setTo( new Scalar(Imgproc.GC_PR_FGD) );
    }
    private void setLblsInMask( int flag, Point p, boolean isPr ){
        Vector<Point> bpxls, fpxls;
        int bvalue, fvalue;
        if( !isPr )
        {
            bpxls = bgdPxls;
            fpxls = fgdPxls;
            bvalue = Imgproc.GC_BGD;
            fvalue = Imgproc.GC_FGD;
        }
        else
        {
            bpxls = prBgdPxls;
            fpxls = prFgdPxls;
            bvalue = Imgproc.GC_PR_BGD;
            fvalue = Imgproc.GC_PR_FGD;
        }
        if( flag == 1 || flag == 3)
        {
            fpxls.add(p);
            Core.circle( mask, p, radius, new Scalar(fvalue), thickness );
        }
        if( flag == 2 || flag == 4 )
        {
            bpxls.add(p);
            Core.circle( mask, p, radius, new Scalar(bvalue), thickness );
        }
    }

    public void ontouch( int event, int x, int y ,int flag)
    {
        switch( event )
        {
            case 0: // Touch Down
            {
                if( flag == 0 && rectState == State.NOT_SET )
                {
                    rectState = State.IN_PROCESS;
                    rect = new Rect( x, y, 1, 1 );
                }
                if ( (flag == 1 || flag == 2) && rectState == State.SET )
                    lblsState = State.IN_PROCESS;

                if ( (flag == 3 || flag == 4) && rectState == State.SET )
                    prLblsState = State.IN_PROCESS;
            }
            break;
            case 1:  //Touch Up
                if( rectState == State.IN_PROCESS )
                {
                    rect = new Rect( new Point(rect.x, rect.y), new Point(x,y) );
                    rectState = State.SET;
                    setRectInMask();
                    assert( bgdPxls.isEmpty() && fgdPxls.isEmpty() && prBgdPxls.isEmpty() && prFgdPxls.isEmpty() );
                }
                if( lblsState == State.IN_PROCESS )
                {
                    setLblsInMask(flag, new Point(x,y), false);
                    lblsState = State.SET;
                }

                if( prLblsState == State.IN_PROCESS )
                {
                    setLblsInMask(flag, new Point(x,y), true);
                    prLblsState = State.SET;
                }
                break;
            case 2:  //Touch Move
                if( rectState == State.IN_PROCESS )
                {
                    rect = new Rect( new Point(rect.x, rect.y), new Point(x,y) );
                    assert( bgdPxls.isEmpty() && fgdPxls.isEmpty() && prBgdPxls.isEmpty() && prFgdPxls.isEmpty() );
                }
                else if( lblsState == State.IN_PROCESS )
                {
                    setLblsInMask(flag, new Point(x,y), false);
                }
                else if( prLblsState == State.IN_PROCESS )
                {
                    setLblsInMask(flag, new Point(x,y), true);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        choose = (Button) findViewById(R.id.chooseButton);
        save=(Button)findViewById(R.id.saveButton);
        change = (Button)findViewById(R.id.changeButton);
        start = (Button)findViewById(R.id.startButton);

        choose.setOnClickListener(this);
        save.setOnClickListener(this);

        image.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                Matrix m = image.getImageMatrix();
                float[] values = new float[10];
                m.getValues(values);
                Log.i("radio", "x= "+values[0]+"; y= "+values[4]);

                switch (action) {
                    case MotionEvent.ACTION_DOWN: //down = event 0
                        downx = event.getX();
                        downy = event.getY();
                        x = downx; y = downy;
                        Log.i("position", "onTouch: x= "+downx+"; y= "+downy);
                        ontouch(0,(int)(event.getX() / values[0]),(int)(event.getY() / values[4]),f_or_b);
                        image.setImageBitmap(showImage());
                        break;
                    case MotionEvent.ACTION_MOVE: //move = event 2
                        // 路径画板
                        upx = event.getX();
                        upy = event.getY();
                        Log.i("position", "onTouch: x= "+upx+"; y= "+upy);
                        ontouch(2,(int)(event.getX() / values[0]),(int)(event.getY() / values[4]),f_or_b);
                        image.setImageBitmap(showImage());
                        downx = upx;
                        downy = upy;
                        break;
                    case MotionEvent.ACTION_UP: //up = event 1
                        // 直线画板
                        upx = event.getX();
                        upy = event.getY();
                        Log.i("position", "onTouch: x= "+upx+"; y= "+upy);
                        ontouch(1,(int)(event.getX() / values[0]),(int)(event.getY() / values[4]),f_or_b);
                        image.setImageBitmap(showImage());
                        if(f_or_b == 0){
                            f_or_b = 1;
                            paint.setColor(Color.RED);
                            Toast.makeText(getApplicationContext(),"绘制矩形框成功！",Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"请绘制前景和背景！点击\"绘制前景\"按钮切换",Toast.LENGTH_SHORT).show();
                        }
                        break;

                    default:
                        break;
                }

                return true;
            }
        });

        change.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(paint != null){
                    if(f_or_b == 1){
                        change.setText("绘制前景");
                        paint.setColor(Color.BLUE);
                        f_or_b = 2;
                    }else{
                        change.setText("绘制背景");
                        paint.setColor(Color.RED);
                        f_or_b = 1;
                    }
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int iterCount = getIterCount();
                int newIterCount = nextIter();
                if( newIterCount > iterCount ){
                    image.setImageBitmap(showImage());
                    Toast.makeText(getApplicationContext(),"分析成功！",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClick(View arg0) {
        if(arg0==choose){
            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RESULT);
        }else if(arg0==save){
            //保存画好的图片
            if(alterBitmap!=null){
                try {
                    Uri imageUri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
                    OutputStream outputStream=getContentResolver().openOutputStream(imageUri);
                    showImage().compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    Toast.makeText(getApplicationContext(), "save!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //屏幕 1440 2560
    //图片 720 1280
    //upx / values[0] = 1440, upy / values[4] = 2560
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri imageFileUri = data.getData();
            Display display = getWindowManager().getDefaultDisplay();
            float dw = display.getWidth();   //1440
            float dh = display.getHeight();  //2560
            Log.i("screen size", "x= "+dw+"; y= "+dh);

            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(imageFileUri), null, options);
                int heightRatio = (int) Math.ceil(options.outHeight / dh);
                int widthRatio = (int) Math.ceil(options.outWidth / dw);
                if (heightRatio > 1 && widthRatio > 1) {
                    if (heightRatio > widthRatio) {
                        options.inSampleSize = heightRatio;
                    } else {
                        options.inSampleSize = widthRatio;
                    }
                }
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(imageFileUri), null, options);
                alterBitmap = Bitmap.createBitmap(bitmap.getWidth(),
                        bitmap.getHeight(), bitmap.getConfig());
                canvas = new Canvas(alterBitmap);
                paint = new Paint();
                paint.setColor(Color.GREEN);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(30);
                Matrix matrix = new Matrix();
                canvas.drawBitmap(bitmap, matrix, paint);
                rectBitmap = alterBitmap.copy(alterBitmap.getConfig(), true);
                image.setImageBitmap(alterBitmap);
                f_or_b = 0;
                //gc.setImage(alterBitmap);
                setImage(alterBitmap);
                Toast.makeText(getApplicationContext(),"请先用矩形框框出前景！",Toast.LENGTH_SHORT).show();
                Log.i("alterBitmap size", "x= "+alterBitmap.getWidth()+"; y= "+alterBitmap.getHeight());
                //image.setOnTouchListener(this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}



