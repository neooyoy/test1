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
    }
}