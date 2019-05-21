package com.grenader.facebook;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ikanshyn on 2014-07-28.
 */
public class ProfileScannerNew {


    public Set<String> parseURLs(String content) {
        return parse(content, "(https://www.facebook\\.com/(.*?))\"");
    }

    public Set<String> parseNames(String content) {
//        return parse(content, "}}\">((.*?)</a></div>)");
//                              https://www.facebook.com/svetlana.morozova.710?fref=pb&amp;hc_location=profile_browser
//                              https://www.facebook.com/profile.php?id=100006768407665&amp;fref=pb&amp;hc_location=profile_browser
        return parse(content, "(https://www.facebook.com/(?:.*))(?:(?:\\?)|(?:&amp;))fref=pb&amp;hc_location=profile_browser");
//        return parse(content, "com(.*)&amp");
    }

//    (?:?|(&amp;))

    public Set<String> parse(String content, String regExp) {

        Set<String> res = new LinkedHashSet<String>();

        Pattern p = Pattern.compile(regExp);

        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            int count = matcher.groupCount();
//            System.out.println("group count is " + count);
//            for (int i = 1; i <= count; i++) {

                String value = matcher.group(1);
            res.add(value);

/*
                value = value.replace("</a></div>", "");
                value = value.replace("}}\">", "");
                if (!value.contains("profile.php?id=")) {
                    if (value.indexOf("?") > -1)
                    value = value.substring(0, value.indexOf("?"));
//                    System.out.println(value);
                    res.add(value);
                }
*/
            }
//        }


        System.out.println("\n\n");

        for (String url : res) {
            System.out.println(url);
        }

        return res;
    }
}
