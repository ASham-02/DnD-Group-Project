package com.example.Create_Character.Controllers;

import com.example.Create_Character.DTOs.stat.CreateStatsRequest;
import com.example.Create_Character.DTOs.stat.StatsResponse;
import com.example.Create_Character.services.StatsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    private StatsService statsService;

    @GetMapping
    public ResponseEntity<List<StatsResponse>> getAllStats() {
        return ResponseEntity.ok(statsService.getAllStats());
    }
    @GetMapping("/{id}")
    public ResponseEntity<StatsResponse> getStatsById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(statsService.getStatsById(id));
    }

    //PURELY FOR STAT SHEET CREATION
    @PostMapping
    public ResponseEntity<StatsResponse> createStats(@Valid @RequestBody CreateStatsRequest newStatsSheet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statsService.addStats(newStatsSheet));
    }
}
