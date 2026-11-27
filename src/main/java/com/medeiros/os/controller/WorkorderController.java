package com.medeiros.os.controller;

import com.medeiros.os.dto.workorder.WorkorderRequestDTO;
import com.medeiros.os.dto.workorder.WorkorderResponseDTO;
import com.medeiros.os.service.WorkorderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkorderController {

    private final WorkorderService workorderService;

    @PostMapping("/workorders")
    public ResponseEntity<WorkorderResponseDTO> createWO(@RequestBody @Valid WorkorderRequestDTO woRequestDTO){

        return ResponseEntity.ok(workorderService.createWO(woRequestDTO));

    }

}
