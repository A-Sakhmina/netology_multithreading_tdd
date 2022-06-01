import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CreditCalculatorTest {
    CreditCalculator creditCalculator;

    @BeforeEach
    public void init() {
        System.out.println("test started");
    }

    @BeforeAll
    public static void started() {
        System.out.println("started tests");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    public static Stream<Arguments> sourceTotalAmount() {
        return Stream.of(Arguments.of(10, 4, 10, 14.641),
                Arguments.of(25_000, 5, 12, 44058.5421));

    }

    @ParameterizedTest
    @MethodSource("sourceTotalAmount")
    public void testTotalAmount(int creditAmount, int loanTermInYears, int loanPercentAYear, double expected) {
        //given
        creditCalculator = new CreditCalculator(creditAmount, loanTermInYears, loanPercentAYear);
        //when
        double result = creditCalculator.calculateTotalLoanAmount();
        //then
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceDif() {
        return Stream.of(Arguments.of(10, 4, 10, 4.641),
                Arguments.of(25_000, 5, 12, 19058.5421));

    }

    @ParameterizedTest
    @MethodSource("sourceDif")
    public void testDif(int creditAmount, int loanTermInYears, int loanPercentAYear, double expected) {
        //given
        creditCalculator = new CreditCalculator(creditAmount, loanTermInYears, loanPercentAYear);
        //when
        double result = creditCalculator.calculateDifference();
        //then
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> sourceMonth() {
        return Stream.of(Arguments.of(10, 4, 10, 0.305),
                Arguments.of(25_000, 5, 12, 734.309035));

    }

    @ParameterizedTest
    @MethodSource("sourceMonth")
    public void testMonth(int creditAmount, int loanTermInYears, int loanPercentAYear, double expected) {
        //given
        creditCalculator = new CreditCalculator(creditAmount, loanTermInYears, loanPercentAYear);
        //when
        double result = creditCalculator.calculateMonthAmount();
        //then
        Assertions.assertEquals(expected, result);
    }
}
