//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp4;

public class SmellyClassRefactored {

    //Aktuellen Preis berechnen (liste an Items)
    private Double getPrice(Order order) {
        Double totalPrice = 0.0d;
        for (Item item : order.getItems()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    //Hinzufügen der Versandkosten zur Bestellung (als Item)
    private Order addShippingCost(Double totalPrice, Order order) {
        if (totalPrice <= 100) {
            Item item = new Item();
            item.setId(99l);
            item.setName("Porto und Versand");
            if (totalPrice > 90) {
                item.setPrice(totalPrice * 0.05);
            } else if (totalPrice > 50) {
                item.setPrice(7.5d);
            } else {
                item.setPrice(10d);
            }
            order.getItems().add(item);
        }
        return order;
    }
    //printen der Rechnung
    private void printOrder(Order order, Double totalPrice) {
        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
        System.out.println("Total: " + totalPrice);
    }
    //Zusammenfügen der einzelnen Schritte um alles in einer Methode auszuführen und eine fertige Rechnung zu erhalten
    public void erstelleRechnung(Order order) {
        Double totalPrice = getPrice(order);
        order = addShippingCost(totalPrice, order);
        totalPrice = getPrice(order);
        printOrder(order, totalPrice);
    }







}


