package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ProjectType {
    FEMALE("1"),
    OTHER("2"),
    MALE("3"),
    HIDDEN("4");


    private String value;

    private static final Map<String, ProjectType> objMap  = new HashMap<>();


    static {
        for (ProjectType obj : ProjectType.values()){
            objMap.put(obj.value, obj);
        }
    }

    public static ProjectType of(String s){
        return objMap.get(s);
    }

}
