package Programmers.kakao.blind_2018;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.setLength(0);
            String arrBinary1 = toBinaryString(arr1[i], n);
            String arrBinary2 = toBinaryString(arr2[i], n);
            for(int j=0; j<n; j++){
                if(arrBinary1.charAt(j) == '1' || arrBinary2.charAt(j) == '1'){
                    sb.append("#");
                }
                else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    public String toBinaryString(int number, int n){
        StringBuilder binary = new StringBuilder();
        while(number > 0){
            binary.append(number % 2);
            number /= 2;
        }

        binary.reverse();

        while(binary.length() < n){
            binary.insert(0, "0");
        }

        return binary.toString();
    }


    public String[] solution_2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            // 두 배열의 값을 OR 연산 후 2진수 문자열로 변환
            // format에서 %ns: n은 출력 문자열의 최소 길이를 지정, s는 문자열을 의미
            String binary = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));

            // 1이면 #, 0이면 공백으로 변환
            answer[i] = binary.replace('1', '#').replace('0', ' ');
        }

        return answer;
    }

    public static void main(String[] args) {
        SecretMap secretMap = new SecretMap();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = secretMap.solution_2(n, arr1, arr2);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
