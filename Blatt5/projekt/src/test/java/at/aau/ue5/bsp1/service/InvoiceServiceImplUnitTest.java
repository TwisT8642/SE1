package at.aau.ue5.bsp1.service;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;
import com.google.inject.spi.BindingScopingVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceImplUnitTest {

    @Mock
    private ListCustomerDao customerDaoList;

    @Mock
    private ListInvoiceDao invoiceDaoList;

    @Mock
    private ListProductDao productDaoList;

    @InjectMocks
    InvoiceServiceImpl invoiceService;

    private Customer customer;
    private Product product;
    private ArrayList<Product> products;
    private Invoice invoice;
    private ArrayList<Invoice> invoices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer(1L, "Nico", "Klagenfurt");
        when(customerDaoList.findOne(any())).thenReturn(customer);
        product = new Product(1L, "Apfel", 1.59);
        when(productDaoList.findOne(any())).thenReturn(product);
        products = new ArrayList<>();
        products.add(product);
        invoice = new Invoice(1L,customer,products,false);
        when(invoiceDaoList.insert(any())).thenReturn(invoice);
        doNothing().when(invoiceDaoList).delete(any());
        when(invoiceDaoList.findOne(any())).thenReturn(invoice);
        invoices = new ArrayList<>();
        invoices.add(invoice);
        when(invoiceDaoList.findAll()).thenReturn(invoices);
    }

    @Test
    public void shouldAccessListsJustOneTime_WhenCreatingNewInvoice() throws InvoiceServiceException {
        Invoice testInvoice = new Invoice(1L,customer,products,false);
        assertEquals(testInvoice, invoiceService.createInvoice(products, customer));

        verify(customerDaoList, times(1)).findOne(1L);
        verify(productDaoList, times(1)).findOne(1L);
    }

    @Test
    public void shouldRemoveInvoice_WhenDeletingViaCustomer() throws InvoiceServiceException{
        Invoice testInvoice = new Invoice(1L,customer,products,false);
        invoiceService.deleteInvoice(testInvoice);

        verify(invoiceDaoList, times(1)).delete(any());
    }

    @Test
    public void shouldReturnInvoice_WhenSearchingForInvoice()throws InvoiceServiceException{
        assertEquals(invoices,invoiceService.findAllInvoicesByCustomer(customer));

        verify(invoiceDaoList,times(1)).findAll();
    }
}
