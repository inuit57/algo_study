package Simulation.bj14503;

import java.util.Scanner;

public class Main {

    static int[] px = {-1,0,1,0};
    static int[] py = {0,1,0,-1};

    // 방향이 계속 헷갈린다.

    // 북쪽  x= -1, y = 0, 북쪽(0)의 왼쪽은 서쪽(3)
    // 동쪽  x = 0, y = 1, 동쪽(1)의 왼쪽은 북쪽(0)
    // 남쪽  x = 1, y = 0, 남쪽(2)의 왼쪽은 동쪽(1)
    // 서쪽  x = 0, y = -1, 서쪽(3)의 왼쪽은 남쪽(2)

    static int[][] board;
    static int n, m;

    static int cleanCount = 0 ;
    static boolean isEnd = false;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main T = new Main();

        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][m];

        int x = in.nextInt();
        int y = in.nextInt();
        int dir = in.nextInt();

        for(int i=0; i< n; i++){
            for(int j=0 ; j< m ; j++){
                int info = in.nextInt();
                if(info == 1) info = -1;
                board[i][j] = info;
            }
        }



        T.solution(x,y,dir);

        System.out.println(cleanCount);

//        printBoard();
    }

    private static void printBoard() {
        for(int i=0; i< n; i++){
            for(int j=0 ; j< m ; j++){
                int info = board[i][j];
                if(info < 0) info = 0;
                System.out.printf("%4d ", info);
            }
            System.out.println();
        }
    }


    private void clean(int x, int y, int dir){
        if( board[x][y] == 0) {
            // 현재 위치 청소
            cleanCount++;
            board[x][y] = cleanCount;

//            if( cleanCount >= 57 ){
//                System.out.println("here");
//            }
        }
    }

    private void solution(int x, int y, int dir) {
        if(isEnd) return;
        clean(x,y,dir);

        int newDir = dir;

        boolean isCleanable = false;
        for(int i =0 ; i< 4; i++){
            newDir = (newDir+3)%4 ;

            int dx = x + px[newDir] ;
            int dy = y + py[newDir] ;
            if( dx >= 0 && dy >= 0 && dx < n && dy < m && board[dx][dy] == 0){
                solution(dx,dy,newDir);
                isCleanable = true ;
                if(isEnd) return;
            }
        }

        if(!isCleanable){
            int dx = x- px[dir];
            int dy = y- py[dir];

            if( dx >= 0 && dy >= 0 && dx < n && dy < m ){
                if( board[dx][dy] == -1){
                    isEnd = true;
                    return; // 벽을 만나면 종료
                }
                solution(dx,dy,dir);
            }else{
                isEnd = true;
            }
        }

    }
}
