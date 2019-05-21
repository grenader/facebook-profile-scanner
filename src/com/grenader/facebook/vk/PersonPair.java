package com.grenader.facebook.vk;

/**
 * Created by ikanshyn on 16-08-12.
 */
public class PersonPair implements Comparable {

    public static final String HTTPS_NEW_VK_COM = "https://new.vk.com/";
    private String link;
    private String name;

    public PersonPair(String link, String name) {
        this.link = link;
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public String getFullLink() {
        return HTTPS_NEW_VK_COM +link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getCanonicalName() {
        if (name.indexOf("</a></div>") != -1)
            return name.substring(0, name.indexOf("</a></div>"));
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonPair{" +
                "link='" + link + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonPair that = (PersonPair) o;

        if (link != null ? !link.equalsIgnoreCase(that.link) : that.link != null) return false;
        if (name != null ? !name.equalsIgnoreCase(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = link != null ? link.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        PersonPair pair = (PersonPair) o;
        return name.compareTo(pair.getName());
    }
}
