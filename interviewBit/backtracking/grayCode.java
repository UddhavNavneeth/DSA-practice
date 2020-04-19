// Link of the question:
// https://www.interviewbit.com/problems/gray-code/

public class Solution {
    public int binaryToNum(String bin) {
        StringBuilder sb = new StringBuilder(bin);
        sb=sb.reverse();
        double num=0;
        bin=sb.toString();
        for (int i=0;i<bin.length();i++) {
            num+=(Math.pow(2,i))*(((int)bin.charAt(i))%2);
        }
        
        return (int)num;
    }
    
    public String binToGray(String bin) {
        String resp="";
        resp+=bin.charAt(0);
        for (int i=1;i<bin.length();i++) {
            int output = (int)(bin.charAt(i-1)) ^ (int)(bin.charAt(i));
            resp+=(char)('0'+output);
        }
        return resp;
    }
    
    
    public String numToBin(int num, int a) {
        String resp="";
        if (num==0) {
            resp+='0';
        }
        while(num>0) {
            char n = (char)('0'+(num%2));
            resp=n+resp;
            num=num/2;
        }
        int len=resp.length();
        for (int i=0;i<a-len;i++) {
            resp='0'+resp;
        }
        
        
        return resp;
    }
    
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i=0;i<(int)(Math.pow(2,a));i++) {
            num.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for (int i=0;i<num.size();i++) {
            String bin = numToBin(num.get(i),a);
            String gray = binToGray(bin);
            int val = binaryToNum(gray);
            // System.out.print(num.get(i)+" "+bin+" "+gray+" "+val+"\n");
            ans.add(val);
        }
        return ans;
    }
}