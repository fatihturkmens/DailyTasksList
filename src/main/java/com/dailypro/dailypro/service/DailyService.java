package com.dailypro.dailypro.service;

import com.dailypro.dailypro.dto.DailyDto;
import com.dailypro.dailypro.entity.Daily;
import com.dailypro.dailypro.repository.DailyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DailyService {

    @Autowired
    private DailyRepository dailyRepository;


    private Daily dailyordto(Daily daily,DailyDto dailyDto){
        daily.setName(dailyDto.getName());
        daily.setExplanation(dailyDto.getExplanation());
        daily.setCompleted(dailyDto.getCompleted());
        return   dailyRepository.save(daily);
    }

    public String save(DailyDto dailyDto){
       dailyordto(new Daily(),dailyDto);
       return "saved";
    }

    public Daily byid(Long id){
      Optional<Daily> daily=  dailyRepository.findById(id);
      if (daily.isPresent()){

       return  daily.get();
      }else {throw new EntityNotFoundException("Daily is not found");
    }
    }

    public List<Daily> getAll(){
        return dailyRepository.findAll();
    }
    public void delete(Long id){
       Optional<Daily> daily= dailyRepository.findById(id);
       if (daily.isPresent()){
           dailyRepository.deleteById(id);
       }
       else {

           throw new EntityNotFoundException("Daily is not found");
       }
    }

}
