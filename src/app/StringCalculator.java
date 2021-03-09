
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
                if(delim.charAt(0)=='[' && delim.charAt(delim.length()-1)==']')
                    delim = delim.substring(1,delim.length()-1);
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
                else if(num <= 1000)
                    sum += num;
            }
            if (!negatives.equals(""))
                throw new RuntimeException("negatives not allowed : "+negatives.substring(0, negatives.length()-1));
            return sum;
        }
    }
}
