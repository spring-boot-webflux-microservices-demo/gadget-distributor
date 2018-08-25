package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.Gadget;

public class GadgetMock {

    private static final String ID_MOCK = "idMock";
    private static final String TYPE_MOCK = "typeMock";
    private static final String SPECIFICATIONS_MOCK = "specificationsMock";

    public static Gadget createMock() {
        return new Gadget(ID_MOCK, TYPE_MOCK, SPECIFICATIONS_MOCK);
    }

    public static String createRawJsonObject() {
        return "{" +
                "\"id\":" + ID_MOCK + "," +
                "\"type\":" + TYPE_MOCK + "," +
                "\"specifications\":" + SPECIFICATIONS_MOCK +
                "}\n";
    }
}
