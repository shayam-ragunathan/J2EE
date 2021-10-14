package sample.entity;

import java.math.BigDecimal;

class AtoiFunc {
    public static int myAtoi(String s) {
    	
    	if (s.trim().isEmpty())
    		return 0;
        String localString = s.replaceAll("[^\\d]", " ");
        if (localString.trim().isEmpty())
    		return 0;
        BigDecimal output;
        char[] sign;
        sign=s.trim().toCharArray();
        if (sign[0] != '-')
        	 
        	if (sign[0] == '+')
        	{
        		if (!Character.isDigit(sign[1]))
            		return 0;
        		else
        			sign[0]=' ';
        	}
        	else
        	{
        		
        	if (Character.isDigit(sign[0]))
        		sign[0]=' ';
        	else 
        		return 0;
        	}
        else
        	if (!Character.isDigit(sign[1]))
        		return 0;
        		
        	
        	

    	String[] localStringArray = localString.trim().split(" ");
    	
    	try
    	{
    		localString = sign[0]+localStringArray[0];
    	output = new BigDecimal(localString.trim());
    	
    	if (output.compareTo(new BigDecimal(Math.pow(-2, 31))) <0)
    		output = new BigDecimal(Math.pow(-2, 31));
    	else if (output.compareTo(new BigDecimal(Math.pow(2, 31)-1)) >0)
    		output = new BigDecimal(Math.pow(2, 31)-1);
    	
    	}
    	catch(NumberFormatException e)
    	{e.printStackTrace();
    		return 0;}
    	
        return output.intValue();
    	
        
    }
    public static void main(String arg[])
    {
    	
    	
    	int output = AtoiFunc.myAtoi("+1");
    	System.out.println(output);
    }
    
    
    
    
    
	}