package com.test.initializationBlock;

public class Manager extends Employee{
    private Integer bonous;

    public Integer getBonous() {
        return bonous;
    }

    public void setBonous(Integer bonous) {
        this.bonous = bonous;
    }

    public Integer getSalary() {
        this.name = "test";
        Integer baseSalary = super.getSalary();
        return baseSalary + bonous;
    }


    public static void main(String[] args){

    }


}