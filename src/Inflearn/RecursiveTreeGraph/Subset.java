package Inflearn.RecursiveTreeGraph;

public class Subset {
    static int n; //집합 원소의 갯수
    static int[] ch; //사용할지 안할지 flag 배열
    public void DFS(int L){
        if(L==n+1){
            for(int i=1; i<=n; i++){
                if(ch[i] == 1) System.out.print(i + " ");
            }
            System.out.println();
        }
        else{
            ch[L] = 1;//사용한다.
            DFS(L+1);//왼쪽
            ch[L] = 0;//사용하지 않는다.
            DFS(L+1);//오른쪽
        }
    }

    public static void main(String[] args){
        Subset T = new Subset();
        n=3;
        ch=new int[n+1];
        T.DFS(1);
    }
}

/*
DFS 부분집합

 */