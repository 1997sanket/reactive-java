package com.kamble;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(num -> System.out.println(num));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(num -> System.out.println(num));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
        .filter(num -> num > 5)
        .skip(1)
        .limit(2)
        .forEach(num -> System.out.println(num));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        int x = StreamSources.intNumbersStream().filter(num -> num > 5).findFirst().orElse(-1);
        System.out.println("x = " + x);

        // Print first names of all users in userStream
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(firstName -> System.out.println(firstName));

        // Print first names in userStream for users that have IDs from number stream

//        StreamSources.userStream()
//        .filter(user -> {
//            boolean flag = StreamSources.intNumbersStream().anyMatch(num -> num== user.getId());
//            if(flag) return true;
//            else return false;}
//            )
//            .map(user -> user.getFirstName()).forEach(firstName -> System.out.println(firstName));

        //Kaushik's method
//        StreamSources.intNumbersStream()
//                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
//                .map(user -> user.getFirstName()).forEach(System.out::println);

        /*
            Note:
                map -> to convert one type to another
                flatMap -> if the another type is again a Stream of type which you want. Then it just flattens it, and gets the type.
         */
        }

}
