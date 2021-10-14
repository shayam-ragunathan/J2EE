package sample.entity;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
    // Write your code here
    char[] customerQurChar = customerQuery.toCharArray();
    List<List<String>> outputList = new ArrayList<List<String>>(); 
    List<String> sugesstedList = new ArrayList<>();
    String searchString = Character.toString(customerQurChar[0]);

        for (int j=1;j<customerQurChar.length;j++)
        {
            searchString = searchString + Character.toString(customerQurChar[j]);
            sugesstedList = new ArrayList<>();
            for (int k=0; k<repository.size();k++)
            {
                if (repository.get(k).indexOf(searchString) >= 0)
                {
                    sugesstedList.add(repository.get(k));
                }
                    
            }
            Collections.sort(sugesstedList);
            for (int k=2;k<sugesstedList.size();k++)
            {
                sugesstedList.remove(k);
            }
            outputList.add(sugesstedList);
            //System.out.println(outputList);
            sugesstedList =null;
        }
    
    return outputList;

    }

}

public class SugestionBox {
    public static void main(String[] args) throws IOException {

        List<String> repository = new ArrayList<>();



        String customerQuery = "mouse";
        repository.add("mouse");
        repository.add("mobile");
        repository.add("model");
        repository.add("mosers");
        repository.add("moondru");
        

        List<List<String>> result = Result.searchSuggestions(repository, customerQuery);
        System.out.println(result);

        

    }
}
