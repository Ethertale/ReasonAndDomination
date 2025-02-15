package io.ethertale.reasonanddominationspringdefenseproject.account.repo;

import io.ethertale.reasonanddominationspringdefenseproject.account.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, UUID> {

}
