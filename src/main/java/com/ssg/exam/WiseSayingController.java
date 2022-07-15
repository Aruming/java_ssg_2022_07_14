package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        wiseSayingLastId=0;
        wiseSayings = new ArrayList<>();
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying1 = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying1.id, wiseSaying1.author, wiseSaying1.content);
        }
    }

    public void modify(Rq rq) {
        int paramId2 = rq.getIntParam("id", 0);
        if(paramId2==0){
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying4 = findByID(paramId2);

        if(wiseSaying4==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId2);
            return;
        }

        System.out.printf("기존 명언 : %s\n", wiseSaying4.content);
        System.out.printf("명언 : ");
        wiseSaying4.content = sc.nextLine();
        System.out.printf("기존 작가 : %s\n", wiseSaying4.author);
        System.out.printf("작가 : ");
        wiseSaying4.author = sc.nextLine();
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);

        if(paramId==0){
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying2 = findByID(paramId);

        if(wiseSaying2==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }

        wiseSayings.remove(wiseSaying2);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        int id = ++wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.", id);
    }

    private WiseSaying findByID(int paramId) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id==paramId)
                return wiseSaying;
        }
        return null;
    }
}
