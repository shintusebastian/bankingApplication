package co.pragra.demo.services;

import co.pragra.demo.entity.Profile;
import co.pragra.demo.repo.ProfileRepo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ProfileService {
private final ProfileRepo repo;

public List<Profile>getAllProfiles(){
    return repo.findAll();
}
}
