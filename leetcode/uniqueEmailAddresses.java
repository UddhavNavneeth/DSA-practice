// Link to the question
// https://leetcode.com/problems/unique-email-addresses/submissions/

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        
        for (int i=0; i<emails.length; i++) {
            String str = "";
            String[] firstSplit = emails[i].split("@");
            
            str += firstSplit[1];
            
            String[] secondSplit = firstSplit[0].split("\\+");
            
            String str2 = "";
            for (int j=0; j<secondSplit[0].length(); j++) {
                if (secondSplit[0].charAt(j) != '.') {
                    str2 += secondSplit[0].charAt(j);    
                }
            }
            
            str = str2 + '@' + str;
            set.add(str);
        }
        
        System.out.println(set);
        return set.size();
    }
}