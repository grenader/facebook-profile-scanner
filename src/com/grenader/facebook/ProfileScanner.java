package com.grenader.facebook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ikanshyn on 2014-07-28.
 */
public class ProfileScanner {


    public Set<String> parseURLs(String s) {
        return parse(s, "(https://www.facebook\\.com/(.*?))\"");
    }

    public Set<String> parseNames(String content) {
        return parse(content, "}}\">((.*?)</a></div>)");
    }

    public Set<String> parse(String content, String regExp) {

        Set<String> res = new LinkedHashSet<String>();

        Pattern p = Pattern.compile(regExp);

        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            int count = matcher.groupCount();
//            System.out.println("group count is " + count);
            for (int i = 0; i < count; i++) {

                String value = matcher.group(i);
                value = value.replace("</a></div>", "");
                value = value.replace("}}\">", "");
                if (!value.contains("profile.php?id=")) {
                    if (value.indexOf("?") > -1)
                    value = value.substring(0, value.indexOf("?"));
//                    System.out.println(value);
                    res.add(value);
                }
            }
        }


        System.out.println("\n\n");

        for (String url : res) {
            System.out.println(url);
        }

        return res;
    }
}
