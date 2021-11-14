package com.apress.quickpoll.controller;

import com.apress.quickpoll.domain.Poll;
import com.apress.quickpoll.repositories.PollRepository;
import com.apress.quickpoll.services.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PollController {

    // this may give in issue this @ below. If this doesnt work try @Autowired
    //yup didint work with @Inject

   @Autowired
    private PollService pollService;

   @Autowired
   private PollRepository pollRepository;
 //   private Component responseHeaders;

//   @RequestMapping(value="/polls", method= RequestMethod.GET)
//    public ResponseEntity<Iterable<Poll>> getAllPolls(){
//       Iterable<Poll> allPolls = pollRepository.findAll();
//       return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
//   }

//@GetMapping("/polls")
//public List<Poll> getPolls(){
//    return (List<Poll>) pollRepository.findAll();
//}
 @GetMapping("/polls")
 public ResponseEntity<Iterable<Poll>> getPolls(){
  return pollService.getPollList();
 }



 //create a new poll
//    @RequestMapping(value="/polls", method=RequestMethod.POST)
//    public ResponseEntity<?> createPoll(@RequestBody Poll poll){
//
//    poll= pollRepository.save(poll);
//        URI newPollUri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(poll.getId())
//                .toUri();
//        responseHeaders.setLocation(newPollUri);
//
//    return new ResponseEntity<>(null, HttpStatus.CREATED);
//    }

//    //YEAHHHHH fukin works
//    @PostMapping("/polls")
//    public void registerPoll(@RequestBody Poll poll){
//    pollRepository.save(poll);
//    }
//
// @PostMapping("/polls")
// public void registerPoll(@RequestBody Poll poll){
//  pollService.createPoll(poll);
//
// }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }


@GetMapping("/polls/{id}")
public ResponseEntity<?> getPollById(@PathVariable Long id){
  return pollService.getPoll(id);
}


//@RequestMapping(value ="/polls/{pollId}", method = RequestMethod.GET)
// public ResponseEntity<?> getPoll(@PathVariable Long pollId){
//  Poll p = pollRepositor
//}


 //delete mapping
 @DeleteMapping("/polls/{id}")
 public void deletePollifPossible(@PathVariable Long id){
  pollService.deletePoll(id);
 }

 //edit poll
    @PutMapping("/polls/{id}")
    public void updatePolls(@RequestBody Poll poll, @PathVariable Long id){
     pollService.updatePoll(poll,id);
    }
//
//    @PostMapping("/polls")
//    public void sendError(@RequestBody Poll poll){
//     pollService.
//    }
//

}
