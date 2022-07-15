package com.ssg.exam;

import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository;
    WiseSayingService(){
        wiseSayingRepository = new WiseSayingRepository();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }


    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean remove(int id) {
        return wiseSayingRepository.remove(id);
    }

    public boolean modify(int id, String content, String author) {
        return wiseSayingRepository.modify(id, content, author);
    }
}
