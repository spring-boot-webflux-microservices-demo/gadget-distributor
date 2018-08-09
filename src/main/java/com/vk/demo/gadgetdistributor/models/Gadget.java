package com.vk.demo.gadgetdistributor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gadget {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("specifications")
    private String specifications;

    public Gadget() {}
    public Gadget(String id, String type, String specifications) {
        this.id = id;
        this.type = type;
        this.specifications = specifications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
