package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings = new ArrayList<>();

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

                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayings.add(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.", id);

                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying2 = wiseSayings.get(i);

                        System.out.printf("%d / %s / %s\n", wiseSaying2.id, wiseSaying2.author, wiseSaying2.content);
                    }
                    break;

                case "종료":
                    break outer;
            }
        }
    }
}