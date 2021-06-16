package com.predic8.scooter;

import com.predic8.scooter.model.Fahrt;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FahrtRepository extends CassandraRepository<Fahrt, String> {

    Optional<Fahrt> findByScooterId(String scooterId);
}