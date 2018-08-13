package com.vk.demo.gadgetdistributor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class UserGadgets {

    @Id
    private String id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("gadget")
    private List<Gadget> gadgets;

    public UserGadgets() {}

    public UserGadgets(User user, Gadget gadget) {
        this.user = user;
        this.gadgets = new ArrayList<>();
        this.gadgets.add(gadget);
    }

    public UserGadgets(String id, User user, Gadget gadget) {
        this(user, gadget);
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

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }
}
