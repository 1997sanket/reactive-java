package com.kamble;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        //ReactiveSources.intNumbersFlux().filter(n -> n > 5).subscribe(n -> System.out.println(n));

        // Print 10 times each value from intNumbersFlux that's greater than 5
        //ReactiveSources.intNumbersFlux().filter(n -> n > 5).map(n -> n*10).subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        //ReactiveSources.intNumbersFlux().filter(n -> n > 5).take(3).map(n -> n*10).subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        //ReactiveSources.intNumbersFlux().filter(n -> n > 20).defaultIfEmpty(-1).subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        /*
            FlapMap because we will get Flux<User> internally with only 1 User at a time, so wo convert Flux<User> to just User.
         */
        //ReactiveSources.intNumbersFlux().flatMap(n -> ReactiveSources.userFlux().filter(u -> u.getId() == n)).subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        //ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        //ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
