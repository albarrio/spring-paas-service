package com.springpaasservice.repository;

import com.springpaasservice.model.QuoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// marks this interface as a Spring Data JPA repository.
public interface QuoteRepository extends CrudRepository<QuoteEntity, Long> {
}
