package couTime;

import java.util.Date;

/**
 * Created by linxn on 2017/4/9.
 *
 * 计算程序耗时
 */
public class Main {
    public static void main(String[] args) {
        Date begin = new Date();
        int a = 0;
        for (int i = 0; i < 1000; i++) {
            a++;
        }
        Date end = new Date();
        System.out.println("耗时：" + String.valueOf(end.getTime() - begin.getTime()) + " 毫秒");
    }
}
