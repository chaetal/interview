package org.bdshadow.interview;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @GetMapping("/count-money")
    public ResponseEntity<Integer> countMoney() throws InterruptedException {
        candidateService.countMoney();
        return new ResponseEntity<>(candidateService.getAllMoney().get(), HttpStatus.OK);
    }
}
