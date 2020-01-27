package lv.qaguru.hw.one;

import org.junit.jupiter.api.Test;

class TaskOne {

    @Test
    void myFirstHomeTask() {
        showCarInfo("Volvo", 5000.0, 228000);
        showCarInfo("Toyota", 27000.0, 0);

    }

    private void showCarInfo(String brand, double price, int mileage) {
        System.out.println("We sell " + brand + " car" + " with " + mileage + " mileage. The price is: " + price + " EUR");
    }
}
