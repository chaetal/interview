package org.bdshadow.interview.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    @Override
    List<Candidate> findAll();
}
