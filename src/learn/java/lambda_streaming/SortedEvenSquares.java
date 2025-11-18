package learn.java.lambda_streaming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedEvenSquares {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3,10,1,20,5,6);
        List<Integer> evenInputs = input.stream().filter(n->n%2==0).collect(Collectors.toList());
        Collections.sort(evenInputs);
        evenInputs.forEach(evenInt-> System.out.println(evenInt*evenInt));
    }
}
