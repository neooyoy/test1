package com.test.overriteAndOverload;

public class Shape {
    //继承的方法
    public boolean isShape(){
        return true;
    }

    //被重写的方法
    protected int getSides(){
        return 0;
    }

    public int getSides(Triangle tri){ //重载
        return 3 ;
    }

    public int getSides(Rectangle rec){ //重载
        return 4 ;
    }

    public static void main(String[] args){
        //继承
        Triangle triangle = new Triangle();
        System.out.println("triangle is a type of Shape ? " + triangle.isShape());

        //多态
        Shape shape = new Triangle();
        System.out.println("My shape has " + shape.getSides() + " sides.");

        //重载
        Rectangle Rec = new Rectangle();
        Shape shape2 = Rec;
        System.out.println("My shape has " + shape2.getSides(Rec) + " sides.");
    }

}