package com.ssg.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    int wiseSayingLastId;

    App(Scanner sc){
        this.sc = sc;
        wiseSayingLastId = 0;
    }

    public void run(){
        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch (cmd){
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    int id = ++wiseSayingLastId;
                    System.out.printf("%d번 명언이 등록되었습니다.", id);

                    break;

                case "종료":
                break outer;
            }
        }
    }
}
