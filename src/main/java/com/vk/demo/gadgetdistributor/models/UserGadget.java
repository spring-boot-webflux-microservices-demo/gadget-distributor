package com.vk.demo.gadgetdistributor.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserGadget {

    @Id
    private String id;

    private String userId;
    private String userFirstName;
    private String userLastName;
    private Integer userAge;

    private String gadgetId;
    private String gadgetType;
    private String gadgetSpecifications;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGadgetId() {
        return gadgetId;
    }

    public void setGadgetId(String gadgetId) {
        this.gadgetId = gadgetId;
    }

    public String getGadgetType() {
        return gadgetType;
    }

    public void setGadgetType(String gadgetType) {
        this.gadgetType = gadgetType;
    }

    public String getGadgetSpecifications() {
        return gadgetSpecifications;
    }

    public void setGadgetSpecifications(String gadgetSpecifications) {
        this.gadgetSpecifications = gadgetSpecifications;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
