package com.example.mapping.domain.model.repository;

import com.example.mapping.domain.model.entity.invoice.InvoiceOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceOrderRepository extends CrudRepository<InvoiceOrder, Long> {
}
