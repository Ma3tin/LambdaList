package com.company;

public class Main {

    public static void main(String[] args) {
        LambdaList<Integer> lambdaList = new LambdaList<>();
        LambdaList<Integer> pepepe = new LambdaList<>();
        lambdaList.add(1);
        lambdaList.add(2);
        lambdaList.add(3);
        lambdaList.add(4);
        System.out.println(lambdaList.all(number -> number < 5));
        lambdaList.add(5);
        lambdaList.add(6);
        System.out.println(lambdaList.any(number -> number < 5));
        System.out.println(lambdaList.max((inputOne, inputTwo) -> inputOne - inputTwo));
        System.out.println(lambdaList.filter(number -> number % 2 == 0));
        lambdaList = lambdaList.map(number -> number * 5);
        System.out.println(lambdaList);
        /*
        for (int i = 0; i < lambdaList.size(); i++) {
            pepepe = lambdaList.filter(number -> number % 2 == 0);
        }
         */
        //System.out.println(lambdaList.map());
    }
}
