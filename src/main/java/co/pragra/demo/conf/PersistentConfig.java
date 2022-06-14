package co.pragra.demo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "co.pragra.demo.repo")
@EnableTransactionManagement
public class PersistentConfig {
}
