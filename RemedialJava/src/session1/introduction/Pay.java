package session1.introduction;

public class Pay {
	
public static double  printPay(int hours, double pay){
	
	if (hours>40)
	{
		System.out.println(pay);
		return hours*(pay*1.5);
	}else 
	{
		return hours*pay;
	} 
		}

public static String Warning(int hours)
{
	
	return "Warning, a person can not work more than 60 hours a week"+"He/she is currently working"+hours+"hours";
	 
}

public static void main (String[] arguments)
{
	double basepay=9.61;
	int basehours=50;
	
	double pay = 0;
	
	if( basehours<=60){
		pay = printPay(basehours,basepay);	
	}else {
		Warning(basehours);
	}
	
	System.out.println(pay);
	
	
	
}
}
