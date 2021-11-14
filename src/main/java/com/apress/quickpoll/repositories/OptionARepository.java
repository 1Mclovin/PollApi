package com.apress.quickpoll.repositories;

import com.apress.quickpoll.domain.OptionA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OptionARepository extends CrudRepository<OptionA,Long> {
}
