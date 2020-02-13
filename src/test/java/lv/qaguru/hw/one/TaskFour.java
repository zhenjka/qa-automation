package lv.qaguru.hw.one;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

public class TaskFour {

    @Test
    void myFourthHomeTask() {
        showDistanceBetweenTwoMapPoints(56.949650, 24.105186, 47.557281,13.646960 );

    }

    private void showDistanceBetweenTwoMapPoints(double lat1, double lon1, double lat2, double lon2) {
        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        DecimalFormat df = new DecimalFormat("0.00");

        double distance = 6371.01 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

        System.out.println("Distance between two points is: " + df.format(distance) + " km");
    }
}