package com.grenader.facebook.vk;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ikanshyn on 16-08-12.
 */
public class PeopleSearcher {
    public Set<PersonPair> findPeopleDetails(String content) {

        String regExp = "<a href=\"/(.*)\" onclick=\"return nav.go\\(this, event\\);\">(.*)</a></div>";


        Set<PersonPair> res = new TreeSet<PersonPair>();


        Pattern p = Pattern.compile(regExp);

        Matcher matcher = p.matcher(content);
        while (matcher.find()) {
            int count = matcher.groupCount();

            String link = matcher.group(1);
            String name = matcher.group(2);
            res.add(new PersonPair(link, name));
        }


        System.out.println("\n\n");

        for (PersonPair url : res) {
            System.out.println(url);
        }

        return res;    }
}
