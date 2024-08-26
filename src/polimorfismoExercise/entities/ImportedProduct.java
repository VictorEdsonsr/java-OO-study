package polimorfismoExercise.entities;

public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct() {
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice(){
        Double total = 0.0;
        total += this.price + this.customsFee;
        return total;
    }

    @Override
    public String priceTag(){
        return this.name + " - $" + String.format("%.2f",this.totalPrice()) + " (Customs Fee: $" + String.format("%.2f",this.customsFee) + ")";
    }
}
