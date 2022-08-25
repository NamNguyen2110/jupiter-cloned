package com.jupiter.oppsservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
@AllArgsConstructor
public enum ActivityType {
    OPP(1),
    PROJECT(2);

    private final Integer value;

    private static final Map<Integer, ActivityType> genderMap  = new HashMap<>();


    static {
        for (ActivityType gender: ActivityType.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static ActivityType of(Integer i){
        return genderMap.get(i);
    }
}
