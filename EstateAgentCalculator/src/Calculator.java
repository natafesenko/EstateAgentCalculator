
public class Calculator {
    public static double calculateInsuranceCost(double houseValue, double interestRate, double noOfOccupants) {
        double cost = houseValue * interestRate * noOfOccupants;
        if (cost < 275) {
            System.out.println("Good Value!!!");
        } else {
            System.out.println("There is no price on Peace of Mind");
        }
        return cost;
    }
    
    public static double calculateYearsToPay(double houseValue, double monthlyMortgage) {
        double years = 0;
        while (houseValue > 0) {
            houseValue -= monthlyMortgage * 12;
            years++;
        }
        return years;
    }
    
    public static double calculateLocalPropertyTax(double houseValue) {
        return houseValue / 750;
    }
    
    public static double calculateRentalIncome(double houseValue) {
        return houseValue / 300;
    }
    
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to the Property Math Calculator!");
    }
    
    public static void displayGoodbyeMessage() {
        System.out.println("Thank you for using the Property Math Calculator!");
    }
}
