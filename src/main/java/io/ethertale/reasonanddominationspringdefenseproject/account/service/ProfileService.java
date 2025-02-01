package io.ethertale.reasonanddominationspringdefenseproject.account.service;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormLoginDTO;

import java.util.UUID;

public interface ProfileService {
    Profile createTestUser();
    void registerProfile(String username, String password, String email);

    Profile getProfileById(UUID uuid);
    Profile loginProfile(FormLoginDTO formLoginDTO);
}
