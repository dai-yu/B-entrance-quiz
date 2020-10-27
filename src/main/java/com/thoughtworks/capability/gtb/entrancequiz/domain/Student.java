package com.thoughtworks.capability.gtb.entrancequiz.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;

    private String name;

    Student(String name){
        this.id=new Random().nextInt(100);
        this.name=name;
    }
}
