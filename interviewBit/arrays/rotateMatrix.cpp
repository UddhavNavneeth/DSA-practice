//NOT DONE BY ME THIS IS FROM THE EDITORIAL
// Link to the question:
// https://www.interviewbit.com/problems/rotate-matrix/


class Solution {
public:
     void rotate(vector<vector<int> > &matrix) {

        int len = matrix.size();
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[len - j - 1][i];
            matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
            matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
            matrix[j][len - i - 1] = tmp;
            }
        }
    }
};