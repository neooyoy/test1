package com.test;

import com.beans.DeptTreeNode;
import com.test.initializationBlock.Employee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static final int x = 1;

    public static int y = 2;

    public static void main(String[] args) {

     /*   System.out.println(Integer.MIN_VALUE >> 1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);*/
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
       /* System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUFE);*/

       /* Long mix = Long.MIN_VALUE;
        for (int i=0; i<64; i++){
            mix = mix >> 1;
        }
        System.out.println(mix);*/

        System.out.println(Math.pow(2, 63));
        System.out.println(Long.MIN_VALUE/(-Math.pow(2, 64)));



        Integer x = Integer.valueOf(1);
        int z = x.intValue();


        DeptTreeNode deptTreeNode = new DeptTreeNode();
        deptTreeNode.setId("0");
        deptTreeNode.setName("0");
        deptTreeNode.setDeptName("测试0");

        DeptTreeNode subDeptTreeNode = new DeptTreeNode();
        subDeptTreeNode.setId("1");
        subDeptTreeNode.setName("1");
        subDeptTreeNode.setDeptName("测试1");

        List<DeptTreeNode> children = new ArrayList<DeptTreeNode>();
        children.add(subDeptTreeNode);
        deptTreeNode.setChildren(children);



    }
}

class EmployeeSub extends Employee {
    public void test(){
//        String s = super.age;
        String name = super.name;
        String sex = super.sex;

//        String defaultName = super.defaultName;
    }
}