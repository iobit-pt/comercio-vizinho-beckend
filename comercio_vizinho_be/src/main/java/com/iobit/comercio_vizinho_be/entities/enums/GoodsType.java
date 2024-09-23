package com.iobit.comercio_vizinho_be.entities.enums;

public enum GoodsType {
    PRODUCT(1),
    SERVICE(2);

    private final int code;

    GoodsType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GoodsType valueOf(int code) {
        for (GoodsType value : GoodsType.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid goods type code");
    }
}
