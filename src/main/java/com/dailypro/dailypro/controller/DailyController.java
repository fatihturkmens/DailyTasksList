package com.dailypro.dailypro.controller;

import com.dailypro.dailypro.dto.DailyDto;
import com.dailypro.dailypro.entity.Daily;
import com.dailypro.dailypro.service.DailyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/daily")
public class DailyController {


    @Autowired
    private DailyService dailyService;


    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestBody @Valid DailyDto dailyDto){
        dailyService.save(dailyDto);
        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Daily> get (@PathVariable  Long id){
       Daily daily= dailyService.byid(id);
       return new ResponseEntity<>(daily,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Daily>>getall(){
        List<Daily> list = dailyService.getAll();
       return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        dailyService.delete(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
}
