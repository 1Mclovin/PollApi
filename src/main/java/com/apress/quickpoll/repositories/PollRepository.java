package com.apress.quickpoll.repositories;

import com.apress.quickpoll.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long > {

}
