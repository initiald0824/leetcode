import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1：
 *  输入："abcabcbb"
 *  输出：3
 *  解释：因为无重复字符的最长子串是"abc",所以其长度为3
 * 示例2：
 *  输入："bbbbb"
 *  输出：1
 *  解释：因为无重复字符的最长子串是"b",所以其长度为1
 * 示例3：
 *  输入："pwwkew",
 *  输出：3
 *  解释：因为无重复字符的最长子串是"wke",所以其长度为3。
 *       请注意：你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。
 */

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> characterPosition = new HashMap<>();
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterPosition.containsKey(c) && characterPosition.get(c) >= start) {
                maxLength = Math.max(i-start, maxLength);
                start = characterPosition.get(c) + 1;
            }
            characterPosition.put(c, i);
        }
        maxLength = Math.max(i-start, maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
