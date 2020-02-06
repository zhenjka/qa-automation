package lv.qaguru.hw.one;

import org.junit.jupiter.api.Test;

class TaskTwo {

    @Test
    void mySecondHomeTask() {
        showCostsInfo(50000, 20);
        showCostsInfo(10000, 30);

    }

    private void showCostsInfo(double flightLength, int fuelPer100km) {
        System.out.println("The fuel cost for the dedicated flight is: " + ((flightLength / 100) * fuelPer100km * 3.57) + " EUR");
    }
}
