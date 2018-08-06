package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.UserGadget;

public class UserGadgetMock {

    private static final String USER_GADGET_ID_MOCK = "userGadgetIdMock";
    private static final String GADGET_ID_MOCK = "gadgetIdMock";
    private static final String GADGET_TYPE_MOCK = "gadgetTypeMock";
    private static final String GADGET_SPECS_MOCK = "gadgetSpecsMock";
    private static final String USER_ID_MOCK = "userIdMock";
    private static final String USER_FIRST_NAME_MOCK = "userFirstNameMock";
    private static final String USER_LAST_NAME_MOCK = "userLastNameMock";
    private static final Integer USER_AGE_MOCK = 99;

    public static UserGadget createMock() {
        UserGadget userGadget = new UserGadget(USER_GADGET_ID_MOCK);
        userGadget.setGadgetId(GADGET_ID_MOCK);
        userGadget.setGadgetType(GADGET_TYPE_MOCK);
        userGadget.setGadgetSpecifications(GADGET_SPECS_MOCK);
        userGadget.setUserId(USER_ID_MOCK);
        userGadget.setUserFirstName(USER_FIRST_NAME_MOCK);
        userGadget.setUserLastName(USER_LAST_NAME_MOCK);
        userGadget.setUserAge(USER_AGE_MOCK);
        return userGadget;
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
}
