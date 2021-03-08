
package app;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String text) {
        if(text.equals("")==true)
            return 0;
        else{
            int sum = 0;
            String nums[] = {};
            if (text.startsWith("//")){
                String delim = text.substring(2, text.indexOf("\n"));
                nums = text.substring(text.indexOf("\n")+1).split(Pattern.quote(delim));
            }
            else{
                nums = text.split("[,\n]");
            }

            String negatives = "";
            for (String s : nums) {
                int num = Integer.parseInt(s);
                if(num<0){
                    negatives += (Integer.toString(num)+" ");
                    continue;
                }
                sum += num;
            }
            if (!negatives.equals(""))
                throw new RuntimeException("negatives not allowed : "+negatives.substring(0, negatives.length()-1));
            return sum;
        }
    }
}
