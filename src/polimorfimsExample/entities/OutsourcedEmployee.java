package polimorfimsExample.entities;

public class OutsourcedEmployee extends Employees{
    private Double additionalCharger;

    public OutsourcedEmployee() {
    }

    public OutsourcedEmployee(Double additionalCharger) {
        this.additionalCharger = additionalCharger;
    }

    public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharger) {
        super(name, hours, valuePerHour);
        this.additionalCharger = additionalCharger;
    }

    public Double getAdditionalCharger() {
        return additionalCharger;
    }

    public void setAdditionalCharger(Double additionalCharger) {
        this.additionalCharger = additionalCharger;
    }

    @Override
    public Double payment(){
        Double total = super.payment();
        total += additionalCharger;
        return total;
    }
}
