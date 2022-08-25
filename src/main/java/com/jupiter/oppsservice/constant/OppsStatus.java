package com.jupiter.oppsservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppsStatus {
    // Trạng thái Activity Type là OPP
    PLAY(1),
    WON(2),
    LOST(3),

    // Trạng thái Activity Type là PROJECT
    PROCESSING(4),
    FINISH(5);

    private final Integer value;

    private static final Map<Integer, OppsStatus> genderMap  = new HashMap<>();


    static {
        for (OppsStatus gender: OppsStatus.values()){
            genderMap.put(gender.value, gender);
        }
    }

    public static OppsStatus of(Integer i){
        return genderMap.get(i);
    }
}
