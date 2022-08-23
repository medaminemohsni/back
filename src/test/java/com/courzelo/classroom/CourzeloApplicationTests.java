package com.courzelo.classroom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.courzelo.classroom.entities.Phase;
import com.courzelo.classroom.entities.dtos.PhaseDTO;
import com.courzelo.classroom.repositories.PhaseRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class CourzeloApplicationTests {
	@Autowired
	PhaseRepository phaseRepository;
	@Autowired
    private ModelMapper mapper;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getphases(){
		List<Phase> phases = phaseRepository.findAll();
		log.info("resultat" + Stream.of(phases).collect(Collectors.toList()));
	}

}
