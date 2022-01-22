package at.aau.ue5.bsp1.service;

import java.util.List;

import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;

public interface InvoiceService {
	Invoice createInvoice(List<Product> items, Customer customer)
			throws InvoiceServiceException;

	void deleteInvoice(Invoice invoice) throws InvoiceServiceException;

	List<Invoice> findAllInvoicesByCustomer(Customer customer)
			throws InvoiceServiceException;
}