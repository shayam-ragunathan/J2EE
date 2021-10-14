package sample.entity;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        boolean found= false;
        
        for (int i=0;i<nums.length;i++)
        {
            output[0]=i;
            for (int j=i+1;j<nums.length;j++)
            {
                if (target == nums[i]+nums[j])
                {
                    output[1]=j;
                    found =true;
                    break;
                }
            }
            if (found)
                break;
            
        }
        return output;
        
    }
    public static void main(String arg[])
    {
    	int[] nums = {3,2,4};
    	int target = 6;
    	
    	int[] output = TwoSum.twoSum(nums, target);
    	System.out.println(output[0]+" "+output[1]);
    }
    
    
    
    
    
	}