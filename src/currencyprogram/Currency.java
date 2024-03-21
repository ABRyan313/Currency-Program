package currencyprogram;

public class Currency {
	
	private String code;
	private String name;
	private double rate;
	
	public Currency(String code, String name) throws Exception {
		this(code, name, 0);
	}
	
	public Currency(String code, String name, double rate ) throws Exception{
		if(!valueOk(code, name, rate)) throw new Exception ("Illegal currency");
		this.code = code;
		this.name = name;
		this.rate = rate;
	}

	public String getCode() {
		return code;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception{
		if (name == null || name.length() == 0)
			throw new Exception ("Illegal name");
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) throws Exception{
		if(rate < 0 ) throw new Exception ("Illegal currency rate");
		this.rate = rate;
	}
	
	
	public static boolean valueOk(String code, String name, double rate) {
		return code != null && code.length() == 3 && name != null && name.length() > 0 && rate >= 0 ;
	}
	


}
