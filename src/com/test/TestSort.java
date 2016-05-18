package com.test;

import java.util.*;

public class TestSort{
    private String name;
    private String id;

    public TestSort(String id) {
        this.id = id;
    }

    public TestSort(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args){
        int[] a = new int[50];
        List<Integer> list =  new ArrayList<Integer>();
        Random random = new Random();
        for (int i=0; i<a.length; i++){
            a[i] = random.nextInt(100);
            list.add(a[i]);
            System.out.println(a[i]);
        }

        System.out.println("----------------------------------");

//        Arrays.sort(a);

        Collections.sort(list);

        /*for (int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }*/

       /* for (Integer x : list){
            System.out.println(x);
        }*/


        int b[] = {1, 5, 5, 7, 0, 9, 14, 44, 5};
        Arrays.sort(b);
        for (int y : b){
            System.out.println(y);
        }

    }
}