public class CreditCalculator {
    private int creditAmount;
    private int loanTermInYears;
    private int loanPercentAYear;

    public CreditCalculator(int creditAmount, int loanTermInYears, int loanPercentAYear) {
        this.creditAmount = creditAmount;
        this.loanTermInYears = loanTermInYears;
        this.loanPercentAYear = loanPercentAYear;
    }

    //Расчет месячного платежа
    public double calculateMonthAmount() {
        return 0;
    }

    //Расчет общей суммы к возврату в банк
    public double calculateTotalLoanAmount() {
        return 0;
    }

    //Расчет переплаты за весь период
    public double calculateDifference() {
        return 0;
    }
}
