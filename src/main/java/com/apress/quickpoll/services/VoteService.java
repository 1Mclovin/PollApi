package com.apress.quickpoll.services;

import com.apress.quickpoll.domain.Vote;
import com.apress.quickpoll.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;


    public void addVote(Vote vote){
        voteRepository.save(vote);
    }

    //lets get all the votes

    public List<Vote> getVoteList(){
        List<Vote>voteList = new ArrayList<>();
        voteRepository.findAll().forEach(voteList:: add);

        return voteList;
    }





}
