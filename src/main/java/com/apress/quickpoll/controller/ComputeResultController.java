package com.apress.quickpoll.controller;

import com.apress.quickpoll.domain.Vote;
import com.apress.quickpoll.dto.VoteResult;
import com.apress.quickpoll.repositories.VoteRepository;
import com.apress.quickpoll.services.ComputeResultService;
import com.google.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeResultController {

    @Autowired
    private ComputeResultService computeResultService;

    @RequestMapping(value="/computeresult", method=RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        return computeResultService.computeResult(pollId);
    }







}
