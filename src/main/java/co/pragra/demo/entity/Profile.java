package co.pragra.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Data //JPA requires a getter setter.


@Entity
public class Profile {
    @Id
    @GeneratedValue(generator = "UUID")// now we are not generating sequence as we are using UUID.
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")//this is where hibernate provides implementation of the UUID generator.
    private UUID uuid;
    private String firstName;
    private String lastName;
//    private String email;
//    private Long phoneNumber;
    //private List<CustomerAddress> addresses;

}
