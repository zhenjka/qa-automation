package lv.qaguru.hw.one;

import java.text.DecimalFormat;
import org.junit.jupiter.api.Test;

import static java.lang.Math.*;

public class TaskFour {

    double lat1Radians;
    double lon1Radians;
    double lat2Radians;
    double lon2Radians;

    @Test
    void myFourthHomeTask() {
        showDistanceBetweenTwoMapPoints(56.949650, 24.105186, 47.557281,13.646960 );

    }

    private void showDistanceBetweenTwoMapPoints(double lat1, double lon1, double lat2, double lon2) {
        lat1Radians = toRadians(lat1);
        lon1Radians = toRadians(lon1);
        lat2Radians = toRadians(lat2);
        lon2Radians = toRadians(lon2);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        double distance = 6371.01 * acos((sin(lat1) * sin(lat2)) + (cos(lat1) * cos(lat2) * cos(lon1 - lon2)));

        System.out.println("Distance between two points is: " + decimalFormat.format(distance) + " km");
    }
}