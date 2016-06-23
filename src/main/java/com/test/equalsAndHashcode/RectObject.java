package com.test.equalsAndHashcode;

import java.util.*;

//如果重新定义equals方法，则必须重新定义hashCode方法
//Java系统首先调用对象的hashCode()方法获得该对象的哈希码表，然后根据哈希吗找到相应的存储区域，
// 最后取得该存储区域内的每个元素与该对象进行equals方法比较

//hashcode()不等，一定能推出equals()也不等；hashcode()相等，equals()可能相等，也可能不等

public class RectObject{
    public int x;
    public int y;
    public RectObject(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final RectObject other = (RectObject)obj;
        if(x != other.x){
            return false;
        }
        if(y != other.y){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        HashSet<RectObject> set = new HashSet<RectObject>();
        RectObject r1 = new RectObject(3,3);
        RectObject r2 = new RectObject(5,5);
        RectObject r3 = new RectObject(3,3);
        set.add(r1);
        set.add(r2);
        set.add(r3);
        set.add(r1);
        System.out.println("size:"+set.size());

        int[] luckyNumbers = {3,2,4,7,18};

        String s = "" + luckyNumbers;
        System.out.println(s);
        System.out.println(Arrays.toString(luckyNumbers));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.ensureCapacity(100);


        list.iterator();


        //Collection

        //implements List
        LinkedList linkedList = new LinkedList();
        linkedList.iterator();

        ArrayList arrayList;
        Vector v;

        //implements Set
        HashSet hashSet;
        LinkedHashSet linkedHashSet;

        //implements Map
        Hashtable hashtable;
        HashMap hashMap;
        WeakHashMap weakHashMap;

    }
}