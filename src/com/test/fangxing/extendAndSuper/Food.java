package com.test.fangxing.extendAndSuper;


import java.util.ArrayList;
import java.util.List;

class Fruit extends Food{}
class Apple extends Fruit{}
class RedApple extends Apple{}

public class Food{
    public static void main(String[] args)
    {
        //表示参数化类型只能为Fruit的子类型
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // complie error:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        //flist.add(new RedApple());
        flist.add(null); // only work for null

        //表示参数化类型是Fruit的超类
        List<? super Fruit> flist1 = new ArrayList<Fruit>();
        flist1.add(new Apple());
        flist1.add(new Fruit());
        flist1.add(new RedApple());

//        Fruit fruit = flist1.get(0);
    }
}





