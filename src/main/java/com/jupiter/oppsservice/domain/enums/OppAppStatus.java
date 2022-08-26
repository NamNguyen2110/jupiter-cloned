package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppAppStatus {
    FEMALE("1"),
    OTHER("2"),
    MALE("3"),
    HIDDEN("4");


    private String value;

    private static final Map<String, OppAppStatus> objMap  = new HashMap<>();


    static {
        for (OppAppStatus obj : OppAppStatus.values()){
            objMap.put(obj.value, obj);
        }
    }

    public static OppAppStatus of(String s){
        return objMap.get(s);
    }

}
