// Link to the question:
// https://leetcode.com/problems/fruit-into-baskets/submissions/

class Solution {
    public int totalFruit(int[] tree) {
        int num1 = tree[0];
        int num1Last = 0;
        
        int num2 = -1;
        int num2Last = -1;
        
        for (int i=1; i<tree.length; i++) {
            if (tree[i] != num1) {
                num2 = tree[i];
                num2Last = i;
                num1Last = i-1;
                break;
            }
        }
        
//         All identical numbers, so no value assigned to num2
        if (num2 == -1) {
            return tree.length;
        }
        
        int len = num2Last-0+1;
        int maxLen = len;
        
        for (int i=num2Last+1; i<tree.length; i++) {
            if (tree[i] == num1) {
                len++;
                num1Last = i;
            }
            else if (tree[i] == num2) {
                len++;
                num2Last = i;
            }
            else {
                if (num1Last > num2Last) {
                    num2 = tree[i];
                    len = i - num2Last;
                    num2Last = i;
                }else {
                    num1 = tree[i];
                    len = i - num1Last;
                    num1Last = i;
                }
            }
            
            if (len > maxLen) {
                maxLen = len;
            }
        }
        
        return maxLen;
    }
}