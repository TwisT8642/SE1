//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListCustomerDao;
import at.aau.ue5.bsp1.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDaoTest {
    private ListCustomerDao a;
    private Customer b;
    private Customer c;
    private Customer d;
    private List<Customer> e;
    private Customer f;


    @BeforeEach
    public void setup (){
        a = new ListCustomerDao();
        b = new Customer( 1L,"Stefan","Domplatz 15");
        c = new Customer(2L,"Uwe", "Kardinalsplatz 33");
        d = new Customer(1L, "Zankolo","Limbeckerplatz 3");
        e = new ArrayList<>();
        f = new Customer(3L,"Stefan", "Voelkermarkterstraße 75");

    }


    @Test
    public void ifCustomerbIsInserted_ThenReturnCustomerb(){
        a.insert(b);
        assertEquals(b, a.findOne((long) 1));
    }

    @Test
    public void ifTheCustomerIsNotInserted_ThenReturnNull() {
        a.insert(b);
        assertEquals(null, a.findOne((long) 2));
    }

    @Test
    public void ifCustomersAreInTheList_ThenReturnTheListWithTheCustomers() {
        a.insert(b);
        e.add(b);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifNoCustomersAreInTheList_ThenReturnAnEmptyList(){
        assertEquals(e,a.findAll());
    }

    @Test
    public void ifAElementIsInserted_ThenReturnTheElement(){
        assertEquals(b,a.insert(b));

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
    public void ifCustomerIsDeleted_ThenItShouldNotAppearInTheList(){
        a.insert(b);
        a.insert(c);
        a.delete((long) 1);
        e.add(c);
        assertEquals(e,a.findAll());
    }

    @Test
    public void ifCustomerInEmptyListIsDeleted_ThenListShouldStayEmptyAndNothingIsChanged(){
        a.delete((long) 1);
        assertEquals(e,a.findAll());
    }
    @Test
    public void ifCustomerIsUpdated_ThenTheUpdatedCustomerShouldAppearInTheListInsteadOfTheOldOne(){
        a.insert(b);
        a.insert(c);
        a.update(d);
        e.add(c);
        e.add(d);
        assertEquals(e,a.findAll());
    }
    @Test
    public void ifCustomerIsUpdated_ThenReturnTheOldCustomer(){
        a.insert(b);
        a.insert(c);
        assertEquals(b,a.update(d));
    }

    @Test
    public void ifDifferentCustomersAreInserted_ThenReturnOnlyTheRightCustomers (){
        a.insert(b);
        a.insert(c);
        a.insert(d);
        a.insert(f);
        e.add(b);
        e.add(f);
        assertEquals(e,a.findCustomerByName("Stefan"));
    }

    @Test
    public void ifListIsEmpty_ReturnAnEmptyList(){
        assertEquals(e,a.findCustomerByName("Olaf"));
    }
}
