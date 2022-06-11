package co.pragra.demo.entity;

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
    private Integer userId;
    @Column(name = "NAME", columnDefinition = "VARCHAR", length = 50, nullable = false)
    //this means that, name the database column as NAME.
    // Otherwise, it will be named as accountName in the database. Also, the column is varchar and it is not nullable.
    private String accountName;

    private AccountType accountType;
    private double balance;
    private Date createDate;
    private Date updateDate;

}
