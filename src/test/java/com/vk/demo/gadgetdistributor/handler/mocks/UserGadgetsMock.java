package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.Gadget;
import com.vk.demo.gadgetdistributor.models.User;
import com.vk.demo.gadgetdistributor.models.UserGadgets;

public class UserGadgetsMock {

    private static final String USER_GADGET_ID_MOCK = "userGadgetIdMock";
    private static final String MOCK_ID = "mockId";
    private static final String MOCK_FIRST_NAME = "mockFirstName";
    private static final String MOCK_LAST_NAME = "mockLastName";
    private static final String ID_MOCK = "idMock";
    private static final Integer MOCK_AGE = 10;
    private static final String TYPE_MOCK = "typeMock";
    private static final String SPECIFICATIONS_MOCK = "specificationsMock";

    public static UserGadgets createMock() {
        User user = UserMock.createMock();
        Gadget gadget = GadgetMock.createMock();
        return new UserGadgets(null, user, gadget);
    }

    public static String createRawJsonObject() {
        return "{\"id\":" + null + "," +
                "\"user\":{\"id\":" + MOCK_ID + "," +
                "\"firstName\":" + MOCK_FIRST_NAME + "," +
                "\"lastName\":" + MOCK_LAST_NAME + "," +
                "\"age\":" + MOCK_AGE + "}," +
                "\"gadget\":[{" +
                "\"id\":" + ID_MOCK + "," +
                "\"type\":" + TYPE_MOCK + "," +
                "\"specifications\":" + SPECIFICATIONS_MOCK + "}]}\n";
    }
}
