package com.jupiter.oppsservice.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OppStatus {
    NEW("NEW"),
    PLAYING("PLAYING"),
    DEACTIVATED("DEACTIVATED"),
    WON("WON"),
    LOST("LOST");

    private final String value;

    private static final Map<String, OppStatus> statusMap  = new HashMap<>();


    static {
        for (OppStatus status: OppStatus.values()){
            statusMap.put(status.value, status);
        }
    }

    public static OppStatus of(String i){
        return statusMap.get(i);
    }
}
