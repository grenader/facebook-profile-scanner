package com.grenader.facebook.vk;

import com.grenader.BaseSearcherTest;
import com.grenader.facebook.ProfileScannerNew;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PeopleSearcherTest extends BaseSearcherTest {

    @Test
    public void testParseNames2Full2() throws IOException {
        Set<PersonPair> list = new PeopleSearcher().findPeopleDetails(
                readFile("/Users/ikanshyn/IdeaProjects/ProfileScaner/src/com/grenader/facebook/vk/vk1.html"));

        for (PersonPair pair : list) {
            System.out.println(pair.getFullLink() + "\t" + pair.getCanonicalName());
        }

        assertEquals(277, list.size());
    }

}