package com.vedha.h2.repository;

import com.vedha.h2.dto.DemoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DemoRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<DemoDTO> getAllValues() {

        log.error("Entering DemoRepository getAllValues()");

        String query = "select * from users";

        List<DemoDTO> values = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(DemoDTO.class));

        log.error("Leaving DemoRepository getAllValues()");

        return values;
    }

    public int insertDemo(DemoDTO demoDTO) {

        log.error("Entering DemoRepository insertDemo()");

        int update = jdbcTemplate.update("insert into users (id, name, age, address) values (?, ?, ?, ?)", demoDTO.getId(), demoDTO.getName(), demoDTO.getAge(), demoDTO.getAddress());

        log.error("Leaving DemoRepository insertDemo()");

        return  update;
    }

    public DemoDTO getDemoById(long id) {

        log.error("Entering DemoRepository getDemoById()");

        DemoDTO demoDTO = jdbcTemplate.queryForObject("select * from users where id = ?", new BeanPropertyRowMapper<>(DemoDTO.class), id);

        log.error("Leaving DemoRepository getDemoById()");

        return demoDTO;
    }

    public Integer deleteDemoById(long id) {

        log.error("Entering DemoRepository deleteDemoById()");

        int update = jdbcTemplate.update("delete from users where id = ?", id);

        log.error("Leaving DemoRepository deleteDemoById()");

        return update;
    }

    public Integer updateDemoById(long id, DemoDTO demoDTO) {

        log.error("Entering DemoRepository updateDemoById()");

        int update = jdbcTemplate.update("update users set name = ?, age = ?, address = ? where id = ?", demoDTO.getName(), demoDTO.getAge(), demoDTO.getAddress(), id);

        log.error("Leaving DemoRepository updateDemoById()");

        return  update;
    }
}
