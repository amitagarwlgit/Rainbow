package algo.arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = "";

        if (strs.length == 0 || strs == null) {
            return longestCommonPrefix;
        }

        int index = 0;
        while (index < strs[0].length()) {
            String commonCharAtIndex = getCommonPrefixAtIndex(strs, index);
            if (commonCharAtIndex.equals("")) {
                return longestCommonPrefix;
            } else {
                longestCommonPrefix += commonCharAtIndex;
            }
            index++;
        }
        return longestCommonPrefix;
    }

    private String getCommonPrefixAtIndex(String[] strs, int index) {
        char commonCharAtIndex = strs[0].charAt(index);

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() <= index) return "";
            if (strs[i].charAt(index) != commonCharAtIndex) return "";
        }
        return String.valueOf(commonCharAtIndex);
    }
}
