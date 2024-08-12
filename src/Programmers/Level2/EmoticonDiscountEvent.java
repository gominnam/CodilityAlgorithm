package Programmers.Level2;

public class EmoticonDiscountEvent {
    static int[] answer;
    static int[] eventDiscount = {10, 20, 30, 40};

    public void bruteForce(int depth, int[][] users, int[] emoticons, int[] cache){
        if(depth == emoticons.length){
            int plusCount = 0;
            int totalPayment = 0;
            for(int i = 0; i < users.length; i++){
                if(cache[i] >= users[i][1]) plusCount++;
                else totalPayment += cache[i];
            }
            if(plusCount > answer[0] || (plusCount >= answer[0] && totalPayment >= answer[1])){
                answer[0] = plusCount;
                answer[1] = totalPayment;
            }
            return;
        }

        for(int i=0; i<4; i++){
            int discount = eventDiscount[i];
            int emoticonPrice = emoticons[depth];
            int[] newCache = cache.clone();

            for (int j = 0; j < users.length; j++) {
                if (users[j][0] <= discount) {
                    newCache[j] += emoticonPrice * (100 - discount) * 0.01;
                }
            }

            bruteForce(depth + 1, users, emoticons, newCache);
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        int[] cache = new int[users.length];
        bruteForce(0, users, emoticons, cache);

        return answer;
    }

    public static void main(String[] args){
        EmoticonDiscountEvent ede = new EmoticonDiscountEvent();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] result = ede.solution(users, emoticons);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}
