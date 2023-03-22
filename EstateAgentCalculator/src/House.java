// House.java
import java.util.Scanner;
import java.util.InputMismatchException; 

public class House extends Calculator {
    private double houseValue;
    private double monthlyMortgage;
    private double noOfOccupants;
    
    public House(double houseValue, double monthlyMortgage, double noOfOccupants) {
        this.houseValue = houseValue;
        this.monthlyMortgage = monthlyMortgage;
        this.noOfOccupants = noOfOccupants;
    }
    
    public void setHouseValue(double houseValue) {
        this.houseValue = houseValue;
    }
    
    public void setMonthlyMortgage(double monthlyMortgage) {
        this.monthlyMortgage = monthlyMortgage;
    }
    
    public void setNoOfOccupants(double noOfOccupants) {
    	this.noOfOccupants = noOfOccupants;
    }

    public double getHouseValue() {
        return houseValue;
    }
    
    public double getNoOfOccupants() {
        return noOfOccupants;
    }
    
    public double getMonthlyMortgage() {
        return monthlyMortgage;
    }
    public static void main(String[] args) {
    	Scanner UserInput = new Scanner(System.in);
    	Calculator.displayWelcomeMessage();
        
    	double houseValue = getUserInput(UserInput,"Enter the value of the house: ");
        double monthlyMortgage = getUserInput(UserInput,"Enter the monthly mortgage amount: ");
        double noOfOccupants = getUserInput(UserInput,"Enter the number of occupants: ");
        
        House house = new House(houseValue, monthlyMortgage, noOfOccupants);
        
        double insuranceCost = calculateInsuranceCost(house.getHouseValue(), 0.00035, house.getNoOfOccupants());
        System.out.println("The cost of house insurance is $" + insuranceCost);
        
        double yearsToPay = calculateYearsToPay(house.getHouseValue(), house.getMonthlyMortgage());
        System.out.println("It will take " + yearsToPay + " years to pay off the mortgage on this house.");
        
        double localPropertyTax = calculateLocalPropertyTax(house.getHouseValue());
        System.out.println("The local property tax is $" + localPropertyTax);
        
        double rentalIncome = calculateRentalIncome(house.getHouseValue()); 
        System.out.println("The rental income is $" + rentalIncome);
        Calculator.displayGoodbyeMessage();
    }
    
    public static double getUserInput(Scanner in, String question) {
	    // work with variable height
	    double output;
	    while (true) {
	      try {
	        System.out.println(question);
	        // initial variable height
	        output = in.nextDouble();
	        System.out.println("Thanks");
	        // processing the error
	      } catch (InputMismatchException ex) {
	        System.out.println("Error in your input");
	        // resets this scanner
	        in.reset();
	        in.nextLine();
	        continue;
	      }
	      //check that the input value is not 0
	      if (Double.doubleToRawLongBits(output) <= 0) {
	        System.err.println("You must provide a correct input(double precision float)");
	        continue;
	      }
	      break;
	    }
	    return output;
	 }
}
