package String;

public class distanceBet2word {
    private static int distance(String[] str,String w1,String w2){
        int d1 = -1;
        int d2 = -1;
        int minDis = Integer.MAX_VALUE;
        for(int i = 0;i<str.length;i++){
            if(str[i] == w1){
                d1 = i;
            }
            if (str[i] == w2) {
                d2 = i;
            }
            if(d1 != -1 && d2 != -1)
                minDis = Math.min(minDis, Math.abs(d1-d2));
        }
        return minDis;
    }
    public static void main(String[] args) {
        String[] str = { "the", "quick", "brown", "fox", "quick" };
        String word1 = "the", word2 = "fox";
        System.out.println(distance(str, word1, word2));

    }
}
