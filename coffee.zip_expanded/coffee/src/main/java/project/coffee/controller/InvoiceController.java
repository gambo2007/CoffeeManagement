package project.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.coffee.model.Invoice;
import project.coffee.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService service;
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'STAFF')")
	@GetMapping(value = "/")
	public List<Invoice> getAll()
	{
		return service.getAll();
	}
	
	
	@GetMapping(value = "/get/{Inv_id}")
	public Invoice getCustomer_Order(@PathVariable("Inv_id")int Inv_Id)
	{
		return service.findInvoices(Inv_Id);
	}
	
	@PostMapping(value = "/add")
	public Invoice add(@RequestBody Invoice invoice) {
		return service.add(invoice);
	}
	
	@PutMapping(value = "/update/{Inv_id}")
	public Invoice update(@PathVariable("Inv_id")int Inv_Id, @RequestBody Invoice invoice)
	{
		invoice.setInv_Id(Inv_Id);
		return service.update(invoice);
	}
	
	@DeleteMapping(value = "delete/{Inv_id}")
	public void delete(@PathVariable("Inv_id") int Inv_Id)
	{
		service.delete(Inv_Id);
	}
}
