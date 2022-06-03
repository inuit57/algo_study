package com.test;

import java.util.*;

public class Main {


    public static void main(String[] args){
        Main T = new Main();
        Scanner in=new Scanner(System.in);

        String str = in.next();

        System.out.println(T.solution(str));

    }

    private int solution(String str) {

        Stack<Character> stack = new Stack<>();

        int answer = 0 ;
        for(int i= 0 ; i< str.length(); i++){
            if( str.charAt(i) == '(') stack.push('(');
            else{
                stack.pop();
                if(str.charAt(i-1) == '(') { // 레이저
                    answer += stack.size(); // 스택에 있는 막대기 갯수를 더해준다.
                }else {
                    answer++;
                }
            }
        }

        return answer;
    }

}