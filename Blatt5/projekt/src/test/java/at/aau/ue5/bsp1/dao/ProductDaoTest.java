//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp1.dao;

import at.aau.ue5.bsp1.dao.impl.ListProductDao;
import static org.junit.jupiter.api.Assertions.*;

import at.aau.ue5.bsp1.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductDaoTest {
    private ListProductDao a;
    private Product b;
    private Product c;
    private Product d;
    private List<Product> e;


    @BeforeEach
    public void setup (){
        a = new ListProductDao();
        b = new Product((long) 1,"Apfel",0.5);
        c = new Product((long) 2,"Banane", 0.3);
        d = new Product((long) 1, "Erdbeere",0.4);
        e = new ArrayList<>();

    }


    @Test
    public void ifProductbIsInserted_ThenReturnProductb(){
    a.insert(b);
    assertEquals(b, a.findOne((long) 1));
    }

    @Test
    public void ifTheProductIsNotInserted_ThenReturnNull() {
        a.insert(b);
        assertEquals(null, a.findOne((long) 2));
    }

    @Test
    public void ifProductsAreInTheList_ThenReturnTheListWithTheProducts() {
        a.insert(b);
        e.add(b);
        assertEquals(e, a.findAll());
    }

    @Test
    public void ifNoProductsAreInTheList_ThenReturnAnEmptyList(){
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
    public void ifProductIsDeleted_ThenItShouldNotAppearInTheList(){
        a.insert(b);
        a.insert(c);
        a.delete((long) 1);
        e.add(c);
        assertEquals(e,a.findAll());
    }

    @Test
    public void ifProductInEmptyListIsDeleted_ThenListShouldStayEmptyAndNothingIsChanged(){
        a.delete((long) 1);
        assertEquals(e,a.findAll());
    }
    @Test
    public void ifProductIsUpdated_ThenTheUpdatedProductShouldAppearInTheListInsteadOfTheOldOne(){
        a.insert(b);
        a.insert(c);
        a.update(d);
        e.add(c);
        e.add(d);
        assertEquals(e,a.findAll());
    }
    @Test
    public void ifProductIsUpdated_ThenReturnTheOldProduct(){
        a.insert(b);
        a.insert(c);
        assertEquals(b,a.update(d));
    }






}
