package com.medeiros.os.service;


import com.medeiros.os.controller.equipment.EquipmentRequestDTO;
import com.medeiros.os.controller.equipment.EquipmentResponseDTO;
import com.medeiros.os.exceptions.CodeAlreadyExistsException;
import com.medeiros.os.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentResponseDTO createEquipment(EquipmentRequestDTO equipmentRequestDTO){

        if (equipmentRepository.existsByCode(equipmentRequestDTO.code())){
            throw new CodeAlreadyExistsException("Equipment of code " + equipmentRequestDTO.code() + " already exists");
        }




    }

}
