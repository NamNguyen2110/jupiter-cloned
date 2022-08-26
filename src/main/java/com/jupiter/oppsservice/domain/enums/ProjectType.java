package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ProjectType {
    GDC("GDC"),
    FIXED_PRICE("FIXED_PRICE");

    private final String value;

    private static final Map<String, ProjectType> genderMap  = new HashMap<>();


    static {
        for (ProjectType gender: ProjectType.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static ProjectType of(String i){
        return genderMap.get(i);
    }
}
