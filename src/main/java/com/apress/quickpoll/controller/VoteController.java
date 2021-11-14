package com.apress.quickpoll.controller;

import com.apress.quickpoll.domain.Vote;
import com.apress.quickpoll.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoteController {

    @Autowired
    VoteService voteService;


    @PostMapping("/polls/{id}/votes")
    public void registerVote(@RequestBody Vote castVote){
        voteService.addVote(castVote);
    }

    @GetMapping("/polls/{id}/votes")
    public List<Vote> getVotes(){
        return voteService.getVoteList();
    }








}
