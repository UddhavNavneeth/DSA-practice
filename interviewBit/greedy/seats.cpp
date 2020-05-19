// Link to the question:
// 
// Copy pasted code from the comment section from 'brizna'
// In short explanation is to find median and move each oen towards it
// (mid-i) part ensures that seats for other values after it but before median arent taken.

int Solution::seats(string A) {
    vector<int> pts;
    for (int i = 0; i < A.size(); i++)
        if (A[i] == 'x')
            pts.push_back(i);
    int mid = pts.size()/2;
    int res = 0;
    for (int i = 0; i < pts.size(); i++) {
        int start = pts[i];
        int dest = pts[mid] - (mid - i);
        res = (res + abs(dest - start)) % 10000003;
    }
    return res;
}