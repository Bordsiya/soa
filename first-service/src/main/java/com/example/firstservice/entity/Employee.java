package com.example.firstservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employee", schema = "soa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Min(0)
    @Column(name = "salary", nullable = false)
    private Integer salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
