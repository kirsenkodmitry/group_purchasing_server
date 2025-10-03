package ru.vlsu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "unit_uuid", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private String uuid;

    @Column(name = "name", nullable = false, length = 36)
    private String name;
    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products;
}
