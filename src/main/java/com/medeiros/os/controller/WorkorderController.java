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

}
