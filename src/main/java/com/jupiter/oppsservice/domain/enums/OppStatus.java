package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppStatus {
    FEMALE("1"),
    OTHER("2"),
    MALE("3"),
    HIDDEN("4");


    private String value;

    private static final Map<String, OppStatus> objMap  = new HashMap<>();


    static {
        for (OppStatus obj : OppStatus.values()){
            objMap.put(obj.value, obj);
        }
    }

    public static OppStatus of(String s){
        return objMap.get(s);
    }

}
