package project.coffee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.coffee.dao.InvoiceDAO;
import project.coffee.model.Invoice;

public class InvoiceService {
	@Autowired
	private InvoiceDAO dao;
	
	public List<Invoice> getAll(){
		List<Invoice> invoices = new ArrayList<Invoice>();
		dao.findAll().forEach((Invoice i)->{
			invoices.add(i);
		});
		return invoices;
	}
	
	public Invoice findInvoices(Integer Inv_id) {
		return dao.findById(Inv_id).get();
	}
	
	public Invoice add(Invoice invoice) {
		return dao.save(invoice);
	}
	
	public Invoice update(Invoice invoice) {
		return dao.save(invoice);
	}
	
	public void delete(int Inv_Id) {
		dao.deleteById(Inv_Id);
	}
}
