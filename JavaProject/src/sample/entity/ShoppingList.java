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
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codeList
     *  2. STRING_ARRAY shoppingCart
     */

    public static int foo(List<String> codeList, List<String> shoppingCart) {
    // Write your code here
    List<String> codes;
    int output =0;
    boolean found =false;
    try{
    for(int i=0;i< codeList.size();i++)
    {
       codes = new ArrayList<>(Arrays.asList(codeList.get(i).split(" ")));
       

           for (int k=0;k<shoppingCart.size();k++)
           {
            for (int j=0 ;j< codes.size();j++)
            {
               if (shoppingCart.get(k).equalsIgnoreCase(codes.get(j)) || codes.get(j).equals(new String ("anything")))
               {
                   found= true;
                   shoppingCart.remove(k);
                   codes.remove(j);
                   continue;
                   
               }
               else
               {
                 found= false;
                 shoppingCart.remove(k);
                 j--;
               }
           }
           break;
       }
       
    }
   }
   catch(Exception E)
   {
       found= false;
   }
    if (found)
       output=1;
    else
       output=0;
    
    return output;
    }

}

public class ShoppingList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int codeListCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> codeList = new ArrayList<>();

        for (int i = 0; i < codeListCount; i++) {
            String codeListItem = bufferedReader.readLine();
            codeList.add(codeListItem);
        }

        int shoppingCartCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> shoppingCart = new ArrayList<>();

        for (int i = 0; i < shoppingCartCount; i++) {
            String shoppingCartItem = bufferedReader.readLine();
            shoppingCart.add(shoppingCartItem);
        }

        int result = Result.foo(codeList, shoppingCart);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
