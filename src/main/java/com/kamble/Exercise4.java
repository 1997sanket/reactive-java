package com.kamble;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits


        /*
               Here Mono just gives 1 or 0 value
         */
        ReactiveSources.intNumberMono().subscribe(number -> {
            System.out.println(number);
        });

        // Get the value from the Mono into an integer variable
        int num = ReactiveSources.intNumberMono().block();  //blocking method
        System.out.println("num: " + num);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
