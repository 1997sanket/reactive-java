package com.kamble;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size

        /*
            Now this is a blocking operation, as we are waiting for all elements and then converting to list.
            So we don't need to take user input as it is already blocking.
         */
        List<Integer> list = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());

        System.out.println("List: " + list);
        System.out.println("size: " + list.size());

    }

}
