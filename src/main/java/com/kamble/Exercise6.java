package com.kamble;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds

        /*
            1. The below flux never responds.
            2. So basically we are saying, block the code only for 5 seconds, if we dont get the data then move forward.
            3. Remember that we wont get a null to the String variable, Instead we will get an IllegalStateException after 5 seconds.
         */
//        String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));


        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        List<String> list = ReactiveSources.unresponsiveMono().flux().collect(Collectors.toList()).block(Duration.ofSeconds(5));
        System.out.println(list);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
