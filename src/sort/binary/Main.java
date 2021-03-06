package sort.binary;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();  // 나눌 갯수

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(T.solution(arr,n,m));

    }

    int solution(int[] arr, int n, int k){
        int answer = Integer.MIN_VALUE ;
        int max = arr[n-1] ; // - arr[0];
        int min = 1 ;
        // 결정 알고리즘에서는 최소, 최댓값 범위 설정이 중요하다.

//        System.out.println(isPossible(arr,k,2));
//        //System.out.println(isPossible(arr,k,3));
        while( min <= max){
            int mid = (min + max)/2 ;

            if( isPossible(arr,k,mid)){
                answer = mid ; // 현재 최댓값을 저장하자.
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] arr, int k, int mid) {
        int cnt = 1 ;
        int ep = 0 ;
        for(int j =ep+1; j< arr.length ; j++){
            if((arr[j] - arr[ep]) >= mid){
                ep = j;
                cnt ++;
            }
        }

        return (cnt >=k) ;
    }
}