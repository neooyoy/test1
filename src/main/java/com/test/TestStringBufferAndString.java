package test;

/*
String:是对象不是原始类型.
为不可变对象,一旦被创建,就不能修改它的值.
对于已经存在的String对象的修改都是重新创建一个新的对象,然后把新的值保存进去.
String 是final类,即不能被继承.



StringBuffer:
是一个可变对象,当对他进行修改的时候不会像String那样重新建立对象
它只能通过构造函数来建立,
StringBuffer sb = new StringBuffer();
对象被建立以后,在内存中就会分配内存空间,并初始保存一个null.通过它的append方法向其赋值.

sb.append("hello");



字符串连接操作中StringBuffer的效率要明显比String高:

String对象是不可变对象,每次操作Sting 都会重新建立新的对象来保存新的值.

StringBuffer对象实例化后，只对这一个对象操作。*/

public class TestStringBufferAndString {
    public static void main(String args[]) {

        String str = "abc";
        StringBuffer sb = new StringBuffer("abc");
        Runtime runtime = Runtime.getRuntime();
        long start = System.currentTimeMillis();
        long startFreememory = runtime.freeMemory();
        for (int i = 0; i < 10000; i++) {
            str += i;
            //测试StringBuffer时候把注释打开
//            sb.append(i);
        }
        long endFreememory = runtime.freeMemory();
        long end = System.currentTimeMillis();
        System.out.println("操作耗时:" + (end - start) + "ms," + "内存消耗:"
                + (startFreememory - endFreememory)/1024 + "KB");

    }
}




