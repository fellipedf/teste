package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProvinceEnum {
    MG("MG"),

    SP("SP"),

    RJ("RJ");

    private String value;

    ProvinceEnum(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ProvinceEnum fromValue(String text) {
        for (ProvinceEnum b : ProvinceEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
