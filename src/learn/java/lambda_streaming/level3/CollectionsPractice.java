package learn.java.lambda_streaming.level3;

import learn.java.lambda_streaming.day2.Person;

import java.util.*;
import java.util.stream.Collectors;

//Practice Set A
public class CollectionsPractice {

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Sadaf", 47, "Berlin"), new Person("Aman", 30, "Munich"),
                new Person("Bill", 30, "Stuttgart"), new Person("Sara", 25, "Munich"), new Person("John", 40, "Berlin"),
                new Person("Samira", 30, "Munich"));

//A1
        /*Map<String, List<Person>> grpByCity = people.stream().collect(Collectors.groupingBy(Person::getCity));
        System.out.println(grpByCity);

//A2
        Map<Boolean, List<Person>> munichersAndNot = people.stream().collect(Collectors.partitioningBy(p -> p.getCity().equalsIgnoreCase("Munich")));
        System.out.println(munichersAndNot);

//A3
        Map<String, List<String>> namesByCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.mapping(p->p.getName(),Collectors.toList())));
        System.out.println(namesByCity);

//A4
        Map<String, Long> countByCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.counting()));
        System.out.println(countByCity);

        Map<String, Double> ageByCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.averagingDouble(Person::getAge)));
        System.out.println(ageByCity);

        Map<String, Optional<Person>> oldestByCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.maxBy((p1,p2)->p1.getAge()-p2.getAge())));
        System.out.println(oldestByCity);

        //System.out.println(people.stream().collect(Collectors.counting(p->p.getCity())));

        //B1
        Map<String,Map<Character,List<Person>>> grpByFirstNameCharInCityGroup = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.groupingBy(p->p.getName().charAt(0),Collectors.toList())));
        System.out.println(grpByFirstNameCharInCityGroup);

        //B2
        Map<Integer,List<String>> namesInAgeGrps = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.toList())));
        System.out.println(namesInAgeGrps);

        Map<String,Map<Integer,Long>> countByAgeInCities = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.groupingBy(Person::getAge,Collectors.counting())));
        System.out.println(countByAgeInCities);

        Map<String,Optional<Person>> youngestInCities = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.minBy(Comparator.comparing(Person::getAge))));
        System.out.println(youngestInCities);

        Map<String,String > namesByCities = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.mapping(Person::getName,Collectors.joining(", "))));
        System.out.println(namesByCities);

        //C1 - city with highest average age
        Map<String,Double> cityAverageAges =people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.averagingInt(p->p.getAge())));
        Optional<String> cityWithMaxAvgAge = cityAverageAges.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        System.out.println(cityWithMaxAvgAge);

    //C2 — Produce a Map<String, IntSummaryStatistics> per city
        Map<String, IntSummaryStatistics> cityStats =people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.summarizingInt(Person::getAge)));
        System.out.println(cityStats);

        //C3 — Group by city → but inside extract only the oldest name (String)
        Map<String,String> oldestInEachCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getAge)),person -> person.get().getName())));
        System.out.println(oldestInEachCity);

        //C4 — Given a List<List<Person>>, flatten it and produce one combined List<Person>
        List<Person> morePeople = List.of(new Person("Saif", 45, "San Jose"), new Person("Nayeema", 44, "Leonberg"),
                new Person("Parul", 47, "SanJose"), new Person("Aastha", 25, "Dumphries"), new Person("Shabana", 47, "Chicago"),
                new Person("Sonu", 27, "Raleigh"));

        List<List<Person>> peopleList = List.of(people,morePeople);
        List<Person> flatList = peopleList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);

        //C5 — Custom collector: Compute the total age of all people manually
        Integer totalAge = people.stream().collect(()->new int[1],(arr,p)->arr[0]+=p.getAge(),(arr1,arr2)->arr1[0]+=arr2[0])[0];
        System.out.println(totalAge);*/

        //D1 — Group by city, but inside sort the people by age descending
        Map<String, List<Person>> sortedInEachCity = people.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.collectingAndThen(Collectors.toList(),
                        p -> p.stream().sorted(Comparator.comparing(Person::getAge).reversed()).toList())));
        System.out.println(sortedInEachCity);

        //D2 — Build a map city → comma-separated sorted list of names
        Map<String, String> sortedNamesInEachCity = people.stream().collect(Collectors.groupingBy(Person::getCity,
                Collectors.mapping(Person::getName,Collectors.collectingAndThen(Collectors.toList(),p->p.stream().sorted().collect(Collectors.joining(", "))))));
        System.out.println(sortedNamesInEachCity);

        //D3 — For each city, count how many distinct ages appear
        Map<String, Integer> distinctAgesByCity = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.collectingAndThen(Collectors.mapping(Person::getAge, Collectors.toSet()), s -> s.size())));
        System.out.println(distinctAgesByCity);

        //D4 — Group by age → inside collect only the cities, but unique and sorted
        Map<Integer, List<String>> sortedCitiesForEachAge = people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getCity,Collectors.collectingAndThen(Collectors.toSet(),cities->cities.stream().sorted(String::compareTo).collect(Collectors.toList())))));
        System.out.println(sortedCitiesForEachAge);

        //D5 — Produce a flat list of all unique characters used in all names
        List<Character> o = people.stream().flatMap(person -> person.getName().toLowerCase(Locale.ROOT).chars().mapToObj(c->(char)c)).distinct().sorted().toList();
        System.out.println(o);

        //D6 — Group by first letter of city → find the average age for that group
        Map<Character,Double> avgAgeByFirstChar = people.stream().collect(Collectors.groupingBy(p->p.getCity().charAt(0),Collectors.averagingInt(Person::getAge)));
        System.out.println(avgAgeByFirstChar);

        //D7 — For each city, produce the set of name lengths
        Map<String,Set<Integer>> nameLengthsByCity = people.stream().collect(Collectors.groupingBy(Person::getCity,Collectors.mapping(p->p.getName().length(),Collectors.toSet())));
        System.out.println(nameLengthsByCity);
    }
}
