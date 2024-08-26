package polimorfismoExercise.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate manufacturedDate;


    public UsedProduct(String name, Double price, LocalDate manufacturedDate) {
        super(name, price);
        this.manufacturedDate = manufacturedDate;
    }

    public String getManufacturedDate() {
        return manufacturedDate.format(formatter);
    }

    public void setManufacturedDate(LocalDate manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    @Override
    public String priceTag() {
        return this.name + "(used) - $" + String.format("%.2f",this.price) + " (Manufacture date: " + this.getManufacturedDate() + ")";
    }
}
