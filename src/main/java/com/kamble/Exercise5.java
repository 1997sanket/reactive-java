package com.kamble;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

/*
    1. BackPressure: When the Receiver is overwhelmed by the data provided by the Publisher, he can tell the publisher to slow down, I need sometime.

    2. We can implement this by extending a class BaseSubscriber, and implementing its hook methods.

    3. hookOnSubscribe() method gets the subscription object, and from here we need to explicitly ask for more data.

    4. That data we will receive in hookOnNext(T t) method, and there after processing we need to again ask for more data.

    5. So by using BaseSubscriber, we can control the Rate of Flow of data.

    6. Remember, the data is still being published, we are not fetching it.

 */

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                data -> System.out.println(data),   //for items
                error -> System.out.println("error"),   //for errors
                () -> System.out.println("Flux Completed")  //for complete event
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubScriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}


class MySubScriber<T> extends BaseSubscriber<T> {

    //this method will be called when we subscribe to a flux, we get a Subscription object.

    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribed successfully");

        //telling Publisher that I'm ready for two more, so give it to me whenever you have those elements
        request(2);
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");

        //once you are processed/printed the data, you need to ask for more
        request(1);
    }
}