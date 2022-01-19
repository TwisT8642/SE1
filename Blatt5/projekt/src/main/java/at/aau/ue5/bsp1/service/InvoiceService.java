package at.aau.ue5.bsp1.service;

import java.util.List;

import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;

public interface InvoiceService {
	public Invoice createInvoice(List<Product> items, Customer customer)
			throws InvoiceServiceException;

	public void deleteInvoice(Invoice invoice) throws InvoiceServiceException;

	public List<Invoice> findAllInvoicesByCustomer(Customer customer)
			throws InvoiceServiceException;
}