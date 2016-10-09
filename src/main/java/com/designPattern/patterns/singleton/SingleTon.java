package com.designPattern.patterns.singleton;

public class SingleTon {
    private static final SingleTon singleTon = new SingleTon();

    private SingleTon() {
    }

    public SingleTon getSingleTon() {
        return singleTon;
    }

    static class SubSingleTon {
        private static SubSingleTon subSingleTon = null;

        private String name;
        private String age;

        private SubSingleTon() {
        }

        public static SubSingleTon GetSubsingleTon() {
            synchronized (SubSingleTon.class) {
                if (subSingleTon == null) {
                    subSingleTon = new SubSingleTon();
                    subSingleTon.setName("subSingleTon");
                    subSingleTon.setAge("18");
                }
                System.out.println(subSingleTon.getName() + ":" + subSingleTon.getAge());
                return subSingleTon;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) { 
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    public class SubThread implements Runnable {
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) {
        SubSingleTon subSingleTon = SubSingleTon.GetSubsingleTon();
        SingleTon1 singleTon1 = SingleTon1.getSingleTon1();
    }
}


class SingleTon1 {
    private static SingleTon1 singleTon1 = null;

    private String name;
    private String age;

    private SingleTon1() {
    }

    public static synchronized SingleTon1 getSingleTon1() {
        if (singleTon1 == null) {
            singleTon1 = new SingleTon1();
            singleTon1.setName("singleTon1");
            singleTon1.setAge("21");
            System.out.println(singleTon1.getName() + ":" + singleTon1.getAge());
        }
        return singleTon1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
