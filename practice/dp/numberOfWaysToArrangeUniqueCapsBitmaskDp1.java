// There are 100 different types of caps each having a unique id from 1 to 100. 
// Also, there are ‘n’ persons each having a collection of a variable number of caps. 
// One day all of these persons decide to go in a party wearing a cap but to look unique 
// they decided that none of them will wear the same type of cap. So, count the total number
//  of arrangements or ways such that none of them is wearing the same type of cap.
// Constraints: 1 <= n <= 10

// To understand watch the coding blocks video on bitmask dp. 1hr long video.

import java.util.*;


class Main {
  public static int count(int mask, int cap, int[][] dp, int n, ArrayList<ArrayList<Integer>> rev) {
    if (((1<<n)-1) == mask) {
      return 1;
    }

    if (cap>100) {
      return 0;
    }

    // if (rev.get(cap).size()==0) {
    //   return 0;
    // }

    if (dp[mask][cap]!=-1) {
      return dp[mask][cap];
    }
    int ways = 0;
    ways += count(mask,cap+1,dp,n,rev);

    for (int i=0;i<rev.get(cap).size();i++) {
      if ((mask & 1<<rev.get(cap).get(i)) != 0) {
        continue;
      }
      int newMask = (mask | 1<<rev.get(cap).get(i));
      ways+=count(newMask,cap+1,dp,n,rev);
    }
    dp[mask][cap]=ways;

    return dp[mask][cap];
  }


  public static void main(String[] args) {
    // System.out.println("Hello world!");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    // String garbage = sc.nextLine();
    ArrayList<ArrayList<Integer>> caps = new ArrayList<ArrayList<Integer>>();

    for (int i=0;i<n;i++) {
      // System.out.println(sc.nextLine());
      String[] inp = sc.nextLine().split(" ");
      ArrayList<Integer> arr = new ArrayList<Integer>();
      for (int j=0;j<inp.length;j++) {
        arr.add(Integer.parseInt(inp[j]));
      } 
      caps.add(arr);
    }
    System.out.println();

    // System.out.println(caps);

    ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();

    for (int i=0;i<101;i++) {
      ArrayList<Integer> arr = new ArrayList<Integer>();
      rev.add(arr);
    }

    for (int i=0;i<caps.size();i++) {
      for (int j=0;j<caps.get(i).size();j++) {
        rev.get(caps.get(i).get(j)).add(i);
      }
    }

    int[][] dp = new int[1025][101];
    for (int i=0;i<1025;i++) {
      for (int j=0;j<101;j++) {
        dp[i][j]=-1;
      }
    }

    System.out.println(count(0,0,dp,n,rev));
  }
}