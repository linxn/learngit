package JZoffer.test2;

/**
 * Created by linxn on 2017/4/10.
 */
public class Main {
    public static void main(String[] args) {
        Singleton2 s2 = Singleton2.getInstance();
        Singleton1 s1 = Singleton1.getInstance();
    }
}

//饿汉模式
class Singleton1{
    private static final Singleton1 s1 = new Singleton1();
    private Singleton1(){
        System.out.println("Singleton1对象被创建...");
    };
    public static Singleton1 getInstance(){
        System.out.println("取得Singleton1对象...");
        return s1;
    }
}

//懒汉模式
class Singleton2{
    private static Singleton2 s2;
    private Singleton2(){};
    public static Singleton2 getInstance(){
        if(s2 == null){
            s2 = new Singleton2();
            System.out.println("Singleton2对象被创建...");
        }
        System.out.println("取得Singleton2对象...");
        return s2;

    }

}
