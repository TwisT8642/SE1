package at.aau.ue5.bsp4;

public class Item {
    private Long id;
    private Double price;
    private String name;

    //Hinzufügen eines Konstruktors
    public Item(Long id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
