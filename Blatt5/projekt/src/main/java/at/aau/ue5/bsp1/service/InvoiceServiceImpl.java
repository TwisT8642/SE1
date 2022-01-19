package at.aau.ue5.bsp1.service;

import java.util.ArrayList;
import java.util.List;

import at.aau.ue5.bsp1.dao.CustomerDao;
import at.aau.ue5.bsp1.dao.InvoiceDao;
import at.aau.ue5.bsp1.dao.ProductDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;

public class InvoiceServiceImpl implements InvoiceService {

	private InvoiceDao invoiceDao;
	private ProductDao productDao;
	private CustomerDao customerDao;

	public Invoice createInvoice(List<Product> items, Customer customer)
			throws InvoiceServiceException {
		checkCustomer(customer);
		checkProducts(items);
		
		Invoice newInvoice = new Invoice();
		newInvoice.setCustomer(customer);
		newInvoice.setItems(items);
		newInvoice.setPaid(false);
		
		newInvoice=invoiceDao.insert(newInvoice);
		
		return newInvoice;
	}

	public void deleteInvoice(Invoice invoice)
			throws InvoiceServiceException {
		checkInvoice(invoice);
		invoiceDao.delete(invoice.getId());
	}
	
	public List<Invoice> findAllInvoicesByCustomer(Customer customer)
			throws InvoiceServiceException {
		checkCustomer(customer);
		
		List<Invoice> retVal = new ArrayList<Invoice>();
		
		List<Invoice> findAll = invoiceDao.findAll();
		for (Invoice invoice : findAll) {
			if(invoice.getCustomer().getId()==customer.getId()) {
				retVal.add(invoice);
			}
		}
		
		return retVal;
	}
	
	public void checkInvoice(Invoice invoice) throws InvoiceServiceException {
		if(invoiceDao.findOne(invoice.getId())==null) {
			throw new InvoiceServiceException("Invoice does not exist ("+invoice.getId()+").");
		}
	}

	public void checkProducts(List<Product> items)
			throws InvoiceServiceException {
		for(Product p : items) {
			checkProduct(p);
		}
	}

	public void checkProduct(Product p) throws InvoiceServiceException {
		if(productDao.findOne(p.getId())==null) {
			throw new InvoiceServiceException("Product does not exist ("+p.getId()+").");
		}
	}

	public void checkCustomer(Customer customer)
			throws InvoiceServiceException {
		if(customerDao.findOne(customer.getId())==null) {
			throw new InvoiceServiceException("Customer does not exist.");
		}
	}

	public InvoiceDao getInvoiceDao() {
		return invoiceDao;
	}

	public void setInvoiceDao(InvoiceDao invoiceDao) {
		this.invoiceDao = invoiceDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
