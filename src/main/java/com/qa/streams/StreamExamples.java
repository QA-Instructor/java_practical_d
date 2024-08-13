package com.qa.streams;

// The Streams API allows a declarative approach to processing and filtering data
// e.g. What do we want to do. Like SQL.
// It separates the 'what' from the 'how'
// Introduced in Java 8
// It uses internal iteration as opposed to lots of nested loops which uses external iteration e.g. iterators
// 2 types of method: intermediate and terminating (sometimes called lazy and eager)
// Intermediate methods return instances of a Stream
// Terminal operations collect the outcome of the stream into another object e.g. a list
// Uses lambdas and functional interfaces and chains of operations to describe WHAT needs to happen to our data
// Streams are data pipelines
// Intermediate operations are processed once a terminal operation is invoked on the Stream
// Great for performance as these chained intermediate operations can be merged in a single iteration
// Terminal operations close the stream

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void streamsExampleA() {
        System.out.println("\n######## Example A:");
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

// 1. create a stream
// 2. filter uses a Predicate functional interface that takes in an argument and returns a boolean
// 3. map uses a Function functional interface: Represents a function that accepts one argument and produces a result
// 4. sorted: Returns a stream consisting of the elements of this stream, sorted according to natural order.
// 5. forEach: Performs an action for each element of this stream. This is a terminal operation.
        myList
                .stream()
                .filter(s -> s.startsWith("c")) //Returns a stream consisting of the elements of this stream that match the given predicate
                .map(String::toUpperCase) //Returns a stream consisting of the results of applying the given function to the elements of this stream
                .sorted()// could use a Comparator Functional Interface here if wanted a different order
                .forEach(System.out::println);// uses a Consumer Functional Interface: accepts single arg, returns no result. Expected to have side-effects.
    }

    public static void streamsExampleB() {
        System.out.println("\n######## Example B:");

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> newList = intList.stream().map(i -> i * 2);

        // Print via a method reference
        // newList.forEach(System.out::println);

        // Print via a lambda statement
         newList.forEach(s -> System.out.print(s + " "));
    }

    public static void streamsExampleC() {
        System.out.println("\n######## Example C:");

//        1. Create a list of integers 1 to 7 inclusive
//        2. Stream the list
//        3. Square the integers
//        4. Limit the stream to only hold even integers
//        5. Print the integers

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> newList = intList.stream().map(i -> i * i).filter(i -> i % 2 == 0);

        // newList.forEach(System.out::println);
        newList.forEach(s -> System.out.print(s + " "));

    }

    public static void streamsExampleD() {
        System.out.println("\n######## Example D:");

//        1. Create a list of integers 1 to 7 inclusive
//        2. Stream the list
//        3. Square the integers
//        4. Limit the stream to only hold even integers
//        5. Use a Collector to convert the stream to a list of integers
//        6. Print the list of integers

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> newList = intList
                .stream()
                .map(i -> i * i)
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
//        newList.forEach(System.out::println);
        newList.forEach(s -> System.out.print(s + " "));

    }

    public static void streamsExampleE() {
        System.out.println("\n######## Example E:");

//        1. Create a list of integers 1 to 5
//        2. Stream the list
//        3. Square the integers
//        4. Collect the stream using a summarizingInt collector
//        5. Convert to a string
//        6. Print the statistics string object

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        String summary = intList
                .stream()
                .map(i -> i * i)
                .collect(Collectors.summarizingInt(i -> i)).toString();
        System.out.println(summary);

    }
}
