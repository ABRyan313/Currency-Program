package currencyprogram;
import java.util.*;
import java.io.*;


public class Controller {
	
	public double calculate(String amount, Currency from, Currency to) throws Exception{
		
		try {
			
			return calculate(Double.parseDouble(amount), from, to);
			
		}
		
		catch(Exception E) {
			System.out.println("Illegal amount");
		}
		return 0;
		
	}
	
	
	public double calculate(double amount, Currency from, Currency to) throws Exception{
		
		if(from == null || to == null)
			throw new Exception("No currency");
		return amount * from.getRate() / to.getRate();
	}
	
	public ArrayList <String> update(File file){
		ArrayList<String> error = new ArrayList<>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			for( String line = reader.readLine(); line !=null; line = reader.readLine()) {
				
				StringTokenizer tk = new StringTokenizer (line, ";");
				if(tk.countTokens() == 3) {
					try {
						String name = tk.nextToken();
						String code = tk.nextToken();
						double rate = Double.parseDouble(tk.nextToken());
						
					}
				    catch(Exception ex) {
					    error.add(line);
				    }
				}
				
				else error.add(line);
					
			}
		}
		catch(Exception E) {
			error.add(E.getMessage());
		}
		
		return error;
	}

}
