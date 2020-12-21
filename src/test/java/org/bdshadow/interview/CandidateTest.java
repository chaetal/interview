package org.bdshadow.interview;

import org.bdshadow.interview.jpa.Candidate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CandidateTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void testAllCandidates() {
        ResponseEntity<Candidate[]> candidates = restTemplate.getForEntity("http://localhost:" + port + "/candidates",
                Candidate[].class);
        assertEquals(3, candidates.getBody().length);
    }

    @Test
    void testNullStatusCandidates() {
        ResponseEntity<Candidate[]> candidates = restTemplate.getForEntity("http://localhost:" + port + "/candidates-no-status",
                Candidate[].class);
        assertEquals(1, candidates.getBody().length);
    }
}
