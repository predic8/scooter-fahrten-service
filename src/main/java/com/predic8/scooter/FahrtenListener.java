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
        fahrtRepository.save(new Fahrt(om.readValue(verleih, VerleihDTO.class)));
    }

    @KafkaListener(topics = "scooter.rueckgabe")
    public void rueckgabeListener(String rueckgabe) throws JsonProcessingException {
        RueckgabeDTO rueckgabeDTO = om.readValue(rueckgabe, RueckgabeDTO.class);
        Optional<Fahrt> byId = fahrtRepository.findByFahrtId(rueckgabeDTO.getFahrtId());

        if (!byId.isPresent()) {
            log.error("Unable to find Scooter " + rueckgabeDTO.getScooterId());
            return;
        }

        Fahrt fahrt = byId.get();
        fahrt.setEnd(rueckgabeDTO.getRueckgabe());
        fahrtRepository.save(fahrt);
    }

}
