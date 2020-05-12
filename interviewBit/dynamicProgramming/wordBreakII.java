// Link to the question:
// https://www.interviewbit.com/problems/word-break-ii/
// Copy pasted from comments
// Not using dp also cuz the solution provided by InterviewBit isnt explained
// mc bc

public ArrayList<String> wordBreak(String A, ArrayList<String> B) {

        ArrayList<String> result = new ArrayList<>();
        wordBreak(0, A.length(), B, A, result, "");
        return result;
    }

    private void wordBreak(int start, int end, ArrayList<String> b, String A, ArrayList<String> result, String res) {

        if (start == end) {
            result.add(res);
        }
        for (int i = start + 1; i <= end; i++) {
            String substring = A.substring(start, i);
            if (b.contains(substring)) {
                if (start == 0) {
                    wordBreak(i, A.length(), b, A, result, substring);
                } else {
                    wordBreak(i, A.length(), b, A, result, res + " " + substring);
                }
            }
        }

    }