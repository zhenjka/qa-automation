import org.junit.jupiter.api.Test;

public class JavaBasics {

    @Test
    public void javaBasicsCheck() {
//        int a = 10;
//        int b = 5;
//        int sumAB = sumDigits(10, 5);

//        sout + Tab > System.out.println()
//        System.out.println("First variable is: " + a + " second variable is: " + b);
//        System.out.println("Sum is: " + sumDigits(10, 5));

//        int e = 100;
//        int f = 33;
//        int sumEF = sumDigits(100, 33);

//        System.out.println("Sum is: " + sumDigits(100, 33));

        sumDigits(10, 5);
        sumDigits(100, 33);

        String c = "10";
        String d = "5";

        System.out.println(c + d);
    }

    private void sumDigits(int a, int b) {
//        int sum = a + b;
        System.out.println("Sum is: " + (a + b));
//        return sum;
    }

}
