package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int wiseSayingsLastId;
    private List<WiseSaying> wiseSayings;

    WiseSayingRepository(){
        wiseSayingsLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }


    public WiseSaying add(String content, String author){
        int id = ++wiseSayingsLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id==id)
                return wiseSaying;
        }
        return null;
    }

    public boolean remove(int id) {
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return false;
        }

        wiseSayings.remove(wiseSaying);

        return true;
    }

    public boolean modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);

        if (wiseSaying == null) {
            return false;
        }

        wiseSaying.content = content;
        wiseSaying.author = author;

        return true;
    }
}
