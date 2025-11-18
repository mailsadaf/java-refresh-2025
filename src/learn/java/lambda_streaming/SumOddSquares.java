package learn.java.lambda_streaming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumOddSquares {

    public static void main(String [] args){
        List<Integer> numbers = Arrays.asList(3,1,2,88,10);

        List<Integer> oddNumbers = numbers.stream().filter(number-> number%2==1).collect(Collectors.toList());
        System.out.println(oddNumbers);
        Integer sumSquares = oddNumbers.stream().map(n-> n*n).reduce(0,Integer::sum);
        System.out.println(sumSquares);
    }
}
