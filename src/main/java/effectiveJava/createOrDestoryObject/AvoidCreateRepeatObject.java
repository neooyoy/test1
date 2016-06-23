package effectiveJava.createOrDestoryObject;

public class AvoidCreateRepeatObject{
    //don't do this
    String s = new String("ss");

    //user this
    String s1 = "ss";

    //避免重复创建对象

    public static void main(String[] args){
        Long m1 = System.currentTimeMillis();
        String s = null;
        for (int i=0; i<10000; i++){
            s += new String("sss");
//            s += "ss";
        }

        Long m2 = System.currentTimeMillis();

        System.out.println(m2-m1);
    }
}