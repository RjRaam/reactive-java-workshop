package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));
        System.out.println("\n");
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(num -> num < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(num -> num > 5).skip(1).limit(2).forEach(System.out::println);
        System.out.println("\n");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer val = StreamSources.intNumbersStream().filter(num -> num > 5)
                .findFirst().orElse(-1);
        System.out.println(val);
        System.out.println("\n");
        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("\n");
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        //Not filter for duplicates
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName()).forEach(System.out::println);
        System.out.println("\n");
//Better way
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(num -> user.getId() == num))
                .forEach(filteredUser -> System.out.println(filteredUser.getFirstName()));
    }

}
