package ru.gr05506.domain;

import java.util.function.DoubleUnaryOperator;

public class TimedCalculationMethod implements CalculationMethod{
    private final CalculationMethod inner;
    private long elapsed;

    public TimedCalculationMethod(CalculationMethod inner){
        this.inner = inner;
    }

    @Override
    public double calculation(DoubleUnaryOperator f, double a, double b, int n) {
        var start = System.nanoTime();
        double result = inner.calculation(f, a, b, n);
        var end = System.nanoTime();
        elapsed = end - start;
        return result;
    }

    public long getElapsed() {
        return elapsed;
    }
}
