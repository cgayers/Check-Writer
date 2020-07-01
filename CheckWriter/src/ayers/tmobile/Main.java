package ayers.tmobile;

public class Main {

	final private static String[] names = {
		"",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine",
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen",
		"twenty"
	};
	
	final private static String[] tenNames = {
		"twenty",
		"thirty",
		"fourty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety"
	};
	public static void main(String[] args) {
		String[] money = args[0].split(".");
		String dollars = "";
		
		if (money[0].charAt(0) == '$') {
			money[0] = money[0].substring(1);
		}
		
		dollars = convertNumToString(money[0]);
		
		System.out.println(dollars + " and " + money[1] + "/100");
	}
	
	static String convertNumToString(String value) {
		int money = 0;
		
		try {
			money = Integer.parseInt(value);
			
			if (money == 0) { return "zero"; }
			else if (money <= 20){
				return names[money];
			} else {
				int tens = money / 10;
				int ones = money % 10;
				return tenNames[tens] + " " + names[ones];
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return "";
	}

}
