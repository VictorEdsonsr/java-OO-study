package abstractMethodsEnums.entities.enums;

import abstractMethodsEnums.entities.utils.Calculate;

public enum CalculatorEnum {
    SOMA('+') {
        @Override
        public void calculate(int num1, int num2) {
            System.out.println("Soma: " + Calculate.soma(num1,num2));
        }
    },
    SUBTRACAO('-') {
        @Override
        public void calculate(int num1, int num2) {
            System.out.println("Subtração: " + Calculate.subtracao(num1,num2));
        }
    },
    DIVISAO('/') {
        @Override
        public void calculate(int num1, int num2) {
            System.out.println("Divisão: " + Calculate.divisao(num1,num2));
        }
    },
    MULTIPLICACAO('*') {
        @Override
        public void calculate(int num1, int num2) {
            System.out.println("Multiplicação: " + Calculate.multiplicacao(num1,num2));
        }
    };

    private Character code;

    private CalculatorEnum(Character code){
        this.code = code;
    }

    public abstract void calculate(int num1, int num2);

}
