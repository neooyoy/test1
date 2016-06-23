package com.yunsuanfu;

/*运算符“>>”执行算术右移，它使用最高位填充移位后左侧的空位。右移的结果为：每移一位，第一个操作数被2除一次，移动的次数由第二个操作数确定。
        逻辑右移或叫无符号右移运算符“>>>“只对位进行操作，没有算术含义，它用0填充左侧的空位。
        算术右移不改变原数的符号，而逻辑右移不能保证这点。
        移位运算符约简其右侧的操作数，当左侧操作数是int类型时，右侧以32取模；当左侧是long类型时，右侧以64取模。*/
public class TestYunsuanfu{
    public static void main(String[] args){
        System.out.println("=============算术右移 >> ===========");
        int i=0xC0000000;
        System.out.println("移位前：i= "+i+" = "+Integer.toBinaryString(i)+"(B)");
        i=i>>28;
        System.out.println("移位后：i= "+i+" = "+Integer.toBinaryString(i)+"(B)");

        System.out.println("---------------------------------");

        int j=0x0C000000;
        System.out.println("移位前：j= "+j+" = "+Integer.toBinaryString(j)+"(B)");
        j=j>>24;
        System.out.println("移位后：j= "+j+" = "+Integer.toBinaryString(j)+"(B)");

        System.out.println("\n");
        System.out.println("==============逻辑右移 >>> =============");
        int m=0xC0000000;
        System.out.println("移位前：m= "+m+" = "+Integer.toBinaryString(m)+"(B)");
        m=m >>> 28;
        System.out.println("移位后：m= "+m+" = "+Integer.toBinaryString(m)+"(B)");

        System.out.println("---------------------------------");

        int n=0x0C000000;
        System.out.println("移位前：n= "+n+" = "+Integer.toBinaryString(n)+"(B)");
        n=n>>24;
        System.out.println("移位后：n= "+n+" = "+Integer.toBinaryString(n)+"(B)");

        System.out.println("\n");
        System.out.println("==============移位符号的取模===============");
        int a=0xCC000000;
        System.out.println("移位前：a= "+a+" = "+Integer.toBinaryString(a)+"(B)");
        System.out.println("算术右移32：a="+(a>>32)+" = "+Integer.toBinaryString(a>>32)+"(B)");
        System.out.println("逻辑右移32：a="+(a>>>32)+" = "+Integer.toBinaryString(a>>>32)+"(B)");
    }
}
