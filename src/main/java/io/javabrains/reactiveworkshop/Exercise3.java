package io.javabrains.reactiveworkshop;

import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numList = ReactiveSources.intNumbersFlux().toStream().toList();
        numList.forEach(System.out::println);
        System.out.println(numList.size());

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
