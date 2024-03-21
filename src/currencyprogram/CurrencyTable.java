package currencyprogram;
import java.util.*;

public class CurrencyTable implements Iterable<Currency> {
	
	private static CurrencyTable instance = null;
	private ArrayList <Currency> table = new ArrayList <>();
	
	private CurrencyTable(){
		
		init();
	
	}
	
	public static CurrencyTable getInstance() {
		
		if(instance == null) {
			synchronized (CurrencyTable.class) {
				if (instance == null)
					instance = new CurrencyTable();
			}
		}
			
		return instance;
	}
	
	public Currency getCurrency(String code) throws Exception{
		
		for(Currency c: table)
			if(c.getCode().equals(code))
				return c;
		throw new Exception("Illegal currency");
		
	}
	
	public Iterator <Currency> iterator(){
		return table.iterator();
	}
	
	public boolean update(Currency currency) {
		for(Currency c: this)
			if(c.getCode().equals(currency.getCode()))
				try {
					c.setName(currency.getName());
					c.setRate(currency.getRate());
				}
		
		        catch(Exception E) {
		        	return false;
		        }
		
		table.add(currency);
		return true;
		
	}
	
	
	private void init() {

		for (String line : rates) {

			StringTokenizer tk = new StringTokenizer(line, ";");
			if (tk.countTokens() == 3) {
				try {
					String name = tk.nextToken();
					String code = tk.nextToken();
					double rate = Double.parseDouble(tk.nextToken());
					table.add(new Currency(code, name, rate));
				} catch (Exception ex) {
					System.out.println(ex.getMessage() + "\n" + line);
				}
			} else
				System.out.println("Error: " + line);
		}
	}
	
	 private static String[] rates =
		 {
		 "Danske kroner;DKK;100.00",
		 "Euro;EUR;746.00",
		 "Amerikanske dollar;USD;674.44",
		 "Britiske pund;GBP;1034.10",
		 "Svenske kroner;SEK;79.31",
		 "Norske kroner;NOK;79.68",
		 "Schweiziske franc;CHF;685.66",
		 "Japanske yen;JPY;5.6065",
		 "Australske dollar;AUD;487.61",
		 "Brasilianske real;BRL;171.98",
		 "Bulgarske lev;BGN;381.43",
		 "Canadiske dollar;CAD;510.19",
		 "Filippinske peso;PHP;14.40",
		 "Hongkong dollar;HKD;87.02",
		 "Indiske rupee;INR;10.38",
		 "Indonesiske rupiah;IDR;0.0494",
		 "Israelske shekel;ILS;174.48",
		 "Kinesiske Yuan renminbi;CNY;106.17",
		 "Kroatiske kuna;HRK;97.87",
		 "Malaysiske ringgit;MYR;157.78",
		 "Mexicanske peso;MXN;40.65",
		 "New Zealandske dollar;NZD;458.77",
		 "Polske zloty;PLN;173.82",
		 "Rumænske lei;RON;168.13",
		 "Russiske rubel;RUB;10.42",
		 "Singapore dollar;SGD;483.72",
		 "Sydafrikanske rand;ZAR;49.08",
		 "Sydkoreanske won;KRW;0.5933",
		 "Thailandske baht;THB;19.00",
		 "Tjekkiske koruna;CZK;27.53",
		 "Tyrkiske lira;TRY;231.78",
		 "Ungarske forint;HUF;2.385"
		 };

}
