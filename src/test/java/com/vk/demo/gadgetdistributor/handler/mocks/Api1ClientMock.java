package com.vk.demo.gadgetdistributor.handler.mocks;

import com.vk.demo.gadgetdistributor.clients.Api1Client;
import com.vk.demo.gadgetdistributor.models.User;

public class Api1ClientMock implements Api1Client {

    @Override
    public User findUser(String id) {
        return UserMock.createMock();
    }
}
