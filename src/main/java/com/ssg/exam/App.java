package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;

    App(Scanner sc){
        this.sc = sc;
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void run(){
        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getPath()){
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

                case "삭제":
                    int paramId = rq.getIntParam("id", 0);

                    if(paramId==0){
                        System.out.println("id를 입력해주세요.");
                        continue ;
                    }

                    WiseSaying wiseSaying2 = findByID(paramId);

                    if(wiseSaying2==null){
                        System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
                        continue ;
                    }

                    wiseSayings.remove(wiseSaying2);
                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);

                    break;

                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");

                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying1 = wiseSayings.get(i);

                        System.out.printf("%d / %s / %s\n", wiseSaying1.id, wiseSaying1.author, wiseSaying1.content);
                    }
                    break;

                case "종료":
                    break outer;
            }
        }
    }

    private WiseSaying findByID(int paramId) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id==paramId)
                return wiseSaying;
        }
        return null;
    }
}