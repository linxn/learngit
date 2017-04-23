package sortingAl.selectionS;

/**
 * Created by linxn on 2017/4/9.
 */
public class Main {
    //选择排序
    static int[] selectionS(int [] arr){
        int min_p, min;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            min_p = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min){
                    min = arr[j];
                    min_p = j;
                }
            }
            arr[min_p] = arr[i];
            arr[i] = min;

        }
        return arr;
    }
    //冒泡排序
    static int[] bubbingS(int[] arr){
        int tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr ={1,3,2,45,65,33,12};
        //arr = selectionS(arr);
        arr = bubbingS(arr);
        for (int a:arr
             ) {
            System.out.printf(a+" ");
        }
    }
}
