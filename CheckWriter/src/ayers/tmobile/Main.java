package ayers.tmobile;

import java.util.*;

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
		"",
		"ten",
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
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		scanner.close();
		String dollars = "";
		String cents = "0";
		String result = "";
		
		if (temp.contains(",")) {
			temp = temp.replaceAll(",","");
		}
		if (temp.contains(".")) {
			dollars = temp.substring(0, temp.indexOf("."));
			cents = temp.substring(temp.indexOf(".") + 1);
		} else {
			dollars = temp;
		}
		if (dollars.charAt(0) == '$') {
			dollars = dollars.substring(1);
		}
		
		result = convertNumToString(dollars);
		
		if (cents.equals("0") || cents.equals("00")) {
			System.out.println(result + " dollars only");
		} else {
			System.out.println(result + " dollars and " + cents + "/100");
		}
	}
	
	static String convertNumToString(String value) {
		int money = 0;
		int hundredThousands = 0;
		int tenThousands = 0;
		int thousands = 0;
		int hundred = 0;
		int tens = 0;
		int ones = 0;
		try {
			money = Integer.parseInt(value.trim());
			if (money == 0) { return "zero"; }
			else if (money > 999999) {	// hundred thousands
				//hundredThousands = money / 
				tenThousands = money / 10000;
				thousands = money % 10000 / 1000; 
				hundred = (money % 1000) / 100;
				tens = (money % 100) / 10;
				ones = money % 10;
				
				return names[tenThousands] + names[thousands] + " thousands " + names[hundred] + " hundred " + tenNames[tens] + " " + names[ones];
			}
			else if (money > 19999) {	// ten thousands
				tenThousands = money / 10000;
				thousands = money % 10000 / 1000; 
				hundred = (money % 1000) / 100;
				tens = (money % 100) / 10;
				ones = money % 10;
				
				return names[tenThousands] + names[thousands] + " thousands " + names[hundred] + " hundred " + tenNames[tens] + " " + names[ones];
			}
			else if (money > 999) {	// thousands
				thousands = money / 1000; 
				hundred = (money % 1000) / 100;
				tens = (money % 100) / 10;
				ones = money % 10;
				
				return names[thousands] + " thousands " + names[hundred] + " hundred " + tenNames[tens] + " " + names[ones];
			}
			else if (money > 99) {
				hundred = money / 100;
				tens = (money % 100) / 10;
				ones = money % 10;
				
				return names[hundred] + " hundred " + tenNames[tens] + " " + names[ones];
			}
			else if (money <= 20){
				return names[money];
			} else {
				tens = money / 10;
				ones = money % 10;

				return tenNames[tens] + " " + names[ones];
			}
		} catch (NumberFormatException e) {
			System.out.println(e.getStackTrace());
		}
		return "";
	}

}
