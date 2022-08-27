package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppType {
    GDC("GDC"),
    FP("FP");

    private final String value;

    private static final Map<String, OppType> genderMap  = new HashMap<>();


    static {
        for (OppType gender: OppType.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static OppType of(String i){
        return genderMap.get(i);
    }
}
