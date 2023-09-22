package com.example.firstservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organization_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;
}
