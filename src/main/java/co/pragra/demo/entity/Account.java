package co.pragra.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TABLE_ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//hibernate will generate the sequence for us automatically.
    private Integer accountId;//we have market this accountId as an Id as Entity asks for a Table .

    /*@Column(nullable = false) //means, we cannot pass a null value as the profileId. we comment them as
    @Column cannot be applied to a @One to one annotation  */
    @OneToOne(cascade = CascadeType.ALL)
    /*cascading of operations means, whatever change we make in the account table will be
    reflected in the profile table as well */
    //telling hibernate that Account and Profile has one to one relation. It is declared to the profile id
    @JsonProperty("profile")
    private Profile profileId;
    @Column(name = "NAME", columnDefinition = "VARCHAR", length = 50, nullable = false)
    //this means that, name the database column as NAME.
    // Otherwise, it will be named as accountName in the database. Also, the column is varchar and it is not nullable.
    private String accountName;

    private AccountType accountType;

    @JsonIgnore
    private double balance;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date updateDate;

}
