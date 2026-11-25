package com.medeiros.os.domain.equipment;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="equipment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Equipment {

    @Id
    @GeneratedValue
    private UUID id;

    private String code;
    private String name;
    private String local;
    private Boolean active;



}
