package co.pragra.demo.repo;

import co.pragra.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//alias for @Component
public interface AddressRepo extends JpaRepository <Address, Integer> {

}
