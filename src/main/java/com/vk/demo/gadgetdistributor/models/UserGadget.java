package com.vk.demo.gadgetdistributor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserGadget {

    @Id
    private String id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("gadget")
    private Gadget gadget;

    public UserGadget() {}
    public UserGadget(String id, User user, Gadget gadget) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }
}
