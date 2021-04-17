package com.springpaasservice.service;

import com.springpaasservice.model.QuoteEntity;
import com.springpaasservice.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// makes Spring context be aware of this class as a service.
public class QuoteServiceImpl implements QuoteService{

   QuoteRepository quoteRepository;

   public QuoteServiceImpl(QuoteRepository quoteRepository) {
      this.quoteRepository = quoteRepository;
   }

   @Override
   public List<QuoteEntity> getAll() {
      List<QuoteEntity> quoteList = new ArrayList<>();
      quoteRepository.findAll().forEach(quoteList::add);
      return quoteList;
   }

   @Override
   public QuoteEntity getById(Long id) {
      return quoteRepository.findById(id).orElse(null);
   }

   @Override
   public QuoteEntity save(QuoteEntity quote) {
      return quoteRepository.save(quote);
   }

   @Override
   public void update(Long id, QuoteEntity quoteToUpdate) {
      QuoteEntity quoteFromDb = quoteRepository.findById(id).orElse(null);
      if (quoteFromDb!=null) {
         quoteFromDb.setAuthor(quoteToUpdate.getAuthor());
         quoteFromDb.setDescription(quoteToUpdate.getDescription());
         quoteRepository.save(quoteFromDb);
      }
   }

   @Override
   public void delete(Long id) {
      quoteRepository.deleteById(id);
   }
}
