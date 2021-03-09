
package app;

import java.util.regex.*;

public class StringCalculator {
    public static int add(String text) {
        if(text.equals("")==true)
            return 0;
        else{
            int sum = 0;
            String nums[] = {};
            String finalDelim = "";

            if (text.startsWith("//")){
                String delim = text.substring(2, text.indexOf("\n"));
                Pattern pt = Pattern.compile("\\[(.*?)\\]");
                Matcher match = pt.matcher(delim);
                while(match.find()){
                    finalDelim = finalDelim + Pattern.quote(match.group(1)) + "|";
                }
                if(finalDelim.equals(""))
                    nums = text.substring(text.indexOf("\n")+1).split(Pattern.quote(delim));
                else{
                    nums = text.substring(text.indexOf("\n")+1).split(finalDelim.substring(0,finalDelim.length()-1));
                }
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
