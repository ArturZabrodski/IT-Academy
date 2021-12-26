package exam.ex5;

import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfWords {

    public static int numberOfUniqueWords(String str) {
        return countingUniqueWords(removeExtraChar(str));
    }

    // remove all unnecessary, leaving only the words and one space between them
    public static String removeExtraChar(String str) {

        str = str.trim();
        str = str.replaceAll("\\p{Punct}", " ");
        str = str.replaceAll("\\d", " ");
        str = str.replaceAll("[\\s]{2,}", " ");

        return str;
    }

    public static int countingUniqueWords(String str) {
        Set<String> set = new HashSet<>();

        int startIndex = 0;

        // we use HashSet to avoid duplicate words
        for (int i = 2; i <= str.length(); i++) {
            if (str.charAt(i - 1) == ' ') {
                set.add(str.substring(startIndex, i - 1).toLowerCase());
                startIndex = i;
            }
        }
        return set.size();
    }
}

