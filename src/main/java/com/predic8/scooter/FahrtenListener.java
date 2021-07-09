package com.predic8.scooter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.predic8.scooter.model.Fahrt;
import com.predic8.scooter.model.RueckgabeDTO;
import com.predic8.scooter.model.VerleihDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.util.Optional;

@Component
public class FahrtenListener {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    ObjectMapper om;

    @Autowired
    FahrtRepository fahrtRepository;

    @KafkaListener(topics = "scooter.ausleihe")
    public void listener(String verleih) throws JsonProcessingException {
        // TODO
    }

    @KafkaListener(topics = "scooter.rueckgabe")
    public void rueckgabeListener(String rueckgabe) throws JsonProcessingException {
        // TODO
    }

}
