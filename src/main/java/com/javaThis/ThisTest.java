package com.javaThis;

/**
 * Created by cj on 2016/11/29.
 */

/*１、表示对当前对象的引用！
２、表示用类的成员变量，而非函数参数，注意在函数参数和成员变量同名是进行区分！其实这是第一种用法的特例，比较常用，所以那出来强调一下。
３、用于在构造方法中引用满足指定参数类型的构造器（其实也就是构造方法）。但是这里必须非常注意：只能引用一个构造方法且必须位于开始！
还有就是注意：this不能用在static方法中！所以甚至有人给static方法的定义就是：没有this的方法！虽然夸张，但是却充分说明this不能在static方法中使用！*/

/**
 * this 的三种用法
 *
 * @author cj
 * @since 1.0.0
 */
public class ThisTest {

    private int i = 0;

    public ThisTest(int i) {
        this.i = i + 1;
        System.out.println(this.i);
    }

    public ThisTest(String s) {
        System.out.println(s);
    }

    public ThisTest(int i, String s) {
        this(s);

//        this(2)

        this.i = i + 1;

        System.out.println(this.i + "  " + s);
    }

    public ThisTest increment() {
        this.i++;
        return this;
    }

    public static void main(String[] args) {
        ThisTest tt0 = new ThisTest(10);
        ThisTest tt1 = new ThisTest("ok");
        ThisTest tt2 = new ThisTest(20, "ok again!");

        System.out.println(tt0.increment().increment().increment().i);

        System.out.println(tt0.test());
    }

    public static int test() {
        return 1;
    }

}
