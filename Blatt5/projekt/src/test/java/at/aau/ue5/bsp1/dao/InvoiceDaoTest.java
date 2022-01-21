package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListInvoiceDao;
import at.aau.ue5.bsp1.entity.Customer;
import at.aau.ue5.bsp1.entity.Invoice;
import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceDaoTest {
    private ListInvoiceDao a;
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

    @BeforeEach
    public void setup() {
        f = new Product((long) 1, "Apfel", 0.5);
        g = new Product((long) 2, "Banane", 0.3);
        h = new Product((long) 3, "Erdbeere", 0.4);

        l = new ArrayList<>();
        m = new ArrayList<>();
        l.add(f);
        l.add(g);
        m.add(h);
        m.add(f);

        i = new Customer(1L, "Stefan", "Domplatz 15");
        j = new Customer(2L, "Uwe", "Kardinalsplatz 33");
        k = new Customer(3L, "Zankolo", "Limbeckerplatz 3");

        a = new ListInvoiceDao();
        b = new Invoice(1L, i, m, true);
        c = new Invoice(2L, j, l, true);
        d = new Invoice(1L, k, m, false);
        e = new ArrayList<>();

    }


    @Test
    public void ifInvoicebIsInserted_ThenReturnInvoiceb() {
        a.insert(b);
        assertEquals(b, a.findOne((long) 1));
    }

    @Test
    public void ifTheInvoiceIsNotInserted_ThenReturnNull() {
        a.insert(b);
        assertEquals(null, a.findOne((long) 2));
    }

    @Test
    public void ifInvoicesAreInTheList_ThenReturnTheListWithTheInvoices() {
        a.insert(b);
        e.add(b);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifNoInvoicesAreInTheList_ThenReturnAnEmptyList() {
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifAElementIsInserted_ThenReturnTheElement() {
        assertEquals(b, a.insert(b));

    }

    @Test
    public void ifElementsAreInserted_ThenGiveThemANewID() {
        a.insert(b);
        a.insert(c);
        a.insert(d);

        assertEquals(b, a.findOne(1L));
        assertEquals(c, a.findOne(2L));
        assertEquals(d, a.findOne(3L));
    }

    @Test
    public void ifInvoiceIsDeleted_ThenItShouldNotAppearInTheList() {
        a.insert(b);
        a.insert(c);
        a.delete((long) 1);
        e.add(c);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifInvoiceInEmptyListIsDeleted_ThenListShouldStayEmptyAndNothingIsChanged() {
        a.delete((long) 1);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifInvoiceIsUpdated_ThenTheUpdatedInvoiceShouldAppearInTheListInsteadOfTheOldOne() {
        a.insert(b);
        a.insert(c);
        a.update(d);
        e.add(c);
        e.add(d);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifInvoiceIsUpdated_ThenReturnTheOldInvoice() {
        a.insert(b);
        a.insert(c);
        assertEquals(b, a.update(d));
    }
}



