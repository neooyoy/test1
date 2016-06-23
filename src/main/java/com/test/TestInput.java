package com.test;

import java.util.Scanner;

public class TestInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("what is your name?");
        String name = in.nextLine();

        System.out.println("how old are you?");
        String age = in.nextLine();

        System.out.println(name + ":" + age);
    }
}