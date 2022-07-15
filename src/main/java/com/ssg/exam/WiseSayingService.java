package com.ssg.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int wiseSayingLastId;
    private List<WiseSaying> wiseSayings;

    WiseSayingService(){
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }


    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        
        return wiseSaying;
    }

    public WiseSaying findById(int paramId) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id==paramId)
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
