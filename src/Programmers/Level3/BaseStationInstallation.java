package Programmers.Level3;

public class BaseStationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int endPoint = 1;
        int radioRange = 2*w+1;

        for(int i=0; i<stations.length; i++){
            int width = stations[i]-w-endPoint;
            answer += width/radioRange;
            if(width%radioRange > 0) answer++;
            endPoint = stations[i]+w+1;
        }
        if(n+1-endPoint > 0){
            answer += (n+1-endPoint)/radioRange;
            if((n+1-endPoint)%radioRange > 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        BaseStationInstallation bsi = new BaseStationInstallation();
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        System.out.println(bsi.solution(n, stations, w));
    }
}
