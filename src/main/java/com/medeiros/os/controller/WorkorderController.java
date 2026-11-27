package com.medeiros.os.controller;

import com.medeiros.os.dto.workorder.WorkorderRequestDTO;
import com.medeiros.os.dto.workorder.WorkorderResponseDTO;
import com.medeiros.os.enums.Status;
import com.medeiros.os.service.WorkorderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workorders")
@RequiredArgsConstructor
public class WorkorderController {

    private final WorkorderService workorderService;

    @PostMapping
    public ResponseEntity<WorkorderResponseDTO> createWO(@RequestBody @Valid WorkorderRequestDTO woRequestDTO){

        return ResponseEntity.ok(workorderService.createWO(woRequestDTO));

    }

    @GetMapping
    public ResponseEntity<List<WorkorderResponseDTO>> fetchWOsOptStatus(@RequestParam (required = false) Status status){

        return ResponseEntity.ok(workorderService.fetchWOsOptStatus(status));


    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkorderResponseDTO> findById(@PathVariable UUID id){

        return ResponseEntity.ok(workorderService.findById(id));

    }

}
