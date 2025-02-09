package io.ethertale.reasonanddominationspringdefenseproject.account.service;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountRole;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.AccountStatus;
import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import io.ethertale.reasonanddominationspringdefenseproject.account.repo.ProfileRepo;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormLoginDTO;
import io.ethertale.reasonanddominationspringdefenseproject.web.dto.FormRegisterDTO;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.time.LocalDateTime;
import java.util.*;

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
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public List<Profile> getAllProfilesReversed() {
        return profileRepo.findAll().stream().sorted(Comparator.comparing(Profile::getCreatedOn).reversed()).toList();
    }

    public Profile loginProfile(FormLoginDTO formLoginDTO){

        Optional<Profile> optionProfile = profileRepo.findByEmail(formLoginDTO.getEmail());
        if (optionProfile.isEmpty()){
            throw new IllegalArgumentException("Invalid email or password");
        }

        Profile profile = optionProfile.get();
        if (!profile.getPassword().equals(formLoginDTO.getPassword())){
            throw new IllegalArgumentException("Invalid password");
        }

        return profile;
    }

    @Override
    public Profile getProfileById(UUID uuid) {
        return profileRepo.findById(uuid).orElse(null);
    }
}
