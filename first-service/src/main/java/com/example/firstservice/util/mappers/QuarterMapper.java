package com.example.firstservice.util.mappers;

import com.example.firstservice.models.QuarterResponseDTO;
import com.example.firstservice.util.enums.Quarter;
import org.springframework.stereotype.Component;

@Component
public class QuarterMapper {
    public QuarterResponseDTO toDTO(Quarter quarter) {
        return new QuarterResponseDTO(
                quarter
        );
    }
}
