package com.celean.spring21.controllers;

import com.celean.spring21.aspect.LogService;
import com.celean.spring21.dto.ProductDto;
import com.celean.spring21.models.ServicesLogItem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/statistic")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping
    public List<ServicesLogItem> getlog() {
        return logService.getServicesLogger();
    }

}
