package at.aau.ue5.bsp4;

public class SmellyClass {

    public void erstelleRechnung(Order order) {

        //calculate temporary price
        Double totalPrice=0.0d;
        for (Item item : order.getItems()) {
            totalPrice+=item.getPrice();
        }

        //check for shipping costs
        if(totalPrice<=100) {
            Item item = new Item();
            item.setId(99l);
            item.setName("Porto und Versand");
            if(totalPrice>90) {
                item.setPrice(totalPrice*0.05);
            } else if(totalPrice>50) {
                item.setPrice(7.5d);
            } else {
                item.setPrice(10d);
            }

            order.getItems().add(item);
        }

        totalPrice=0.0d;
        for (Item item : order.getItems()) {
            totalPrice+=item.getPrice();
        }

        System.out.println("Rechnung:");
        for (Item item : order.getItems()) {
            System.out.println(item.getName()+": "+item.getPrice());
        }
        System.out.println("Total: "+totalPrice);
    }
}
