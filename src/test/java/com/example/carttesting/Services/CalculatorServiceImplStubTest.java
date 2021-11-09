package com.example.carttesting.Services;

import com.example.carttesting.Interfaces.CalculatorService;
import com.example.carttesting.Service.CalculatorServiceImple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

class CalculatorServiceMany implements CalculatorService {
    @Override
    public long[] getAll(){
        return new long[]{1,2,3};
    }
}

class CalculatorServiceEmpty implements CalculatorService{
    @Override
    public long[] getAll(){
        return new long[]{};
    }
}

public class CalculatorServiceImplStubTest {
    CalculatorServiceImple calculatorServiceImple = new CalculatorServiceImple();

    @Test
    public void calculateManyData(){
        calculatorServiceImple.setData(new CalculatorServiceMany());

        int result = calculatorServiceImple.calculate();
        int expected = 6;
        assertEquals(result,expected);
    }

    @Test
    public void calculateEmpty(){
        calculatorServiceImple.setData(new CalculatorServiceEmpty());

        int result = calculatorServiceImple.calculate();
        int expected = 0;
        assertEquals(result, expected);
    }
}













