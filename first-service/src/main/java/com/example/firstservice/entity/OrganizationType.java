package com.example.firstservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganizationType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_type_id_seq")
    @SequenceGenerator(sequenceName = "organization_type_id_seq", name = "organization_type_id_seq", allocationSize = 1)
    private int id;

    @Column(name = "type_name", nullable = false, unique = true)
    private String type;

    @OneToMany(mappedBy = "organizationType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Organization> organizations;
}
