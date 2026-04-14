package com.myproject;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //Problem 1
        //Find duplicate elements in a list
        List<Integer>numbers= Arrays.asList(1,2,3,2,4,5,3,6,7,3);
        Set<Integer>seen=new HashSet<>();
        Set<Integer>duplicates=numbers.stream()
                .filter(n -> !seen.add(n))
                .collect(Collectors.toSet());
        System.out.println("Duplicates " + duplicates);  //Output [2, 3]

        //Problem 2
        // Remove the duplicate elements and print the remaining
        List<Integer>list=Arrays.asList(1,2,3,4,5,3,6,7,3);
        List<Integer>unique=list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique elements "+ unique);

        //Problem 3
        //limit and skip example
        List<Integer>list1=Arrays.asList(0,1,2,3,4,5,6,7,8);
        List<Integer>ans=list1.stream()
                .skip(4) //limit(4)
                .collect(Collectors.toList());
        System.out.println("Ans "+ ans);

        //Problem 4
        //Print first 5 random numbers
        Random random = new Random();
        random.ints().limit(5).forEach(n->System.out.println(n));

        //Problem 5
        //Print first 5 random numbers in sorted order
        Random rand=new Random();
        rand.ints().limit(5).sorted().forEach(n->System.out.println(n));

        //Problem 6
        // Write java program to concatenate two streams
        List<String>lista=Arrays.asList("Java", "8");
        List<String>listb=Arrays.asList("explained", "through", "programs");
        Stream<String>ans=Stream.concat(lista.stream(),listb.stream());
        ans.forEach(str->System.out.print(str+" "));

        //Problem 7
        //Print the sum of all numbers in the list
        List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum=list.stream().reduce(0,(a,b)->a+b);
        System.out.println(sum);

        //Problem 8
