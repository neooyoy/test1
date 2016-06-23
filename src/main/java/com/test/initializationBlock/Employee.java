package com.test.initializationBlock;

import java.util.Random;

//private : 仅对本类可见
//public : 对所有类可见
//protected : 对本包和子类可见
//default : 仅对本包可见

public class Employee implements Comparable{
    private Integer salary;

    protected String name;

    private Integer age;

    private Integer id;

    private static int nextId;

    public String sex;

    String defaultName;

    @Override
    public boolean equals(Object obj) {
        return (this.name == obj);
    }


    public final void getName1(){

    }

    static
    {
        System.out.println("hello world!");
        Random random = new Random();
        nextId = random.nextInt(10000);
    }

    public Employee() {
    }

    public Employee(String name, Integer age, Integer salary) {
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    public Employee(Integer salary){
        this("test", 20, salary);
        this.id = nextId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Employee.nextId = nextId;
    }


    public int compareTo(Object other){
        Employee otherEmployee =  (Employee)other;
        if (this.salary < otherEmployee.getSalary()){
            return -1;
        }else if (this.salary > otherEmployee.getSalary()){
            return 1;
        }
        return 0;
    }
}

class EmployeeSub extends Employee{
    public void test(){
//        String s = super.age;
        String name = super.name;
        String sex = super.sex;
    }
}