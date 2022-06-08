package co.pragra.demo.api;

import co.pragra.demo.entity.Profile;
import co.pragra.demo.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ProfileAPI {
    private ProfileService profileService;

    public ProfileAPI(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/api/profile")
    public List<Profile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PostMapping(value = "/api/profile")
    public Profile createProfile(@RequestBody Profile profile) {
        profileService.createProfile(profile);
        return profile;
    }

    @GetMapping(value = "/api/profile/{id}")
    public Optional<Profile> getProfileById(@PathVariable int id) {
        return profileService.getProfileById(id);
    }
@PutMapping(value = "/api/profile")
public Profile updateProfile(@RequestBody Profile profile){
       return profileService.updateProfile(profile);
}
}
