package learn.java.lambda_streaming.level3;

import learn.java.lambda_streaming.day2.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsLevel3 {
    public static void main(String [] args) {
        List<Person> people = List.of(
                new Person("Sadaf", 47),
                new Person("Aman", 30),
                new Person("Bill", 30),
                new Person("Sara", 25),
                new Person("John", 40),
                new Person("Samir", 30)
        );

        Map<String,List<Person>> charGrp = people.stream().collect(Collectors.groupingBy(person -> person.getName().toUpperCase(Locale.ROOT).substring(0,1)));
        System.out.println(charGrp);

        Map<Boolean,List<Person>> oldAndYoung = people.stream().collect(Collectors.partitioningBy(person -> person.getAge()>30));
        System.out.println(oldAndYoung);

        Map<Integer,List<String >> charGrpNames = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println(charGrpNames);

        String allNames = people.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(allNames);

        Map<Integer,Long> ageCounts = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
        System.out.println(ageCounts);

        Map<String,Optional<Person>> oldestInEachAge = people.stream().collect(Collectors.groupingBy(person -> person.getName().toUpperCase(Locale.ROOT).substring(0,1),Collectors.maxBy(Comparator.comparing(Person::getAge))));
        System.out.println(oldestInEachAge);

        Map<Integer,Map<Integer,List<Person>>> op = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.groupingBy(p->p.getName().length())));
        System.out.println(op);
    }
}
