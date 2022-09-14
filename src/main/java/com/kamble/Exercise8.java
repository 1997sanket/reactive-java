package com.kamble;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens

        //catching error and terminating.
        //ReactiveSources.intNumbersFluxWithException().subscribe(data -> System.out.println(data), error -> System.out.println(error));

        //we can do something when error occurs but error is not catched
        //ReactiveSources.intNumbersFluxWithException().doOnError(err -> System.out.println(err)).subscribe(data -> System.out.println(data));

        // Print values from intNumbersFluxWithException and continue on errors
        //ReactiveSources.intNumbersFluxWithException().onErrorContinue((err, data) -> System.out.println("Error : " + err + " Data was: " + data)).subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        //onErrorResume will ignore the current flux and generate new fallBack flux.
        ReactiveSources.intNumbersFluxWithException().onErrorResume(err -> Flux.just(-1, -2)).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
