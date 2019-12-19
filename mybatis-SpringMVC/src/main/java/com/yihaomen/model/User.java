package com.yihaomen.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private int id;
    private String userName;
    private String userAge;
    private String userAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<String> setString = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            setString.add(s.substring(i, i + 1));
        }

        for (int i = setString.size(); i > 1; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                String newString = s.substring(j, i + j);
                if (validateRepetition(newString)) {
                    return newString.length();
                }
            }
        }
        return setString.size();
    }

    private static boolean validateRepetition(String newString) {
        Set<String> setString2 = new HashSet<>();

        for (int k = 0; k < newString.length(); k++) {
            setString2.add(newString.substring(k, k + 1));
        }
        return setString2.size() == newString.length();
    }

    public static int a = 0;
    public static int b = 0;

    public static String longestPalindrome(String s) {
        String s2 = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {

            for(int j = 0; i-j>=0 && i+j<s.length(); j++){
                if(!(s.charAt(i-j)==s.charAt(i+j))){
                    break;
                }
                maxLength = Math.max(maxLength,2*j+1);
            }

            for(int j = 0; i-j>=0 && i+j+1<s.length(); j++){
                if(!(s.charAt(i-j)==s.charAt(i+j+1))){
                    break;
                }
                maxLength = Math.max(maxLength,2*j+2);
            }
        }
        System.out.println("maxLength:"+maxLength);
        return s2;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(
            "cbbd"));
    }

}
