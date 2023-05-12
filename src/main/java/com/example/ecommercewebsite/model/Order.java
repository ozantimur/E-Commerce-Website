package com.example.ecommercewebsite.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "sale")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "date")
    private LocalDateTime orderDate;

    @Column(name = "quantity")
    private Integer quantity;

    @PrePersist
    public void prePersist() {
        this.orderDate = LocalDateTime.now();
    }

}
