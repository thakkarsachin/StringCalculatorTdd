
package app;
public class StringCalculator {
    public static int add(String text) {
        if(text.equals("")==true)
            return 0;
        else{
            String nums[] = text.split(",");
            if(nums.length==1)
                return Integer.parseInt(nums[0]);
            else 
                return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
        }
    }
}
