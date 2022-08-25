package com.jupiter.oppsservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum ProjectType {
    GDC(1),
    FIXED_PRICE(2);

    private final Integer value;

    private static final Map<Integer, ProjectType> genderMap  = new HashMap<>();


    static {
        for (ProjectType gender: ProjectType.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static ProjectType of(Integer i){
        return genderMap.get(i);
    }
}
