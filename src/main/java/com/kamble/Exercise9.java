package com.kamble;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        //ReactiveSources.intNumbersFlux().count().subscribe(System.out::println);  //counts while emitting

        // Collect all items of intNumbersFlux into a single list and print it
        //ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);  //prints list when last element is emitted

        // Transform to a sequence of sum of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)  //buffer of 2 means, 2 events = 1 event
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
