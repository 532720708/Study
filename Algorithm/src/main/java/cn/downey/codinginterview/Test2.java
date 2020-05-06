package cn.downey.codinginterview;

public class Test2 {
    public static String calculateStringDistance(String expressionA, String expressionB) {
        char[] charsA = expressionA.toCharArray();
        char[] charsB = expressionB.toCharArray();
        int a = charsA.length == charsB.length ? counter1(charsA, charsB) :
                charsA.length > charsB.length ? counter2(charsA, charsB) : counter2(charsB, charsA);
        int ans = a + 1;
        return "1/" + ans;
    }

    private static int counter1(char[] a, char[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                count++;
            }
        }
        return count;
    }

    private static int counter2(char[] a, char[] b) {
        int count = 0;
        int posa = 0;
        int posb = 0;
        while (posb < b.length) {
            if (a[posa] != b[posb] && a[posa] == b[posb + 1]) {
                posa++;
                count++;
            }
            posa++;
            posb++;
        }
        return count;
    }

    public static void main(String[] args) {

        Test2.calculateStringDistance("abcdef", "abcdefg");
    }
}
