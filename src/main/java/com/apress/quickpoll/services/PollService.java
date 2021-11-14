package com.apress.quickpoll.services;

import com.apress.quickpoll.domain.OptionA;
import com.apress.quickpoll.domain.Poll;
import com.apress.quickpoll.exception.ResourceNotFoundException;
import com.apress.quickpoll.repositories.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PollService {

//    @Autowired
//    private PollRepository pollRepository;
//
//
//    public List<Poll> getPollList(){
//        List<Poll>pollList = new ArrayList<>();
//        pollRepository.findAll().forEach(pollList::add);
//
//        return pollList;
//    }
//
//    public void addPoll(Poll poll){
//        pollRepository.save(poll);
//    }
//
//
//   public Optional<Poll> getSinglePoll(Long id){
//        return pollRepository.findById(id);
//   }
//
//    //delete method
//
//    public void deletePoll(Long id){
//        pollRepository.delete(pollRepository.getById(id));
//    }
//
//    //edit poll
//    public void editPoll(Long id, Poll poll){
//        pollRepository.save(poll);
//    }
//
@Autowired
private PollRepository pollRepository;

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {

        Poll poll = pollRepository.findById(pollId).orElse(null);

        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }

    }

    public ResponseEntity<Iterable<Poll>> getPollList() {

        Iterable<Poll> allPolls = pollRepository.findAll();

        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<?> createPoll(Poll poll) {

        poll = pollRepository.save(poll);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

    }

    public ResponseEntity<?> getPoll(Long pollId) {

        verifyPoll(pollId);

        Poll p = pollRepository.findById(pollId).orElse(null);

        if(p == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }

        return new ResponseEntity<>(p, HttpStatus.OK);

    }

    public ResponseEntity<?> updatePoll(Poll poll, Long pollId) {

        verifyPoll(pollId);

        Poll p = pollRepository.save(poll); // 'Saves' the entity

        return new ResponseEntity<>(HttpStatus.OK);

    }


    public ResponseEntity<?> deletePoll(Long pollId) {

        verifyPoll(pollId);

        pollRepository.deleteById(pollId);

        return new ResponseEntity<>(HttpStatus.OK);

    }





}
