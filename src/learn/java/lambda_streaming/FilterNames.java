package learn.java.lambda_streaming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FilterNames {
    public static void main(String [] args){
        List<String> names = Arrays.asList("Sadaf","Stefan","Amelio","Simon","Simone","Cilia");
        List<String> upperCaseNames = names.stream().map(name-> name.toUpperCase(Locale.ROOT)).collect(Collectors.toList());
        List<String> sNames = upperCaseNames.stream().filter(name->name.startsWith("S")).collect(Collectors.toList());
        Collections.sort(sNames);
        sNames.forEach(name ->System.out.println(name));
    }
}
