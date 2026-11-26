package com.medeiros.os.service;


import com.medeiros.os.dto.equipment.EquipmentRequestDTO;
import com.medeiros.os.dto.equipment.EquipmentResponseDTO;
import com.medeiros.os.domain.equipment.Equipment;
import com.medeiros.os.exceptions.CodeAlreadyExistsException;
import com.medeiros.os.exceptions.CodeNotExistsException;
import com.medeiros.os.repository.EquipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentResponseDTO createEquipment(EquipmentRequestDTO requestDTO){

        if (equipmentRepository.existsByCode(requestDTO.code())){
            throw new CodeAlreadyExistsException("Equipment with code " + requestDTO.code() + " already exists");
        }


        Equipment newEquipment = new Equipment();
        newEquipment.setCode(requestDTO.code());
        newEquipment.setName(requestDTO.name());
        newEquipment.setLocal(requestDTO.local());
        newEquipment.setActive(requestDTO.active());

        equipmentRepository.save(newEquipment);

        return toResponseDTO(newEquipment);


    }

    public EquipmentResponseDTO findEquipment(String code){

        Equipment equipment = equipmentRepository.findByCode(code)
                .orElseThrow(() -> new CodeNotExistsException("Equipment with code " + code + " does not exist!"));


        return this.toResponseDTO(equipment);

    }

    public List<EquipmentResponseDTO> findAll(){

        return equipmentRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();

    }

    public EquipmentResponseDTO toResponseDTO(Equipment equipment){

        return new EquipmentResponseDTO(equipment.getId(), equipment.getCode(),equipment.getName(),equipment.getLocal(),equipment.getActive());

    }

}
