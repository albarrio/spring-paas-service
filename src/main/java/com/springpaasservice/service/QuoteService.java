package com.springpaasservice.service;

import com.springpaasservice.model.QuoteEntity;
import java.util.List;

public interface QuoteService {

   List<QuoteEntity> getAll();

   QuoteEntity getById(Long id);

   QuoteEntity save(QuoteEntity quote);

   void update(Long id, QuoteEntity quote);

   void delete(Long id);

}
