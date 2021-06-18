package com.predic8.scooter.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class Fahrt {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    String fahrtId;
    @PrimaryKeyColumn
    String scooterId;
    @PrimaryKeyColumn
    String userId;
    @Column
    LocalDateTime start;
    @Column
    LocalDateTime end;

    public Fahrt() {
    }

    public Fahrt(String id, String scooterId, String userId, LocalDateTime start, LocalDateTime end) {
        this.fahrtId = id;
        this.scooterId = scooterId;
        this.userId = userId;
        this.start = start;
        this.end = end;
    }

    public Fahrt(VerleihDTO verleihDTO) {
        this.fahrtId = verleihDTO.getFahrtId();
        this.userId = verleihDTO.getUserId();
        this.scooterId = verleihDTO.getScooterId();
        this.start = verleihDTO.getVerleihBeginn();
    }

    public String getScooterId() {
        return scooterId;
    }

    public void setScooterId(String scooterId) {
        this.scooterId = scooterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getFahrtId() {
        return fahrtId;
    }

    public void setFahrtId(String fahrtId) {
        this.fahrtId = fahrtId;
    }
}
