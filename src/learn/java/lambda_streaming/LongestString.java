package learn.java.lambda_streaming;

import java.util.Arrays;
import java.util.List;

public class LongestString {
    public static void main(String[] args){
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "bananas", "kiwi");
        System.out.println(strings.stream().max((s1,s2)->s1.length()-s2.length()));
    }
}
