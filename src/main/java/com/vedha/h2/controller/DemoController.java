package com.vedha.h2.controller;

import com.vedha.h2.dto.DemoDTO;
import com.vedha.h2.service.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("/api/demo")
@RequiredArgsConstructor
@Tag(name = "Demo", description = "Demo Table H2 InMemory DataBase")
public class DemoController {

    private final DemoService demoService;

    @GetMapping(value = { "/v1/all" }, consumes = MediaType.ALL_VALUE, produces = { MediaType.APPLICATION_JSON_VALUE } )
    @Operation(summary = "Get All Demo", description = "Get All Demo From H2")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<List<DemoDTO>> getDemoData() {

        log.error("Entering DemoController getDemoData()");

        List<DemoDTO> allValues = demoService.getAllDemoValues();

        log.error("Leaving DemoController getDemoData()");

        return ResponseEntity.ok(allValues);
    }

    @PostMapping(value = { "/v1/insert" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "Insert Demo", description = "Insert Demo In H2")
    @ApiResponse(responseCode = "201", description = "HTTP 201 Created")
    public ResponseEntity<String> insertDemo(@RequestBody DemoDTO demoDTO) {

        log.error("Entering DemoController insertDemo()");

        String insertDemo = demoService.insertDemoValue(demoDTO);

        log.error("Leaving DemoController insertDemo()");

        return new ResponseEntity<>(insertDemo, HttpStatus.CREATED);
    }

    @GetMapping(value = { "/v1/byId" }, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Demo By Id", description = "Get Demo By Id In H2")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    public ResponseEntity<DemoDTO> getDemoById(@RequestParam("id") long id) {

        log.error("Entering DemoController getDemoById()");

        DemoDTO demoValueByID = demoService.getDemoValueByID(id);

        log.error("Leaving DemoController getDemoById()");

        return ResponseEntity.ok(demoValueByID);
    }

    @DeleteMapping(value = "/v1/byId", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
    @Operation(summary = "Delete By Id", description = "Delete Demo By Id")
    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    public ResponseEntity<String> deleteById(@RequestParam("id") long id){

        log.error("Entering DemoController deleteById()");

        String s = demoService.deleteDemoById(id);

        log.error("Leaving DemoController deleteById()");

        return ResponseEntity.ok(s);
    }

    @PutMapping(value = "/v1/byId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update By Id", description = "Update User By Id")
    @ApiResponse(responseCode = "201", description = "Http Status 201 Updated")
    public ResponseEntity<DemoDTO> updateById(@RequestParam("id") long id, @RequestBody DemoDTO demoDTO) {

        log.error("Entering DemoController updateById()");

        DemoDTO demoDTO1 = demoService.updateDemoById(id, demoDTO);

        log.error("Leaving DemoController updateById()");

        return new ResponseEntity<>(demoDTO1, HttpStatus.CREATED);
    }

}