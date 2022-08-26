package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ApplicationType {
    CV("CV"),
    TEST("TEST"),
    INTERVIEW("INTERVIEW");

    private String value;

    private static final Map<String, ApplicationType> objMap = new HashMap<>();


    static {
        for (ApplicationType obj : ApplicationType.values()) {
            objMap.put(obj.value, obj);
        }
    }

    public static ApplicationType of(String s) {
        return objMap.get(s);
    }

}
