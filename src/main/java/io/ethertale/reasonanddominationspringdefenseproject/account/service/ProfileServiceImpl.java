package io.ethertale.reasonanddominationspringdefenseproject.account.service;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountStatus;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormRegisterDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {
    ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile createTestUser() {
        return null;
    }

    @Override
    public void registerProfile(String username, String password, String email) {
        Profile profile = new Profile();
        profile.setUsername(username);
        profile.setPassword(password);
        profile.setEmail(email);
        profile.setRole(AccountRole.USER);
        profile.setStatus(AccountStatus.ACTIVE);
        profile.setCreatedOn(LocalDateTime.now());
        profileRepo.save(profile);
    }

    @Override
    public Profile getProfileById(UUID uuid) {
        return profileRepo.findById(uuid).orElse(null);
    }
}
