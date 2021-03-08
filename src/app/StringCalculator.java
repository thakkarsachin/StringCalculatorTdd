
package app;
public class StringCalculator {
    public static int add(String text) {
        if(text.equals("")==true)
            return 0;
        else{
            int sum = 0;
            String nums[] = text.split(",");
            for (String s : nums) {
                sum += Integer.parseInt(s);
            }
            return sum;
        }
    }
}
