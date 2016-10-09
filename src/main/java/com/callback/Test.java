package com.callback;

public class Test {

    public static String test(String value, TestCallBack testCallBack) {
        return testCallBack.callback(value);
    }

    public static void main(String[] args) {
        String result = test("2", new TestCallBack() {
            @Override
            public String callback(String value) {
                if (value.equals("1")) {
                    return "ok";
                } else if (value.equals("2")) {
                    return "re";
                } else if (value.equals("3")) {
                    return "wrong";
                }
                return "";
            }
        });
        System.out.println(result);

        Test test = new Test();
        TestCallBack1 testCallBack1 = test.new TestCallBack1();
        TestCallBack2 testCallBack2 = new Test.TestCallBack2();


        result = test("2", test.new TestCallBack1());

    }

    static class TestCallBack2 implements TestCallBack{
        @Override
        public String callback(String value) {
            if (value.equals("1")) {
                return "ok2";
            } else if (value.equals("2")) {
                return "re2";
            } else if (value.equals("3")) {
                return "wrong2";
            }
            return "";
        }
    }




    public class TestCallBack1 implements TestCallBack{
        @Override
        public String callback(String value) {
            if (value.equals("1")) {
                return "ok1";
            } else if (value.equals("2")) {
                return "re1";
            } else if (value.equals("3")) {
                return "wrong1";
            }
            return "";
        }
    }
}