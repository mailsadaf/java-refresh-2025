package learn.java.lambda_streaming;

import java.util.Arrays;
import java.util.List;

public class UniqueWords {
    public static void main(String [] args){
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "kiwi");
        strings.stream().distinct().forEach(s-> System.out.println(s));

    }
}
