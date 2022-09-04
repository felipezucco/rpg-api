package com.fzucco.core.enums;

public enum Actions {

    CONTEXT("ctx", ""),
    LOOK("lr", "Type LOOK (lr) to look around."),
    BAG("bg", "Type BAG (bg) to open the bag."),
    MAP("m", "Type MAP (m) to open the map."),

    GRAB("gb", "Type GRAB (gb) to collect the item."),
    DRIVE("dv", "Type DRIVE (dv) to drive it."),
    READ("rd", "Type READ (rd) to read it."),
    TAKE("tk", "Type TAKE (tk) to take it."),

    BACK("<", "Type BACK (<) to get back."),
    GO(">", "Type GO (>) to go forward."),

    YES("y", "Type YES (y) to accept."),
    NO("n", "Type NO (n) to deny.");

    private final String code;
    private final String description;

    Actions(String code, String description) {
        this.description = description;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
