package com.medeiros.os.domain.workorder;


import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.enums.Priority;
import com.medeiros.os.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "workorder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Workorder {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Priority priority;
    private Status status;

    @ManyToOne
    private Equipment equipment;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;


}
