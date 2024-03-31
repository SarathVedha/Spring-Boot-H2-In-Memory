package com.vedha.h2.service;

import com.vedha.h2.dto.DemoDTO;

import java.util.List;

public interface DemoService {

    List<DemoDTO> getAllDemoValues();

    String insertDemoValue(DemoDTO demoDTO);

    DemoDTO getDemoValueByID(long id);

    String deleteDemoById(long id);

    DemoDTO updateDemoById(long id, DemoDTO demoDTO);
}
