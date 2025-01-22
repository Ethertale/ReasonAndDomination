package io.ethertale.reasonanddominationspringdefenseproject.account.service;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountStatus;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProfileInit implements CommandLineRunner {

    private final ProfileServiceImpl profileService;
    private final ProfileRepo profileRepo;

    public ProfileInit(ProfileServiceImpl profileService, ProfileRepo profileRepo) {
        this.profileService = profileService;
        this.profileRepo = profileRepo;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
