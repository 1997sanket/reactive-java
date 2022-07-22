package com.kamble;

import java.io.IOException;

/*
    Here subscribe method is like forEach method of Stream API.
 */

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
//        ReactiveSources.intNumbersFlux().subscribe(number -> System.out.println(number));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user.getFirstName()));



        //Why does the process stop when main thread is over ??? i.e why do we have to make the main thread wait ?
        System.out.println("Press a key to end");
        System.in.read();
    }

}
