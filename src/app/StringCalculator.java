
package app;
public class StringCalculator {
    public static int add(String text) {
        if(text.equals("")==true)
            return 0;
        else{
            int sum = 0;
            String nums[] = {};
            if (text.startsWith("//")){
                String delim = text.substring(2, text.indexOf("\n"));
                nums = text.substring(text.indexOf("\n")+1).split(delim);
            }
            else{
                nums = text.split("[,\n]");
            }

            for (String s : nums) {
                sum += Integer.parseInt(s);
            }
            return sum;
        }
    }
}
