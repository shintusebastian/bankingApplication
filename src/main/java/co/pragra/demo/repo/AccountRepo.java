package co.pragra.demo.repo;

import co.pragra.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer > {
List<Account> findAllByAccountNameContainingIgnoreCase(String name);
//List<Account>
}
