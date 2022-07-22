package com.example.departmentservice.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long departmentId;
    @NotNull
    private String departmentName;
    @NotNull
    private String departmentAddress;
    @NotNull
    private String departmentCode;
}
