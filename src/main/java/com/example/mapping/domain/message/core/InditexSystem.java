package com.example.mapping.domain.message.core;

public enum InditexSystem {
    MPS(        "MPS"),
    CORE(       "CORE"),
    CORE_CTRL(  "CORE-CTRL"),
    CORE_FACT(  "CORE-FACT"),
    SGE_FACT(   "SGE-FACT"),
    SFI(        "SFI"),
    LEX_DOC(    "LEX-DOC"),

    ORCHESTRATOR("ORCHESTRATOR")
    ;

    private final String name;

    InditexSystem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
