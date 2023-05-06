package AdminPackage;

public class Product {
    private String name;
    private double price;
    private String decription;
    private int quantity;


    public Product(String name, double price, String decription) {
        this.name = name;
        this.price = price;
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getDecription() {
        return decription;
    }
    public String toString() {
        return getName() + "," + getPrice() + "," + getDecription();
    }
}

