package com.medeiros.os.service;


import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.domain.workorder.Workorder;
import com.medeiros.os.dto.equipment.EquipmentResponseDTO;
import com.medeiros.os.dto.workorder.WorkorderRequestDTO;
import com.medeiros.os.dto.workorder.WorkorderResponseDTO;

import com.medeiros.os.enums.Status;
import com.medeiros.os.exceptions.EquipmentInactiveException;
import com.medeiros.os.exceptions.WoIDNotExistsException;
import com.medeiros.os.repository.WorkorderRepository;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class WorkorderService {

    private final WorkorderRepository workorderRepository;
    private final EquipmentService equipmentService;


    public WorkorderResponseDTO findById(UUID id){

        Workorder wo = workorderRepository.findById(id)
                .orElseThrow(() -> new WoIDNotExistsException("Does not have a work order created with this ID " + id));

        return workorderToDTO(wo);

    }

    public List<WorkorderResponseDTO> fetchWOsOptStatus(Status status){

        if (status == null){

            return workorderRepository
                    .findAll()
                    .stream()
                    .map(this::workorderToDTO)
                    .toList();

        }

        return workorderRepository
                .findAll()
                .stream()
                .filter(workorder -> workorder.getStatus().equals(status))
                .map(this::workorderToDTO)
                .toList();

    }

    public WorkorderResponseDTO createWO(WorkorderRequestDTO woRequestDTO){

            Workorder wo = new Workorder();

            EquipmentResponseDTO equipmentResponseDTO = equipmentService.findEquipment(woRequestDTO.equipmentCode());

            if (!equipmentResponseDTO.active()){

                throw new EquipmentInactiveException("The Equipment is inactive. Is not possible to open a work order.");

            }

            wo.setTitle(woRequestDTO.title());
            wo.setDescription(woRequestDTO.description());
            wo.setPriority(woRequestDTO.priority());
            wo.setStatus(Status.OPEN);
            wo.setEquipment(toEntityEquipment(equipmentResponseDTO));
            wo.setCreatedAt(LocalDateTime.now());
            wo.setClosedAt(null);

            workorderRepository.save(wo);

            return workorderToDTO(wo);


    }

    public WorkorderResponseDTO workorderToDTO(Workorder workorder){

        return new WorkorderResponseDTO(workorder.getId(), workorder.getTitle(), workorder.getDescription(),workorder.getPriority(), workorder.getStatus(),workorder.getEquipment(),workorder.getCreatedAt(),workorder.getClosedAt());

    }

    public Equipment toEntityEquipment(EquipmentResponseDTO equipmentResponseDTO){

        return new Equipment(equipmentResponseDTO.id(), equipmentResponseDTO.code(), equipmentResponseDTO.name(),equipmentResponseDTO.local(),equipmentResponseDTO.active());

    }





}
