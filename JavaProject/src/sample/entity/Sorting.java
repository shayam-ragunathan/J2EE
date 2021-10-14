package sample.entity;

import java.util.Scanner;

public class Sorting {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String temp = "";
        int l,m=0;
        String[] stringList = new String[50000];
        char[] charS = s.toCharArray();
        for (int i=0;i<charS.length;i++)
        {

            temp=Character.toString(charS[i]);
            l=1;
            for (int j=i+1;j<charS.length;j++)
            {
                if (l==k)
                    break;
                temp =temp + Character.toString(charS[j]);

                l=l+1;
            }
            if (temp.length() == k)
            {
               stringList[m]=temp;
               m= m+1;
            }
            temp="";
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (stringList[i].compareToIgnoreCase(stringList[j])
                    > 0) {
                    String ltemp = stringList[i];
                    stringList[i] = stringList[j];
                    stringList[j] = ltemp;
                }
            }
        }
        smallest = stringList[0];
        largest  = stringList[m-1];
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}