package com.lpnu.iot.term2.lab7;

import java.util.regex.Pattern;

public class StringNegativeNumberReplacer {

    public StringNegativeNumberReplacer() {

    }

    public String getModifiedString(String original) {
        String modified = original;

        var pattern =  Pattern.compile("-\\d+");
        var matcher  =  pattern.matcher(original);

        // needed because positive numbers are 1 character smaller than negative
        int offset = 0;

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            var replaced = modified.substring(start - offset + 1, end - offset);
            replaced =  new StringBuffer(replaced).reverse().toString();

            modified =
                      modified.substring(0, start -  offset)
                    + replaced
                    + modified.substring(end - offset, modified.length());

            offset++;
        }

        return modified;
    }
}
