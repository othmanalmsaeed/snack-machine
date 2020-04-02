package snackmachine;

public enum Money {
	QUARTER_JD(25), HALF_JD(50), JD_1(100), JD_5(500), JD_10(1000); 
	private double denomination; 
	private Money(int denomination)
	{ 
		this.denomination = denomination;
		} 
	public double getDenomination()
	{ 
		return denomination; 
		}

}
