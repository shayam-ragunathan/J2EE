package javaproject;

import java.util.ArrayList;
import java.util.List;

public class Descendingstring {

	public static void main(String[] args) {
		int max=0;
		String a="DDDSSSABBBBNNMMMKKK";
		List<String> list = new ArrayList<>();
		// TODO Auto-generated method stub
		char[] charA= a.toCharArray();
		
		String temp=Character.toString(charA[0]) ;
		for (int i=1;i<charA.length;i++)
			if(charA[i-1] <= charA[i])
				temp = temp + Character.toString(charA[i]) ;
			else
			{
				list.add(temp);
				temp = Character.toString(charA[i]);
			}
		
		System.out.println(list);
		for (String alist:list)
			if(alist.length() > max)
				max = alist.length();
		System.out.println(max);
			
	}
		
}
