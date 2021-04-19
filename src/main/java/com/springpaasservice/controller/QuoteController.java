package com.springpaasservice.controller;

import com.springpaasservice.model.QuoteEntity;
import com.springpaasservice.service.QuoteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// marks this class as a controller that can process the incoming HTTP requests.
@RequestMapping("/v1/quote")
// sets the base path to the resource endpoints in the controller as /api/v1/quote
public class QuoteController {

   QuoteService quoteService;

   public QuoteController(QuoteService quoteService) {
      this.quoteService = quoteService;
   }

   @GetMapping("/getAll")
   public ResponseEntity<List<QuoteEntity>> getQuotes() {
      List<QuoteEntity> quotes = quoteService.getAll();
      return new ResponseEntity<>(quotes, HttpStatus.OK);
   }

   @GetMapping({"/get/{id}"})
   public ResponseEntity<QuoteEntity> getQuote(@PathVariable Long id) {
      return new ResponseEntity<>(quoteService.getById(id), HttpStatus.OK);
   }

   @PostMapping("/save")
   public ResponseEntity<QuoteEntity> saveQuote(@RequestBody QuoteEntity quote) {
      QuoteEntity quote1 = quoteService.save(quote);
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add("quote", "/api/v1/quote/" + quote1.getId().toString());
      return new ResponseEntity<>(quote1, httpHeaders, HttpStatus.CREATED);
   }

   @PutMapping({"/update/{id}"})
   public ResponseEntity<QuoteEntity> updateQuote(@PathVariable("id") Long id, @RequestBody QuoteEntity quote) {
      quoteService.update(id, quote);
      return new ResponseEntity<>(quoteService.getById(id), HttpStatus.OK);
   }

   @DeleteMapping({"/delete/{id}"})
   public ResponseEntity<QuoteEntity> deleteQuote(@PathVariable("id") Long id) {
      quoteService.delete(id);
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
   }

}
