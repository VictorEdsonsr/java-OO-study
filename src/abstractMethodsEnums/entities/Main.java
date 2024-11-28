package abstractMethodsEnums.entities;

import abstractMethodsEnums.entities.enums.CalculatorEnum;

public class Main{
    public static void main(String[] args){
        CalculatorEnum calculatorEnumSoma = CalculatorEnum.SOMA;
        CalculatorEnum calculatorEnumSubtracao = CalculatorEnum.SUBTRACAO;
        CalculatorEnum calculatorEnumDivisao = CalculatorEnum.DIVISAO;
        CalculatorEnum calculatorEnumMultiplicacao = CalculatorEnum.MULTIPLICACAO;

        int num = 1;
        int num2 = 3;


        calculatorEnumSoma.calculate(num,num2);
        calculatorEnumDivisao.calculate(num,num2);
        calculatorEnumMultiplicacao.calculate(num,num2);
        calculatorEnumSubtracao.calculate(num,num2);

    }
}
