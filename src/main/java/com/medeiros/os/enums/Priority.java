package com.medeiros.os.enums;

public enum Priority {

    LOW ("Baixo"),
    MEDIUM ("Médio"),
    HIGH ("Alto"),
    CRITICAL("Crítico");

    private String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
