package com.celean.spring21.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesLogItem {
    private String serviceName;
    private Long serviceTiming;
}
