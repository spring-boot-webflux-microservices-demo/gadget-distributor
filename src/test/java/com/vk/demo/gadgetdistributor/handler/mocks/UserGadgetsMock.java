package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadgets;

public class UserGadgetsMock {

    private static final String USER_GADGET_ID_MOCK = "userGadgetIdMock";

    public static UserGadgets createMock() {
        User user = UserMock.createMock();
        Gadget gadget = GadgetMock.createMock();
        return new UserGadgets(USER_GADGET_ID_MOCK, user, gadget);
    }

    public static String createRawJsonObject() {
        return "{\"id\":null," +
                "\"user\":{\"id\":\"mockId\",\"firstName\":\"mockFirstName\",\"lastName\":\"mockLastName\",\"age\":10}," +
                "\"gadget\":[{\"id\":\"idMock\",\"type\":\"typeMock\",\"specifications\":\"specificationsMock\"}]}\n";
    }
}
