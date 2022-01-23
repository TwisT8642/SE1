//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp1.service;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import at.aau.ue5.bsp1.service.exception.InvoiceServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceServiceImplIntegrationTest {
    //alte Variablen
    private Invoice b;
    private Invoice c;
    private Invoice d;
    private List<Invoice> e;

    private Product f;
    private Product g;
    private Product h;

    private Customer i;
    private Customer j;
    private Customer k;

    private List<Product> l;
    private List<Product> m;

    //neue Variablen
    private InvoiceServiceImpl a;
    private ListCustomerDao listCustomerDao;
    private ListInvoiceDao listInvoiceDao;
    private ListProductDao listProductDao;

    private List<Product> n;
    private Product o;
    private Customer p;
    private List<Product> q;
    private List<Customer> r;

    @BeforeEach
    public void setup() throws InvoiceServiceException {
        //Alte Testdaten
        f = new Product((long) 1, "Apfel", 0.5);
        g = new Product((long) 2, "Banane", 0.3);
        h = new Product((long) 3, "Erdbeere", 0.4);
        o = new Product(null,"Error",0.0);

        l = new ArrayList<>();
        m = new ArrayList<>();
        n = new ArrayList<>();
        l.add(f);
        l.add(g);
        m.add(h);
        m.add(f);
        n.add(g);
        n.add(o);
        n.add(f);

        i = new Customer(1L, "Stefan", "Domplatz 15");
        j = new Customer(2L, "Uwe", "Kardinalsplatz 33");
        k = new Customer(3L, "Zankolo", "Limbeckerplatz 3");
        p = new Customer(null, "Error","Error");

        b = new Invoice(1L, i, m, false);
        c = new Invoice(3L, j, l, false);
        d = new Invoice(2L, i, l, false);

        e = new ArrayList<Invoice>();
        e.add(b);
        e.add(d);

        //Neue Testdaten
        a = new InvoiceServiceImpl();
        listProductDao = new ListProductDao();
        listProductDao.insert(f);
        listProductDao.insert(g);
        listProductDao.insert(h);

        listCustomerDao = new ListCustomerDao();
        listCustomerDao.insert(i);
        listCustomerDao.insert(j);
        listCustomerDao.insert(k);

        listInvoiceDao = new ListInvoiceDao();
        a.setInvoiceDao(listInvoiceDao);


        a.setCustomerDao(listCustomerDao);
        a.setInvoiceDao(listInvoiceDao);
        a.setProductDao(listProductDao);

        q = new ArrayList<>();
        r = new ArrayList<>();
        q.add(f);
        q.add(g);
        q.add(h);

        r.add(i);
        r.add(j);
        r.add(k);

    }

    @Test
    public void ifInvoiceIsCreated_ThenReturnTheNewInvoice() throws InvoiceServiceException{
    assertEquals(b, a.createInvoice(m,i));
    }

    @Test
    public void ifInvoiceIsCreated_ThenItShouldAppearInTheInvoiceList() throws InvoiceServiceException{
        a.createInvoice(m,i);
        a.createInvoice(l,i);
        assertEquals(e,a.findAllInvoicesByCustomer(i));
    }

    @Test
    public void ifInvoiceIsDeleted_ThenItShouldDisappearFromTheList() throws InvoiceServiceException {
        Invoice z = a.createInvoice(m, i);
        a.createInvoice(l, i);
        assertEquals(e, a.findAllInvoicesByCustomer(i));
        a.deleteInvoice(z);
        e = new ArrayList<>();
        e.add(d);
        assertEquals(e,a.findAllInvoicesByCustomer(i));
    }
    @Test
    public void ifInvoiceToDeleteDoesNotExist_ThenThrowInvoiceServiceExceptionAndDontChangeTheList() throws InvoiceServiceException{
        a.createInvoice(m,i);
        a.createInvoice(l,i);
        assertEquals(e,a.findAllInvoicesByCustomer(i));
        assertThrows(InvoiceServiceException.class, ()-> a.deleteInvoice(c));
        assertEquals(e,a.findAllInvoicesByCustomer(i));
    }

    @Test
    public void ifInvoicesOfDifferentCustomersAreCreated_ThenFindOnlyTheInvoicesOfTheCustomerWeLookFor() throws InvoiceServiceException {
        a.createInvoice(m, i);
        a.createInvoice(l, i);
        a.createInvoice(m, j);
        assertEquals(e, a.findAllInvoicesByCustomer(i));
    }

        @Test
        public void ifInvoiceIsCreatedWithAProductWithIdNull_ThenThrowInvoiceServiceException() throws InvoiceServiceException{
            Exception e = assertThrows(InvoiceServiceException.class, () -> a.createInvoice(n,i));
            assertEquals(e.getMessage(), "Product does not exist ("+o.getId()+").");
        }

        @Test
        public void ifInvoiceIsCreatedWithACumstomerWithIdNull_ThenThrowInvoiceServiceException() throws InvoiceServiceException{
        Exception e = assertThrows(InvoiceServiceException.class, () -> a.createInvoice(n,p));
        assertEquals(e.getMessage(), "Customer does not exist.");
    }


    @Test
    public void ifYouLookForAllInvoicesOfACustomerWithIdNull_ThenThrowInvoiceServiceException() throws InvoiceServiceException{
        Exception e = assertThrows(InvoiceServiceException.class, () -> a.findAllInvoicesByCustomer(p));
        assertEquals(e.getMessage(), "Customer does not exist.");
    }


    @Test
    public void ifGetInvoiceDaoIsUsed_ThenGiveInvoiceDaoBack()throws InvoiceServiceException{
        e = new ArrayList<>();
        e.add(b);
        a.createInvoice(m,i);
        assertEquals(e, a.getInvoiceDao().findAll());
    }
    @Test
    public void ifGetProductDaoIsUsed_ThenGiveProductDaoBack()throws InvoiceServiceException{
        assertEquals(q, a.getProductDao().findAll());
    }
    @Test
    public void ifGetCustomerDaoIsUsed_ThenGiveCustomerDaoBack()throws InvoiceServiceException{
        assertEquals(r, a.getCustomerDao().findAll());
    }
}