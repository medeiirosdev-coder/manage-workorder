package com.medeiros.os.controller;


import com.medeiros.os.dto.equipment.EquipmentRequestDTO;
import com.medeiros.os.dto.equipment.EquipmentResponseDTO;
import com.medeiros.os.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;


    @GetMapping("/equipment/{code}")
    public ResponseEntity<EquipmentResponseDTO> findEquipment(@PathVariable String code){

        return ResponseEntity.ok(equipmentService.findEquipment(code));

    }

    @PostMapping("/equipment")
    public ResponseEntity<EquipmentResponseDTO> createEquipment(@RequestBody EquipmentRequestDTO requestDTO){

        return ResponseEntity.ok(equipmentService.createEquipment(requestDTO));


    }




}
