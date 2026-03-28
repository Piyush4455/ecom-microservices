package com.app.ecom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    @Column(nullable = false)
    private UserRole role;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @CreationTimestamp
    private LocalDateTime creationAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @PrePersist
    public void setDefaultRole() {
        if (this.role == null) {
            this.role = UserRole.CUSTOMER;
        }
    }

}
