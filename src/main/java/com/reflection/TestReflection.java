package com.reflection;

import com.test.initializationBlock.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*在JDK中，主要由以下类来实现Java反射机制，这些类都位于java.lang.reflect包中
        –Class类：代表一个类（这个类很特殊，位于java.lang包下）。
        –Field 类：代表类的成员变量（成员变量也称为类的属性）。
        –Method类：代表类的方法。
        –Constructor 类：代表类的构造方法。
        –Array类：提供了动态创建数组，以及访问数组的元素的静态方法*/

public class TestReflection{
    public static void main(String[] args){
        try{
            Employee employee =  new Employee("cj", 19, 220);
            Class cl = employee.getClass();
//            Field f = cl.getDeclaredField("name");
//            Object o = f.get(employee);
//
//            m.
            System.out.println(cl.getName() + ", ");

            Method m = Employee.class.getMethod("getName");

            Employee employee1 = (Employee) Class.forName(Employee.class.getName()).newInstance();


            System.out.println( m.invoke(employee, new Object[]{}) + ", ");


           /* Method sqrt = Math.class.getMethod("sqrt", double.class);
            System.out.println(sqrt.invoke(null, 4));*/

            Class<?> classType = Employee.class;
            Employee copyEmployee = (Employee) classType.newInstance();
            Field[] fields = classType.getDeclaredFields();
            for (int i=0; i<fields.length; i++){
                String name = fields[i].getName();
                String getMethodName = "get" + name.substring(0,1).toUpperCase() + name.substring(1);
                String setMethodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1);

                Method getMethod = classType.getMethod(getMethodName);
                Method setMethod = classType.getMethod(setMethodName, new Class[]{fields[i].getType()});

                Object value = getMethod.invoke(employee, new Object[]{});

                setMethod.invoke(copyEmployee, new Object[]{value});

                System.out.println(getMethod.invoke(copyEmployee, new Object[]{}));

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*public int add(int param1,int param2)
    {
        return param1 + param2;
    }

    public String echo(String message)
    {
        return "hello : " + message;
    }

    public static void main(String[] args) throws Exception
    {
        Class<?> classType = TestReflection.class;

        Object invokeTester = classType.newInstance();

        Method addMethod = classType.getMethod("add", new Class[]{int.class,int.class});

        Object result = addMethod.invoke(invokeTester, new Object[]{1,2});

        System.out.println((Integer)result);

        System.out.println("----------");

        Method echoMethod = classType.getMethod("echo", new Class[]{String.class});

        Object result1 = echoMethod.invoke(invokeTester, new Object[]{"world"});

        System.out.println((String)result1);
    }*/
}