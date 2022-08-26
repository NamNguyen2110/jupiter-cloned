package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ActivityType {
    OPP("OPP"),
    PROJECT("PROJECT");

    private final String value;

    private static final Map<String, ActivityType> genderMap  = new HashMap<>();


    static {
        for (ActivityType gender: ActivityType.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static ActivityType of(String i){
        return genderMap.get(i);
    }
}
