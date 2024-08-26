package abstractExercise.entities;

public class Individual extends TaxPayer{
    private Double healthExpenditures;

    public Individual() {
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }


    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        Double totalTax;
        if(this.anualIncome > 20000.00 ){
            totalTax = this.healthExpenditures > 0.0 ? (this.anualIncome * 25/100) - (this.healthExpenditures * 50/100) : (this.anualIncome * 25/100);
        }else{
            totalTax = this.healthExpenditures > 0.0 ? (this.anualIncome * 15/100) - (this.healthExpenditures * 50/100) : (this.anualIncome * 15/100);
        }

        return totalTax;
    }
}
