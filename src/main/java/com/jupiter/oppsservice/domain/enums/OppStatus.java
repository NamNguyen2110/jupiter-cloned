package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppStatus {
    PLAY("PLAY"),
    WON("WON"),
    LOST("LOST"),
    PROCESSING("PROCESSING"),
    FINISH("FINISH");

    private final String value;

    private static final Map<String, OppStatus> genderMap  = new HashMap<>();


    static {
        for (OppStatus gender: OppStatus.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static OppStatus of(String i){
        return genderMap.get(i);
    }
}