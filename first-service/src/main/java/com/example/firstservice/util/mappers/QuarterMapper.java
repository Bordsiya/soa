package com.example.firstservice.util.mappers;

import com.example.commonservice.model.QuarterResponseDTO;
import com.example.commonservice.enums.Quarter;
import org.springframework.stereotype.Component;

@Component
public class QuarterMapper {
    public QuarterResponseDTO toDTO(Quarter quarter) {
        return new QuarterResponseDTO(
                quarter
        );
    }
}
