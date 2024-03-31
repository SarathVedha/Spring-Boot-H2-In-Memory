package com.vedha.h2.service.impl;

import com.vedha.h2.dto.DemoDTO;
import com.vedha.h2.repository.DemoRepository;
import com.vedha.h2.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    @Override
    public List<DemoDTO> getAllDemoValues() {

        log.error("Entering DemoServiceImpl getAllDemoValues()");

        List<DemoDTO> allValues = demoRepository.getAllValues();

        log.error("Leaving DemoServiceImpl getAllDemoValues()");

        return allValues;
    }

    @Override
    public String insertDemoValue(DemoDTO demoDTO) {

        String message;
        log.error("Entering DemoServiceImpl insertDemoValue()");

        int i = demoRepository.insertDemo(demoDTO);

        if (i > 0) {

            message = "Inserted Successfully : ".concat(String.valueOf(demoDTO.getId()));
        }else {

            message = "Something Wrong";
        }

        log.error("Leaving DemoServiceImpl insertDemoValue()");

        return message;
    }

    @Cacheable(value = "demo", key = "#id")
    @Override
    public DemoDTO getDemoValueByID(long id) {

        log.error("Entering DemoServiceImpl getDemoValueByID()");

        DemoDTO demoById = demoRepository.getDemoById(id);

        log.error("Leaving DemoServiceImpl getDemoValueByID()");

        return demoById;
    }

    @CacheEvict(value = "demo", key = "#id")
    @Override
    public String deleteDemoById(long id) {

        log.error("Entering DemoServiceImpl deleteDemoById()");

        String message;
        Integer integer = demoRepository.deleteDemoById(id);

        if (integer == 1) {

            message = "Deleted SuccessFully : ".concat(String.valueOf(id));
        }else {

            message = "No Data Found To Delete";
        }

        log.error("Leaving DemoServiceImpl deleteDemoById()");

        return message;
    }

    @CachePut(value = "demo", key = "#id")
    @Override
    public DemoDTO updateDemoById(long id, DemoDTO demoDTO) {

        log.error("Entering DemoServiceImpl updateDemoById()");

        Integer integer = demoRepository.updateDemoById(id, demoDTO);
        log.error("update count : " + integer);

        log.error("Leaving DemoServiceImpl updateDemoById()");
        if (integer == 1){

            return demoDTO;

        }else {

            return null;
        }

    }
}