//        List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int max=list.stream()
                .max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Max " + max);
        int min=list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Min "+ min);

        //Problem 9
       // Convert the given string of names to upper case
        List<String>list=Arrays.asList("Atharv","Bathman","Franklin");
        List<String>upperCase= list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("UpperCase " + upperCase);

        //Problem 10
        //Using Stringjoiner join few Strings
        StringJoiner strj=new StringJoiner(",");
        StringJoiner strj1=new StringJoiner("," , "(", ")");
        strj.add("Saket");
        strj.add("John");
        strj.add("Franklin");
        System.out.println(strj);
          System.out.println(strj1);

        //Problem 11
       //Sort the array in ascending order
        int num[]={99,55,203,4,91};
        Arrays.sort(num);
        System.out.println("Sorted array in ascending order: " + Arrays.toString(num));

        //Problem 12
        //Sort the array in descending order
        // Must use an object array (Integer[]), not a primitive array (int[])
        Integer [] num={99,55,203,4,91};
        Arrays.sort(num,Collections.reverseOrder());
        System.out.print(Arrays.toString(num));

        //Problem 13
        //Find number of strings in a list whose length is greater than 5
        List<String>list=Arrays.asList("Saket", "Saurav", "SoftwareTestingHelp","Steve");
        int count= (int) list.stream()
                .filter(str->str.length()>5)
                .count();
        System.out.print("Count is " + count);

        //Problem 14
        //find the number of strings in the list that have a length of 5.
        List<String>list=Arrays.asList("Saket", "Saurav", "SoftwareTestingHelp","Steve");
        int count= (int) list.stream()
                .filter(str->str.length()==5)
                .count();
        System.out.print("Count is " + count);

        //Problem 15
        // find the number of strings in the list that start with the letter “a”.
        List<String>list=Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
        int count= (int) list.stream()
                .filter(s->s.startsWith("a"))
                .count();
        System.out.print("Count is " + count);


        //Problem 16
        //Sum of all even numbers in an array
        List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum=list.stream()
                .filter(n->n%2==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.print("sum "+sum);

        //Problem 17
        //Sum of all numbers divisible by 3
        List<Integer>list=Arrays.asList(1,2,3,4,5,6,7,8,9);
        int sum=list.stream()
                .filter(n->n%3==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.print("sum "+sum);

        //Problem 18
        //Find the average length of all strings in the list.
        List<String>list=Arrays.asList("apple", "banana", "cherry", "date");
        OptionalDouble average=list.stream()
                .mapToInt(String::length)
                .average();
        System.out.print("Average "+average);

        //Problem 19
        //find the length of the longest string in the list.
        List<String>list=Arrays.asList("apple", "banana", "cherry", "date");
        OptionalInt maxLen= list.stream()
                .mapToInt(String::length)
                .max();
        System.out.print("MaxLength "+maxLen);

        //Problem 20
        //Find the second highest number //dssf
        List<Integer>list=Arrays.asList(10, 25, 33, 25, 48, 48, 12);
        Optional<Integer> secondHighestNumber=list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.print(secondHighestNumber);

        //Problem 21
        //find the average of all numbers in the list.
        List<Integer>list=Arrays.asList(10, 25, 33, 25, 48, 48, 12);
        OptionalDouble avg=list.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println(avg);

        //Problem 22
        int num=12345;
        int sum=String.valueOf(num)
                .chars()
                .map(c->c-'0')
                .sum();
        System.out.println(sum);

        //Problem 23
        //find the sum of all numbers greater than 5.
        List<Integer>list=Arrays.asList(1, 6, 3, 8, 2, 7, 4, 9, 5);
        int sum=list.stream()
                .filter(n->n>5)
                .mapToInt(Integer::intValue)
                .sum();

        //Problem 25
        //Product of all numbers in the list
        List<Integer>list=Arrays.asList(1, 6);
        int product=list.stream()
                .reduce(1,(a,b)->a*b);
        System.out.println(product);

        //Problem 26
        //Find distinct even numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9, 10);
        List<Integer>ans=numbers.stream()
                .filter(n->n%2==0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 27
        // find the sum of the squares of all numbers in the list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares=numbers.stream()
                .mapToInt(n->n*n)
                .sum();
        System.out.println(sumOfSquares);

        //Problem 28
        //Sum of square of all odd numbers in an array
        List<Integer>list=Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum=list.stream()
                .filter(n->n%2!=0)
                .mapToInt(n->n*n)
                .sum();
        System.out.println(sum);

        //Problem 29
        //Print map in java 8 stream
        Map<String,Integer>map=new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        map.entrySet().stream().forEach(e->System.out.println(e));

        //Problem 30
        //Add two numbers using java 8 stream
        List<Integer>list=Arrays.asList(1,3);
        int sum=list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        //Problem 31
        //Remove negative numbers from list
        List<Integer>list=Arrays.asList(1,3,-1,-4);
        List<Integer>ans=list.stream()
                .filter(n->n>=0)
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 32
        //Filter out all the elements divisible by 3 and 5 from a list of integers
        List<Integer>list=Arrays.asList(1, 2, 3, 5, 10, 15, 20, 25, 30, 45, 60);
        List<Integer>ans=list.stream()
                .filter(n->n%3==0 && n%5==0)
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 33
        //Find Common Elements Between Two Lists
        List<String>list1=Arrays.asList("Jack", "Tom", "Sam", "John");
        List<String>list2=Arrays.asList("Jack", "Daniel", "Sam", "Alan");
        List<String>commonList=list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println(commonList);

        //Problem 34
        //Convert a list of integers to a list of their squares
        List<Integer>list=Arrays.asList(1, 2, 3, 4, 5);
        List<Integer>ans=list.stream()
                .map(n->n*n)
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 35
        // Find the union of two lists of integers
        List<Integer>list1=Arrays.asList(1, 2, 3, 4, 5);
        List<Integer>list2=Arrays.asList(4,5,6,7,8);
        List<Integer>union=Stream.concat(list1.stream(),list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(union);

        //Problem 36
        //Flatten list of lists
        List<List<Integer>>listsOfLists=Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );
        List<Integer>flattenedList=listsOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(flattenedList);

        //Problem 37
        //Remove null values
        List<String>list=Arrays.asList("Java", "Stream", null, "Filter", null);
        List<String>ans=list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 38
        //Check if a list of strings contains a specific string
        List<String>list=Arrays.asList("apple", "banana", "kiwi", "orange", "pear");
        boolean ans=list.stream()
                .anyMatch(s->s.contains("apple"));
        System.out.println(ans);

        //Problem 39
        //Count the number of strings containing a specific character ‘a’
        List<String> strings = Arrays.asList("apple", "banana", "orange", "grape");
        int count= (int) strings.stream()
                .filter(s->s.contains("a"))
                .count();
        System.out.println(count);

        //Problem 40
        //Sort list of strings in aplhabetical order
        List<String> strings = Arrays.asList("banana", "orange", "apple", "grape");
        List<String>ans=strings.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 41
        //Find and print the strings containing a specific substring
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apricot", "Orange", "Grapefruit", "Mango");
        List<String>ans=fruits.stream()
                .filter(s->s.contains("Ap"))
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 42
        // Print the difference between the maximum and minimum numbers
        List<Integer>numbers=Arrays.asList(10, 5, 7, 18, 3, 15);
        OptionalInt max=numbers.stream().mapToInt(Integer::intValue).max();
        OptionalInt min=numbers.stream().mapToInt(Integer::intValue).min();
        int difference=max.getAsInt()-min.getAsInt();
        System.out.println(difference);

        //Problem 43
        //Find and print the strings containing only vowels
        List<String>list=Arrays.asList("apple", "banana", "kiwi", "orange", "pear", "oai");
        List<String>ans=list.stream()
                .filter(s->s.matches("[aeiouAEIOU]+"))
                .collect(Collectors.toList());
        System.out.println(ans);

        //Problem 44
        //Find and print the strings with the maximum length
        List<String>list=Arrays.asList("karan", "GainJavaKnowledge", "Vivek", "MontyNewMemeberOnThisGroup");
        List<String>ans= Collections.singletonList(list.stream()
                .reduce((x, y) -> x.length() > y.length() ? x : y).get());
        System.out.println(ans);

        //Problem 45
        //Print the shortest string
        List<String>list=Arrays.asList("karan", "GainJavaKnowledge", "Vivek", "MontyNewMemeberOnThisGroup","aa");
        List<String>ans= Collections.singletonList(list.stream()
                .reduce((x, y) -> x.length() < y.length() ? x : y).get());
        System.out.println(ans);

        //Problem 46
        //First Non-Repeated Character in a String
        String input="Java articles are Awesome";
        Optional<Character> result=input.chars()
                .mapToObj(c->(char)c)
                .filter(ch->input.indexOf(ch)==input.lastIndexOf(ch))
                .findFirst();
        System.out.println(result);

        //Problem 47
        //Find the frequency of each character in a string
        String input=" java8streamis strem prallel is  diffrent ";
        Map<Character, Long> frequencyMap=input.chars()                 // Convert the String to an IntStream
                .mapToObj(c -> (char) c) // Convert each int to a Character object
                .collect(Collectors.groupingBy(   // Group by the character
                        Function.identity(),          // Identity function to group by the character itself
                        Collectors.counting()));
        System.out.println(frequencyMap);

        //Problem 48
        //Group strings by their length
        List<String>list=Arrays.asList("Ans","Abc","BBBB","bdaa");
        Map<Integer,List<String>>ans=list.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(ans);



    }
}
