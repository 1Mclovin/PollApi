package com.apress.quickpoll.services;

import com.apress.quickpoll.domain.Vote;
import com.apress.quickpoll.dto.OptionACount;
import com.apress.quickpoll.dto.VoteResult;
import com.apress.quickpoll.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ComputeResultService {

    @Autowired
    private VoteRepository voteRepository;

    public ResponseEntity<?> computeResult(Long pollId) {

        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

        int totalVotes = 0;
        Map<Long, OptionACount> tempMap = new HashMap<Long, OptionACount>();

        for (Vote v : allVotes) {

            totalVotes++;

            OptionACount optionACount = tempMap.get(v.getOption().getId());

            if (optionACount == null) {

                optionACount = new OptionACount();
                optionACount.setOptionId(v.getOption().getId());
                tempMap.put(v.getOption().getId(), optionACount);

            }
            optionACount.setCount(optionACount.getCount() + 1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

    }



}
