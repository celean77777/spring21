package com.celean.spring21.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesLog {
    private List<ServicesLogItem> item = new ArrayList<>();
}
