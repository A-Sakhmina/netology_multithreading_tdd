import java.text.DecimalFormat;

public class CreditCalculator {
    private double creditAmount;
    private int loanTermInYears;
    private double loanPercentAYear;
    DecimalFormat dF = new DecimalFormat("#.###");

    public CreditCalculator(double creditAmount, int loanTermInYears, double loanPercentAYear) {
        this.creditAmount = creditAmount;
        this.loanTermInYears = loanTermInYears;
        this.loanPercentAYear = loanPercentAYear;
    }

    //Расчет месячного платежа
    public double calculateMonthAmount() {
        int monthsInYear = 12;
        int digitAfterComma = 3;
        double monthAmount = ((double) calculateTotalLoanAmount()) / (loanTermInYears * monthsInYear);
        monthAmount = (double) ((int) (monthAmount * 1000)) / 1000;
        return monthAmount;
    }

    //Расчет общей суммы к возврату в банк
    public int calculateTotalLoanAmount() {
        double temp = Math.pow((1 + (loanPercentAYear / 100)), loanTermInYears);
        return (int) (creditAmount * temp);
    }

    //Расчет переплаты за весь период
    public int calculateDifference() {
        return (int) (calculateTotalLoanAmount() - creditAmount);
    }
}
