package ru.vlsu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import ru.vlsu.utils.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_uuid", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private String uuid;

    @Column(name = "user_uuid", nullable = false, length = 36)
    private String userUuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false, length = 20)
    private OrderStatus orderStatus;

    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_edited", nullable = false)
    private LocalDateTime dateEdited;

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
        dateEdited = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateEdited = LocalDateTime.now();
    }
}