package com.dailypro.dailypro.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class DailyDto {


    @NotEmpty(message = "title boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String name;


    @NotEmpty(message = "explanation boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String explanation;

    @NotEmpty(message = "completed boş bırakılamaz")
    @Size(min = 3,max = 30)
    private String completed;

}
