package com.veva.veva.User.model;

public enum Origin {
    FOREST_ELF,
    HUMAN,
    MAGE,
    WITCH;

    public static Origin toOrigin(String originString) throws IllegalArgumentException {
        Origin origin = null;
        for(Origin o : Origin.class.getEnumConstants()) {
            if(o.toString().equals(originString)) {
                origin = o;
                break;
            }
        }

        if (origin == null)
            throw new IllegalArgumentException("Origin Not Found");
        else return origin;
    }
}
