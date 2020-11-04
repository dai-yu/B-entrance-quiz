package com.thoughtworks.capability.gtb.entrancequiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
public class GroupController {

    List<String> students= new LinkedList<>(Arrays.asList("成吉思汗","鲁班七号","太乙真人",
            "钟无艳","花木兰","雅典娜","芈月","白起","刘禅","庄周","马超","刘备","哪吒","大乔","蔡文姬"));

    // TODO GTB-知识点: - @CrossOrigin可以放在类上面
    // TODO GTB-知识点: - @RestController和@ResponseEntity重复
    @GetMapping("/students")
    @CrossOrigin(origins = {"http://localhost:1234"})
    public ResponseEntity<List<String>> getStudents(){
        return ResponseEntity.ok(students);
    }



    // TODO GTB-工程实践: - ResponseEntity应指定类型参数
    @GetMapping("/save")
    @CrossOrigin(origins = {"http://localhost:1234"})
    public ResponseEntity saveStudent(@RequestParam String student){
        students.add(student);
        // TODO GTB-知识点: - ResponseEntity用法错误
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/group")
    @CrossOrigin(origins = {"http://localhost:1234"})
    public ResponseEntity group(){
        List<String> newlist= new LinkedList<>();
        // TODO GTB-工程实践: - for循环可以使用Collections.addAll()替换
        for(int i=0 ;i<students.size();i++){
            newlist.add(students.get(i));
        }
        List<List<String>> group = new LinkedList<>();
        for (int i=0 ;i<6 ;i++){
            group.add(new LinkedList<String>());
        }
        int i=0;
        while (newlist.size()>0){
            int index = new Random().nextInt(newlist.size());
            group.get(i%6).add(newlist.get(index));
            i++;
            newlist.remove(index);
        }
        System.out.println(group);
        return ResponseEntity.created(null).body(group);
    }
}
