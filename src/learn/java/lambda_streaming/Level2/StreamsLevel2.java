package learn.java.lambda_streaming.Level2;

import learn.java.lambda_streaming.day2.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsLevel2 {

    public static void main(String [] args) {
        List<Person> people = Arrays.asList(
                new Person("Sadaf", 47),
                new Person("Aman", 30),
                new Person("Sara", 25),
                new Person("John", 40),
                new Person("Samir", 30)
        );

        List<Person> olderThan30 = people.stream().filter(p-> p.getAge()>30).collect(Collectors.toList());
        System.out.println(olderThan30);
        List<Person> sorted =people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());
        System.out.println(sorted);

        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names);

        Person oldest = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList()).get(people.size()-1);

        oldest = people.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
        System.out.println(oldest);

        Map<Integer,List<Person>> map = new HashMap<Integer,List<Person>>();
        people.stream().forEach(person ->map.computeIfAbsent(person.getAge(),age->new ArrayList<>()).add(person));
        System.out.println(map);

    }
}
