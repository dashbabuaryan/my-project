package com.example.bank.Entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // ✅ Keep this for direct access, but mark it as read-only
    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer user_id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "type")
    private String type;

    @Column(name = "created_at")
    private Date created_at;

    // ✅ JPA relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
