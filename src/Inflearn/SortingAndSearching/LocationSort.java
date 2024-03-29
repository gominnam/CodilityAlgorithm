package Inflearn.SortingAndSearching;

import java.util.*;


public class LocationSort {//todo: repeat
    class Point implements Comparable<Point>{
        public int x, y;
        Point(int x, int y){
            this.x = x;
            this.y =y;
        }
        @Override
        public int compareTo(Point p){
            if(this.x == p.x) return this.y - p.y; //오름차순되려면 음수 리턴 반대로 내림차순은 o.y - y; 를 리턴
            else return this.x - p.x;
        }
    }

    public ArrayList<Point> Solve(int[][] location){
        ArrayList<Point> locationPoint = new ArrayList<>();
        for(int i=0; i<location.length; i++){
            locationPoint.add(new Point(location[i][0], location[i][1]));
        }
        Collections.sort(locationPoint);
        return locationPoint;
    }

    public static void main(String[] args){
        LocationSort T = new LocationSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] location = new int[n][2];
        for(int i=0; i<n; i++){
            location[i][0] = sc.nextInt();
            location[i][1] = sc.nextInt();
        }
        for(Point i : T.Solve(location)){
            System.out.println(i.x + " " + i.y);
        }
    }
}

/* remind
설명

N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.

정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.


입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.

두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.


출력
N개의 좌표를 정렬하여 출력하세요.

TEST CASE:
5
2 7
1 3
1 2
2 5
3 6

==>
1 2
1 3
2 5
2 7
3 6
 */