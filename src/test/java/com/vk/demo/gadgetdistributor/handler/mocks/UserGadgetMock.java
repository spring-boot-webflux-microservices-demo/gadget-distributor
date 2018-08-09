package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadget;

public class UserGadgetMock {

    private static final String USER_GADGET_ID_MOCK = "userGadgetIdMock";

    public static UserGadget createMock() {
        User user = UserMock.createMock();
        Gadget gadget = GadgetMock.createMock();
        return new UserGadget(USER_GADGET_ID_MOCK, user, gadget);
    }

    public static String createRawJsonArray() {
        return "[{\"id\":\"userGadgetIdMock\"," +
                "\"userId\":\"userIdMock\"," +
                "\"userFirstName\":\"userFirstNameMock\"," +
                "\"userLastName\":\"userLastNameMock\"," +
                "\"userAge\":99," +
                "\"gadgetId\":\"gadgetIdMock\"," +
                "\"gadgetType\":\"gadgetTypeMock\"," +
                "\"gadgetSpecifications\":\"gadgetSpecsMock\"}]\n";
    }

    public static String createRawJsonObject() {
        return "{\"id\":\"userGadgetIdMock\"," +
                "\"userId\":\"userIdMock\"," +
                "\"userFirstName\":\"userFirstNameMock\"," +
                "\"userLastName\":\"userLastNameMock\"," +
                "\"userAge\":99," +
                "\"gadgetId\":\"gadgetIdMock\"," +
                "\"gadgetType\":\"gadgetTypeMock\"," +
                "\"gadgetSpecifications\":\"gadgetSpecsMock\"}\n";
    }
}
