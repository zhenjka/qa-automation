package lv.qaguru.hw.one;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class TaskThree {

    @Test
    public void myThirdHomeTask() {
        String personalId = "201012-20827";
        String birthDate = personalId.substring(0, 6);
        String centuryIndicator = personalId.substring(7, 8);
        int century = 1900;
        int centuryIndicatorInt = Integer.parseInt(centuryIndicator);

        if (centuryIndicatorInt == 2) {
            century = 2000;
        }

        DateTimeFormatter oldFormat = new DateTimeFormatterBuilder()
                .appendPattern("ddMM")
                .appendValueReduced(ChronoField.YEAR, 2, 2, century)
                .toFormatter();
        LocalDate parseBirthDate = LocalDate.parse(birthDate, oldFormat);

        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String formattedBirthDate = parseBirthDate.format(newFormat);

        System.out.println(formattedBirthDate);

    }

}
