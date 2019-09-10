package com.bank.repository;

import com.bank.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * MongoDB
 */
public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    List<Invoice> findByLastName(String lastName);
}
