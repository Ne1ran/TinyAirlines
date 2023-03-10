package com.example.tiny_airlines.models;

public class Flight {
    private String id;
    private String plane_id;
    private String start_date;
    private String start_time;
    private String land_date;
    private String land_time;
    private String start_location;
    private String land_location;
    private String start_track;

    public Flight() {
    }

    public Flight(String id, String plane_id, String start_date, String start_time, String land_date, String land_time, String start_location, String land_location, String start_track) {
        this.id = id;
        this.plane_id = plane_id;
        this.start_date = start_date;
        this.start_time = start_time;
        this.land_date = land_date;
        this.land_time = land_time;
        this.start_location = start_location;
        this.land_location = land_location;
        this.start_track = start_track;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(String plane_id) {
        this.plane_id = plane_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLand_date() {
        return land_date;
    }

    public void setLand_date(String land_date) {
        this.land_date = land_date;
    }

    public String getLand_time() {
        return land_time;
    }

    public void setLand_time(String land_time) {
        this.land_time = land_time;
    }

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public String getLand_location() {
        return land_location;
    }

    public void setLand_location(String land_location) {
        this.land_location = land_location;
    }

    public String getStart_track() {
        return start_track;
    }

    public void setStart_track(String start_track) {
        this.start_track = start_track;
    }
}
