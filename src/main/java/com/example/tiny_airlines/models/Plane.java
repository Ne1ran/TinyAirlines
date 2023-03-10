package com.example.tiny_airlines.models;

public class Plane {
    private String id;
    private String model;
    private String type;
    private String capacity;
    private String pilot_name;

    public Plane() {
    }

    public Plane(String id, String model, String type, String capacity, String pilot_name) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.capacity = capacity;
        this.pilot_name = pilot_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPilot_name() {
        return pilot_name;
    }

    public void setPilot_name(String pilot_name) {
        this.pilot_name = pilot_name;
    }
}
