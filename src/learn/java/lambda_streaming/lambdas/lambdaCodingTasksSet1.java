package learn.java.lambda_streaming.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class lambdaCodingTasksSet1 {
    public  static void main(String[] args){
        Function<Integer,Integer> multiplyBy5=n->n*5;
        System.out.println(multiplyBy5.apply(10));

        Predicate<Integer> isEven = integer -> integer%2==0;
        System.out.println(isEven.test(68));
        System.out.println(isEven.test(683));

        Consumer<String> printer = System.out::println;
        Arrays.asList("Name1","Age","Another").stream().forEach(printer);
    }
}
