package currencyprogram;
import java.util.*;

public class CurrencyProgram {

	public static void main(String[] args) {
		
		CurrencyTable ab = CurrencyTable.getInstance();
		System.out.println("Current Currencies");
		for(Currency c : ab) {
			
			System.out.println(c.getCode() + ";" +  c.getName()+ ";" + c.getRate());
			
		}
		System.out.println();
		
		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.println("Enter the currency code you want to convert to");
				String toCode = sc.nextLine();
				
				System.out.println("Enter the currency code you want to convert");
				String fromCode = sc.nextLine();
				
				System.out.println("Enter the amount you want to convert");
				double amount = Double.parseDouble(sc.nextLine());
				
				
				Currency toCurrency = ab.getCurrency(toCode);
				Currency fromCurrency = ab.getCurrency(fromCode);
				
				double converted_amount = controller.calculate(amount, fromCurrency, toCurrency);
				System.out.println(amount + " " + " " + "[" + fromCode + "]" + "=" + converted_amount + " " + "["+ toCode + "]");
				
			}
			catch(Exception E) {
				System.out.println("Error" + E.getMessage());
			}
			
			System.out.println("Do you want to continue? (yes/no)");
			String choice = sc.nextLine().toLowerCase();
			if (!choice.equals("yes")) {
				System.out.println("Program terminated");
			    break;
			}
		}
		sc.close();
	}

}
