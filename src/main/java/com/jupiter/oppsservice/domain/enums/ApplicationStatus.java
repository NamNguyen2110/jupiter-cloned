package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ApplicationStatus {
    SUBMITTED("SUBMITTED"),
    PROCESSING("PROCESSING"),
    PASSED("PASSED"),
    FAILED("FAILED");

    private String value;

    private static final Map<String, ApplicationStatus> objMap  = new HashMap<>();


    static {
        for (ApplicationStatus obj : ApplicationStatus.values()){
            objMap.put(obj.value, obj);
        }
    }

    public static ApplicationStatus of(String s){
        return objMap.get(s);
    }

}
