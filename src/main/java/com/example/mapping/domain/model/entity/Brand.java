package com.example.mapping.domain.model.entity;

import java.util.Arrays;

public enum Brand {
    Pull_and_Bear(   2, "Pull & Bear"),
    Bershka(         4, "Bershka"),
    Stradivarius(    6, "Stradivarius"),
    Oysho(           7, "Oysho"),
    Uterque(        18, "Uterque");

    private final int id;
    private final String name;

    Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Brand byId(final int id) {
        return Arrays.stream(values())
                     .filter(brand -> brand.getId() == id)
                     .findFirst()
                     .orElseThrow(() -> new RuntimeException("There is no brand with the ID " + id));
    }

    @Override
    public String toString() {
        return id + " - '" + name + "'";
    }
}
