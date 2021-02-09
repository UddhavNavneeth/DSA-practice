// link to the question:
// https://leetcode.com/problems/buddy-strings/solution/

// I don't like how I have solved it

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        
        int counter = 0;
        int flag = 0;
        char let1 = ' ';
        char let2 = ' ';
        
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) != B.charAt(i) && flag == 0) {
                flag = 1;
                counter++;
                let1 = A.charAt(i);
                let2 = B.charAt(i);
            }
            
            else if (A.charAt(i) != B.charAt(i) && flag == 1) {
                if (counter > 1) {
                    System.out.println("counter+");
                    return false;
                }
                counter++;
                if (A.charAt(i) != let2 || B.charAt(i) != let1) {
                    // System.out.println("mismatch+ "+let1+" "+let2);
                    return false;
                }
            }
        }
        
        if (flag == 0) {
            int[] chars = new int[26];
            for (int i=0; i<A.length(); i++) {
                chars[A.charAt(i)-'a']++;
                if (chars[A.charAt(i)-'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
        
        if (flag == 1 && counter == 1) {
            return false;
        }
        return true;
    }
}