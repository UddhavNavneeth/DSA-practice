// Link for the question: 
// https://www.interviewbit.com/problems/order-of-people-heights/
// MY STUPID ASS BRUTE FORCE EXPONENTIAL SOLUTION, WHICH OBVIOUSLY DOESNT PASS
// I HAVE WRITTEN HINT 2 BELOW WHICH EXPLAINS O(n^2) SOLUTION WHICH PASSES
// O(nlogn) SOLUTION IS ALSO GIVEN BELOW WHICH I DIDNT UNDERSTAND TILL NOW..F

public class Solution {
    
    public boolean isSafe(ArrayList<Integer> h, ArrayList<Integer> inf, int pos, ArrayList<Integer> ans) {
        int currH=h.get(pos);
        int infAndTall=inf.get(pos);
        
        int count=0;
        for (int i=0;i<ans.size();i++) {
            if (ans.get(i)>currH) {
                count++;
            }
        }
        
        if (count==infAndTall) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean backtrack(ArrayList<Integer> h, ArrayList<Integer> inf, ArrayList<Integer> ans,int size) {
        if (ans.size()==size) {
            return true;
        }
        
        for (int i=0;i<h.size();i++) {
            if (isSafe(h,inf,i,ans)) {
                int height=h.get(i);
                int infront=inf.get(i);
                ans.add(height);
                h.remove(i);
                inf.remove(i);
                
                if (backtrack(h,inf,ans,size)) {
                    return true;
                }
                
                ans.remove(ans.size()-1);
                h.add(i, height);
                inf.add(i, infront);
            }
        }
        
        return false;
    }
    
    public ArrayList<Integer> order(ArrayList<Integer> h, ArrayList<Integer> inf) {
        int size=h.size();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        backtrack(h,inf,ans,size);
        
        return ans;
    }
}

// O(n^2) SOLUTION

// Sort people by heights. Then iterate from shortest to tallest. In each step you need an efficient way to put the next person to the correct position. Notice that people we’ve already placed are not taller that the current person. And the people we place after are taller than the current. So we have to find a place such that the number of empty positions in the front is equal to the inFronts value of this person.

// Lets take an example :

// For example after sorting,

// Height - 1, 2, 3, 4, 5, 6
// Infront - 3, 2, 1, 2, 0, 0.
// 1st element should go in position 3. Hence final array becomes:

// ---1--
// 2nd element shall go in position 2. Hence final array becomes:

// --21--
// 3rd element should go in position 1. Hence final array becomes:

// -321--
// 4th element shall go in position 2. This is the position among the empty ones. Hence final array becomes:

// -321-4
// 5th element shall go in position 0. Hence final array becomes:

// 5321-4
// 6th element should go in position 0. Hence final array becomes:

// 532164


// O(nlogn) SOLUTION

// So for each person we’re basically asking the question: What is the index of the Kth empty slot in the output array?
// One simple solution is to just loop on the output array, keep counting empty slots until you reach k and return that index.

// The problem with this solution is that it’s O(N) for each of the N people which makes the overall complexity O(N^2).

// Is there any way to search for the Kth empty slot in O(logN)?

// What about using a BST? We know that searching for a value in a balanced BST takes O(logn) time so maybe we can build a BST
// with all available/empty indices and search for the kth available/empty index and just use that index. (Note that now each slot is represented by an index)

// We’re going to add two attributes to the tree node that will help us in future searches, which are:

// size: represents the size of the tree rooted at this node. (number of nodes)
// removed: When an index/slot is taken this flag is set to true. This an alternative to deleting the node to avoid unnecessary hassle.
// Our BST class will include two main functions:
// -constructBST(0,n): builds a BST containing all numbers in the range [0,n). For each call of this function we’ll take the median value as the root and call the function recursively for the left and right half of the range [0,n).
// -getKthNodeIndex(k,root): This is the main function that we’ll call for each person to answer our question.
// The function checks if the current root is the kth available node and if not it moves right or left depending on
// the k value and current root value. Note that while searching we decrease the size of each node we meet in our path to the target node. This is done to ensure that we update each of the ancestors to this node with the fact that we removed one of its descendants.
// Also note that we move right if current node was found to be equal to k
// but already removed because this means that the kth node is still the next node and not the current one.

// Overall complexity: O(NlogN)


// class TreeNodeWithSize:
//     def __init__(self,val,size):
//         self.val=val
//         self.size=size
//         self.removed=False
//         self.left=None
//         self.right=None

// class IndsBST:
//     def __init__(self,n):
//         self.root=self.constructBST(0,n)

//     def constructBST(self,start,end):
//         if start>=end:
//             return None
            
//         mid=(start+end)//2
//         root=TreeNodeWithSize(mid,end-start)
//         root.left=self.constructBST(start,mid)
//         root.right=self.constructBST(mid+1,end)
//         return root
    
//     def getKthNodeIndex(self,k):
//         return self._getKthNodeIndex(k,self.root)
        
//     def _getKthNodeIndex(self,k,root):
        
//         leftSize= root.left.size if root.left else 0
//         root.size-=1 #reduce size of this node
//         if k==leftSize and not root.removed: #found node
//             root.removed=True
//             return root.val
//         if k>=leftSize: #go right
//             return self._getKthNodeIndex(k-leftSize-int(not root.removed),root.right)
//         else:
//             return self._getKthNodeIndex(k,root.left)
        
// class Solution:
    
//     def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
//         people=sorted(people,key=lambda person: person[1],reverse=True)
//         people=sorted(people,key=lambda person: person[0])
        
//         out=[None]*len(people)
//         indsTree=IndsBST(len(people))
        
//         for person in people:
//             out[indsTree.getKthNodeIndex(person[1])]=person
//         return out