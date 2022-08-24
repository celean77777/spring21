package com.celean.spring21.aspect;

import com.celean.spring21.models.ServicesLog;
import com.celean.spring21.models.ServicesLogItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
    private final ServicesLog servicesLog;

    public List<ServicesLogItem> getServicesLogger() {
        return servicesLog.getItem();
    }
}