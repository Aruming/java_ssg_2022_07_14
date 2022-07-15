package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    WiseSayingService wiseSayingService;

    WiseSayingController(Scanner sc){
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying1 = wiseSayings.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying1.id, wiseSaying1.author, wiseSaying1.content);
        }
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if(id==0){
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if(wiseSaying==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 명언 : %s\n", wiseSaying.content);
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("기존 작가 : %s\n", wiseSaying.author);
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.modify(id, content, author);
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if(id==0){
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);

        if(wiseSaying==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.remove(id);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void add(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.id);
    }
}
