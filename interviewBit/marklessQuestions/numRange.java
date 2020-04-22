// Question: https://www.interviewbit.com/problems/numrange/
// NOT MY SOLUTION
// ANSWER I FOUND IN THE COMMENTS
// I STILL HAVEN'T UNDERSTOOD IT

// The trick here is to calculate the number of continuous subsequences less than (B-1)
// and number of continuous subsequences less than (C)

// then the answer would be : calc(C) - calc(B-1).

// now we change the problem to just find the number of continous subsequences lesser than a given K. we can do that using two pointer :

public int numRange(int[] A, int B, int C) {
    int x = countSubarrayLessThan(A, B - 1);
    int y = countSubarrayLessThan(A, C);
    return y - x;
}

static int countSubarrayLessThan(int arr[], int k) {
    int start = 0, end = 0;
    int count = 0, sum = arr[0];

    while (start < arr.length && end < arr.length) {
        if (sum <= k) {
            end++;
            if (end >= start)
                count += end - start;
            if (end < arr.length)
                sum += arr[end];
        } else {
            sum -= arr[start];
            start++;
        }
    }

    return count;
}