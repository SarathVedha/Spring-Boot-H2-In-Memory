package com.vedha.h2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoDTO {

    private long id;

    private String name;

    private long age;

    private String address;
}
