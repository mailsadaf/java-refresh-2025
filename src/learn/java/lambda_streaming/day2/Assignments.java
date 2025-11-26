package learn.java.lambda_streaming.day2;

import java.util.*;
import java.util.stream.Collectors;

public class Assignments {
    public static void main(String[] args) {
        System.out.println(groupNames(Arrays.asList("Sadaf", "Albert", "Anna", "Bob", "Charles", "Cory")));
        System.out.println(countFrequency(Arrays.asList("Sadaf", "Albert", "Anna", "Bob", "Charles", "Cory", "Sadaf", "Sadaf", "Bob")));
        System.out.println(avgLength(Arrays.asList("Sadaf", "Albert", "Anna", "Bob", "Charles", "Cory", "Sadaf", "Sadaf", "Bob", "Angus")));
        Person sadaf = new Person("Sadaf",47);
        Person chuck = new Person("Chuck",47);
        Person boy = new Person("Bob",17);
        Person woman = new Person("Tiara",47);
        Person senior = new Person("Bob",78);
        System.out.println(sortPersons(Arrays.asList(sadaf,chuck,boy,senior,woman)));

        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        System.out.println(flatten(nested));


    }

    private static List<Integer> flatten(List<List<Integer>> nested) {
        return nested.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    private static List sortPersons(List<Person> people) {
        return people.stream().sorted((p1,p2)-> comparePeople(p1, p2)).collect(Collectors.toList());
    }

    private static int comparePeople(Person p1, Person p2) {
        if (p1.getAge().compareTo(p2.getAge())!=0) {
            return p2.getAge() .compareTo(p1.getAge());
        }
        return p2.getName().compareTo(p1.getName());
    }

    private static double avgLength(List<String> words) {
        Long totalLength = 0l;
        totalLength = words.stream().mapToLong(word -> word.length()).sum();
        //System.out.println(totalLength);
        //System.out.println(((Integer)words.size()).doubleValue());
        return totalLength / ((Integer) words.size()).doubleValue();
    }

    private static Map<String, Long> countFrequency(List<String> words) {
        Map<String, Long> returnable = new HashMap<>();
        words.stream().forEach(word -> incrementEntry(word, returnable));
        return returnable;

    }

    private static void incrementEntry(String word, Map<String, Long> returnable) {
        if (returnable.get(word) == null) {
            returnable.put(word, 1l);
        } else returnable.put(word, returnable.get(word) + 1l);
        //System.out.println(returnable);
    }

    private static Map<Character, List<String>> groupNames(List<String> nameList) {
        List<Character> allLetters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        Map<Character, List<String>> returnable = new HashMap<>();
        nameList.stream().forEach(name -> addNameToGrp(name, returnable));
        return returnable;
    }

    private static void addNameToGrp(String name, Map<Character, List<String>> returnable) {
        List<String> bucket = returnable.get(name.toUpperCase(Locale.ROOT).charAt(0));
        if (bucket == null) {
            bucket = new ArrayList<>();
            returnable.put(name.toUpperCase(Locale.ROOT).charAt(0), bucket);
        }
        bucket.add(name);
    }


}
