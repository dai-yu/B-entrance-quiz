package com.thoughtworks.capability.gtb.entrancequiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class GroupController {

    List<String> students= Arrays.asList("成吉思汗","鲁班七号","太乙真人",
            "钟无艳","花木兰","雅典娜","芈月","白起","刘禅","庄周","马超","刘备","哪吒","大乔","蔡文姬");

    @GetMapping("/students")
    public ResponseEntity<List<String>> getStudents(){
        return ResponseEntity.ok(students);
    }


}
