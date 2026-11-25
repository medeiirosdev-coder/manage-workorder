package com.medeiros.os.enums;

public enum Status {

    OPEN ("Aberto"),
    EMAND ("Em andamento"),
    CONC ("Concluido"),
    CANC ("Cancelado");

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
