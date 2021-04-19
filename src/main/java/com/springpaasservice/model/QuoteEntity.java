package com.springpaasservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
// shows that the class is a persistent Java class
@Data
// from project Lombok.
// generates the getters and setters for all the fields
// that we have in this class, equals(), toString()
@NoArgsConstructor
// generates an empty constructor
@AllArgsConstructor
// generates a constructor with all the fields
@Builder
public class QuoteEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(updatable = false, nullable = false)
   Long id;

   @Column
   String author;

   @Column
   String description;

   @CreationTimestamp
   @Column(updatable = false)
   Timestamp createTimestamp;

   @UpdateTimestamp
   Timestamp updateTimestamp;

}
