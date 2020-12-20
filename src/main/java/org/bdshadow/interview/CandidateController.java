package org.bdshadow.interview;

import lombok.RequiredArgsConstructor;
import org.bdshadow.interview.jpa.Candidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> findAllCandidates() {
        return new ResponseEntity<>(candidateService.getAllCandidates(), HttpStatus.OK);
    }

    // TODO: fix this method
    @GetMapping("/candidates-no-status")
    public ResponseEntity<List<Candidate>> findCandidatesWithNoStatus() {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
}
