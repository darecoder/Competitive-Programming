package com.company._04_Backtracking;
import java.util.Arrays;

public class CryptoArithmetic {
    public static String s1 = "send", s2 = "more", s3 = "money";

    public static void main(String[] args) {
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        String s4 = s1 + s2 + s3;

        // find and remove duplicate characters
        for (int i = 0; i < s4.length(); i++) {
            arr[s4.charAt(i) - 'a']++; // incrementing associated index of an alphabet. E.g for 'c', index 2 will be incremented, as 'a' starts on 0 index.
        }

        StringBuilder s5 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                s5.append((char) (i + 'a'));
        }
        if (s5.length() > 10) {
            System.out.println("No Combination possible. Combined unique elements more than 10");
        }

        int[] map = new int[26];

        //    setting the mapping array to default value of -1
        for (int i = 0; i < 26; i++)
            map[i] = -1;

        System.out.println(solveCrypto(s5.toString(), 0, map));
    }

    public static int solveCrypto(String str1, int bit_num, int[] mapping)
    {
        if (str1.length() == 0) // When all letters of the combined input string has been computed upon...
        {
            if (mapping[s1.charAt(0) - 'a'] != 0 &&
                    mapping[s2.charAt(0) - 'a'] != 0 &&
                    mapping[s3.charAt(0) - 'a'] != 0) {
                if (stringValue(s1, mapping) + stringValue(s2, mapping) == stringValue(s3, mapping)) {
                    for (int i = 0; i < 26; i++) {
                        if (mapping[i] != -1) {
                            System.out.println((char)(i + 'A') + '=' + mapping[i] + "  ");
                        }
                    }
                    System.out.println();
                    return 1;
                }
            }
            return 0;
        }

        int count = 0;
        for (int num = 0; num <= 9; num++) {
            if ((bit_num & (1 << num)) == 0) {
                mapping[str1.charAt(0) - 'a'] = num;
                bit_num ^= (1 << num);
                // maps str[0] to num and send all the remaining string,
                // i.e. str.substring(0) for next calculations.
                count += solveCrypto(str1.substring(1), bit_num, mapping);
                mapping[str1.charAt(0) - 'a'] = -1;
                bit_num ^= (1 << num);
            }
        }
        return count;
    }

    public static int stringValue(String str1, int[] map) {
        int res = 0;
        for (int i = 0; i < str1.length(); i++) {
            res = res * 10 + map[str1.charAt(i) - 'a'];
        }
        return res;
    }
}
