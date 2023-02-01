package project.coffee.dao;

import org.springframework.data.repository.CrudRepository;

import project.coffee.model.Invoice;

public interface InvoiceDAO extends CrudRepository<Invoice, Integer>{

}
