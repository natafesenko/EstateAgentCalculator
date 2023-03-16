// House.java
import java.util.Scanner;
import java.util.InputMismatchException; 

public class House extends Calculator {
    private double houseValue;
    private double monthlyMortgage;
    private int noOfOccupants;
    
    public House(double houseValue, double monthlyMortgage, int noOfOccupants) {
        this.houseValue = houseValue;
        this.monthlyMortgage = monthlyMortgage;
        this.noOfOccupants = noOfOccupants;
    }
    
    public double getHouseValue() {
        return houseValue;
    }
    
    public void setHouseValue(double houseValue) {
        this.houseValue = houseValue;
    }
    
    public double getMonthlyMortgage() {
        return monthlyMortgage;
    }
    
    public void setMonthlyMortgage(double monthlyMortgage) {
        this.monthlyMortgage = monthlyMortgage;
    }
    
    public int getNoOfOccupants() {
        return noOfOccupants;
    }
    
    public void setNoOfOccupants(int noOfOccupants) {
    	this.noOfOccupants = noOfOccupants;
    }

    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in);
        displayWelcomeMessage();
        
        System.out.print("Enter the value of the house: ");
        double houseValue = UserInput.nextDouble();
        
       System.out.print("Enter the monthly mortgage amount: ");
       double monthlyMortgage = UserInput.nextDouble();
        
       System.out.print("Enter the number of occupants: ");
       int noOfOccupants = UserInput.nextInt();
        
        House house = new House(houseValue, monthlyMortgage, noOfOccupants);
        
        double insuranceCost = calculateInsuranceCost(house.getHouseValue(), 0.00035, house.getNoOfOccupants());
        System.out.println("The cost of house insurance is $" + insuranceCost);
        
        int yearsToPay = calculateYearsToPay(house.getHouseValue(), house.getMonthlyMortgage());
        System.out.println("It will take " + yearsToPay + " years to pay off the mortgage on this house.");
        
        double localPropertyTax = calculateLocalPropertyTax(house.getHouseValue());
        System.out.println("The local property tax is $" + localPropertyTax);
        
        double rentalIncome = calculateRentalIncome(house.getHouseValue()); 
    }
    
    public static double UserInput(Scanner in, String question) {
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
