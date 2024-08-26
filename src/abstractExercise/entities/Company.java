package abstractExercise.entities;

public class Company extends TaxPayer{
    private Integer numbersOfEmployees;

    public Company() {
    }

    public Company(String name, Double anualIncome, Integer numbersOfEmployees) {
        super(name, anualIncome);
        this.numbersOfEmployees = numbersOfEmployees;
    }

    public Integer getNumbersOfEmployees() {
        return numbersOfEmployees;
    }

    public void setNumbersOfEmployees(Integer numbersOfEmployees) {
        this.numbersOfEmployees = numbersOfEmployees;
    }


    @Override
    public Double tax() {
        Double totalTax;
        if(this.numbersOfEmployees > 10 ){
            totalTax = this.anualIncome * 14/100;
        }else{
            totalTax = this.anualIncome * 16/100;
        }
        return totalTax;
    }


}
