package co.pragra.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private Integer profileId;
    private String fullName;
    private String address;
    private String email;
    private Long phoneNumber;

}
