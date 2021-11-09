package com.example.carttesting.Service;

import com.example.carttesting.Interfaces.CalculatorService;

public class CalculatorServiceImple {
    CalculatorService calculatorService;

    public void setData(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    public int calculate(){
        int sum = 0;
        for (long value : calculatorService.getAll()){
            sum += value;
        }
        return sum;
    }
}
