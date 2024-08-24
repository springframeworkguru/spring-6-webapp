package com.bugracdnc.spring6webapp.repositories;

import com.bugracdnc.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
