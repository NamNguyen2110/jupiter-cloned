package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ActivityType {
    FEMALE("1"),
    OTHER("2"),
    MALE("3"),
    HIDDEN("4");

    private String value;

    private static final Map<String, ActivityType> objMap  = new HashMap<>();


    static {
        for (ActivityType obj : ActivityType.values()){
            objMap.put(obj.value, obj);
        }
    }

    public static ActivityType of(String s){
        return objMap.get(s);
    }

}
