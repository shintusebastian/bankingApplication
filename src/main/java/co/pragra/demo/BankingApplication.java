package co.pragra.demo;

import co.pragra.demo.entity.Address;
import co.pragra.demo.entity.Profile;
import co.pragra.demo.repo.ProfileRepo;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Optional;


@SpringBootApplication
@Data
public class BankingApplication {
private final ProfileRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

@Bean
	CommandLineRunner runner(){
		return args -> {
			Profile profile= new Profile();
			profile.setFirstName("Neethu");
			profile.setLastName("Thomas");
			Address address=new Address();
			address.setId(123);
			address.setStreetNumber(5465);
			address.setStreetName("King street");
			address.setCity("Cambridge");
			address.setPostalCode("N3H3R6");
			profile.setAddresses(Arrays.asList(address));
			repo.save(profile);
			Optional<Profile> first = repo.findAll().stream().findFirst();
			System.out.println(first);
			System.out.println(first.get());

		};
}
}
