// Link of the question:
// https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
// Learned from the comments from inception_1 his code with comments is given below

public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum=0;
        int maxLen=-1;
        int flag=0;
        int start=-1;
        int end=-1;
        map.put(0,-1);
        
        for (int i=0;i<A.size();i++) {
            sum=sum+A.get(i);
            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }else {
                int len=(i-(map.get(sum)+1))+1;
                flag=1;
                if (len>maxLen) {
                    maxLen=len;
                    start=map.get(sum)+1;
                    end=i;
                }
            }
        }
        
        ArrayList<Integer> ans =  new ArrayList<Integer>();
        
        if (flag==0) {
            return ans;
        }else {
            for (int i=start;i<end+1;i++) {
                ans.add(A.get(i));
            }
            return ans;
        }
    }
}

// vector Solution::lszero(vector &A) {

// int x,y;  // represent the start and end index of result

// // declare a map to store key as sum to check if sum is present on not
// // and value represent the index where particular sum appears first time
// unordered_map<int,int> m; 
 
// int sum = 0,flag =0,diff =-1,curr=0;
// // for zero sum our index will be -1  so key =0,value =-1
// m[0] = -1;

// for(int i=0;i<A.size();i++){
//     //sum so far  including current element
//     sum = sum+A[i];
    
//     //if sum is not already present on map
//     if(m.count(sum)==0){
//         m[sum] = i;
//     }
//     // if the sum that is key of map is repeating that means we got a portion whose sum is 0
//     else{
//      // we got 1 portion atleat whose sum is 0 so mark flag
//         flag =1;
// // checking the portion size so that we can get the largest sequence whose sum=0
// // store start and end of that portion in x and y       
//         curr = i - (m[sum]+1) + 1;
//         if(curr > diff){
//                  diff = curr;
//                  x= m[sum]+1;
//                  y = i;
//         }
//     }
// }

// vector<int> ans;
// if(flag ==0){
//     return ans;
// }
// for(int k=x;k<=y;k++){
//     ans.push_back(A[k]);
// }
// return ans;
// }