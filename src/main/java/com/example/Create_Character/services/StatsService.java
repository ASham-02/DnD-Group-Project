package com.example.Create_Character.services;

import com.example.Create_Character.DTOs.stat.CreateStatsRequest;
import com.example.Create_Character.DTOs.stat.StatsResponse;
import com.example.Create_Character.models.Stat;
import com.example.Create_Character.repos.StatsRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatsService {
    private StatsRepo statsRepo;

    public StatsService(StatsRepo statsRepo) {
        this.statsRepo = statsRepo;
    }

    public StatsResponse getStatsById(Long id) {
        Stat stat = statsRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Stats Sheet for ID: %d does not exist.", id)));
        return mapToResponse(stat);
    }

    public List<StatsResponse> getAllStats() {
        return statsRepo.findAll().stream().map(this::mapToResponse).toList();
    }

    public StatsResponse addStats(CreateStatsRequest newStatsSheet) {
        if(statsRepo.existsByCharacter(newStatsSheet.getCharacterClassId())){
            throw new IllegalArgumentException("There is already a Stats Sheet for this Class");
        }
        Stat stat = new Stat();
        //if all works in other classes, this should be fine AND grab a string
        stat.setCharacterClassId(newStatsSheet.getCharacterClassId());
        stat.setStrength(newStatsSheet.getStrength());
        stat.setDexterity(newStatsSheet.getDexterity());
        stat.setIntelligence(newStatsSheet.getIntelligence());
        stat.setConstitution(newStatsSheet.getConstitution());
        stat.setWisdom(newStatsSheet.getWisdom());
        stat.setCharisma(newStatsSheet.getCharisma());
        Stat saved =  statsRepo.save(stat);
        return mapToResponse(saved);
    }

    private StatsResponse mapToResponse(Stat stat) {
        return new StatsResponse(stat.getId(),stat.getCharacterClassId(), stat.getStrength(), stat.getDexterity(), stat.getIntelligence(), stat.getConstitution(), stat.getWisdom(), stat.getCharisma());
    }
}
