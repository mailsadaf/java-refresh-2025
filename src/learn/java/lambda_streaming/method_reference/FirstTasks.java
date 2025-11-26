package learn.java.lambda_streaming.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FirstTasks {
    public static void main(String [] args){
        Function<Integer,String> intToStr = String::valueOf;
        System.out.println(intToStr.apply(67)+"76");

        List<String> words = Arrays.asList("apple","banana","carrot");
        words.forEach(System.out::println);


        Supplier<List<String>> listCreator = ArrayList::new;
        List created = listCreator.get();
        words.forEach(created::add);

        System.out.println(created);
    }
}
