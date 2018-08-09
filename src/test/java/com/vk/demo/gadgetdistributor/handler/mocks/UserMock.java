package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.models.User;

public class UserMock {

    private static final String MOCK_ID = "mockId";
    private static final String MOCK_FIRST_NAME = "mockFirstName";
    private static final String MOCK_LAST_NAME = "mockLastName";
    private static final Integer MOCK_AGE = 10;

    public static User createMock() {
        return new User(MOCK_ID, MOCK_FIRST_NAME, MOCK_LAST_NAME, MOCK_AGE);
    }
}
