package com.predic8.scooter.model;

import java.time.LocalDateTime;

public class RueckgabeDTO {

    String scooterId;
    LocalDateTime rueckgabe;

    public RueckgabeDTO() {
        rueckgabe = LocalDateTime.now();
    }

    public RueckgabeDTO(String scooterId){
        this();
        this.scooterId = scooterId;
    }

    public String getScooterId() {
        return scooterId;
    }

    public void setScooterId(String scooterId) {
        this.scooterId = scooterId;
    }

    public LocalDateTime getRueckgabe() {
        return rueckgabe;
    }

    public void setRueckgabe(LocalDateTime rueckgabe) {
        this.rueckgabe = rueckgabe;
    }
}
