//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        SmellyClassRefactored scr = new SmellyClassRefactored();
        SmellyClass sc = new SmellyClass();

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setVorname("Stefan");
        customer.setNachname("Haarbringer");

        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        item1.setId(1L);
        item1.setPrice(15.0d);
        item1.setName("Wein");

        item2.setId(2L);
        item2.setPrice(20.0d);
        item2.setName("Wodka");

        item3.setId(1L);
        item3.setPrice(25.0d);
        item3.setName("Champagner");

        ArrayList<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        ArrayList<Item> list2 = new ArrayList<>();
        list2.add(item1);
        list2.add(item2);
        list2.add(item3);

        Order order1 = new Order();
        order1.setId(1L);
        order1.setCustomer(customer);
        order1.setItems(list);

        Order order2 = new Order();
        order2.setId(1L);
        order2.setCustomer(customer);
        order2.setItems(list2);

        System.out.println("Bestellung 1 (SmellyClass)");
        sc.erstelleRechnung(order1);
        System.out.println("---------------------------------------");
        System.out.println("Bestellung 2 (SmellyClassRefactored)");
        scr.erstelleRechnung(order2);


    }
}
