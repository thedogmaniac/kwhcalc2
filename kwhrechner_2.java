package random;

import java.util.Arrays;
import java.util.Scanner;

public class kwhrechner_2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TO-DO
		// Das multipliziert man dann für eine Woche, oder man kann mit einem Menü die
		// Wochenendtage und die Watt aufnahmen erhöhen z.B. 10 x 60min Aufnahmen
		// Das Ergebnis zeigt einem dann wie viel man in der Woche verbraucht hat und
		// wird dann mit dem User-Eingegebenem Strompreis multipliziert
		// Das kann man dann auch für ein Jahr oder ein halbes Jahr oder wie man es
		// möchte ausrechnen lassen

		Scanner sc = new Scanner(System.in);
		System.out.printf("***********************************%n Welcome to my Wattage Calculator!%n");
		System.out.printf(
				" For this first test you can only input 6 different Wattages. %n It's recommended to record these Wattages in a 60min Interval. %n ----------------------------- %n");
		while (true) {
			System.out.printf(" Do you want to calculate with (W)atts or (K)ilowatts? %n");
			String input2;
			input2 = sc.next();
			String choice1 = input2;
			switch (choice1) {
			case "w":
				if (input2.contains("w")) {
					watts();
					break;
				}
			case "k":

				if (input2.contains("k")) {
					kilowatts();
					break;
				}

			}

		}

	}

	public static void watts() {
		@SuppressWarnings("resource")
		double n;
		Scanner sc = new Scanner(System.in);
		System.out.printf("How many Wattages do you want to input: %n");
		n = sc.nextDouble();
		if (n > 6) {
			System.out.printf("Not more than 6 Inputs!%n");
		} else {
			System.out.printf("Input your Wattages: %n");
			double[] wwatts = new double[6];
			Arrays.sort(wwatts);
			for (int i = 0; i < n; i++) {
				wwatts[i] = sc.nextDouble();
			}

			System.out.printf(" ------------- %n");
			System.out.printf("Your Wattages are: %n");
			System.out.println("First Wattage: " + wwatts[0]);
			System.out.println("Second Wattage: " + wwatts[1]);
			System.out.println("Third Wattage: " + wwatts[2]);
			System.out.println("Fourth Wattage: " + wwatts[3]);
			System.out.println("Fifth Wattage: " + wwatts[4]);
			System.out.println("Sixth Wattage: " + wwatts[5]);
			avgdayw(wwatts);
		}
	}

	public static void kilowatts() {
		@SuppressWarnings("resource")
		double n;
		Scanner sc = new Scanner(System.in);
		System.out.printf("How many Wattages do you want to input: %n");
		n = sc.nextDouble();
		if (n > 6) {
			System.out.printf("Not more than 6 Inputs!%n");
		} else {
			System.out.printf("Input your Wattages: %n");
			double[] kwatts = new double[6];
			Arrays.sort(kwatts);
			for (int i = 0; i < n; i++) {
				kwatts[i] = sc.nextDouble();
			}

			System.out.printf(" ------------- %n");
			System.out.printf("Your Wattages are: %n");
			System.out.println("First Wattage: " + kwatts[0]);
			System.out.println("Second Wattage: " + kwatts[1]);
			System.out.println("Third Wattage: " + kwatts[2]);
			System.out.println("Fourth Wattage: " + kwatts[3]);
			System.out.println("Fifth Wattage: " + kwatts[4]);
			System.out.println("Sixth Wattage: " + kwatts[5]);
			avgdayk(kwatts);

		}

	}

	public static void avgdayw(double[] wwatts) { // Method to calculate AVG
													// Watts p. Day
		double total = 0;
		for (int i = 0; i < wwatts.length; i++) {
			total = total + wwatts[i];
		}

		double avgwattsw = total / wwatts.length;
		System.out.printf("Your average Watts p. Day are: %.2f%n", avgwattsw);
	}

	public static void avgdayk(double[] kwatts) { // Method to calculate AVG
		// KWatts p. Day

		double total = 0;
		for (int i = 0; i < kwatts.length; i++) {
			total = total + kwatts[i];
		}

		double avgwattsk = total / kwatts.length;
		System.out.printf("Your average KWatts p. Day are: %.2f%n", avgwattsk);
		timespank(avgwattsk);
	}

	public static void timespank(double avgwattsk) {// Method to calculate kWatt Power-consumption over User-selected
													// timespan
		System.out.printf("You can now tell me for what Time-Span you'd like to calculate: %n");
		while (true) {
			System.out.printf("Would you like to calculate (D)ays, (W)eeks, (M)onths or (Y)ears? %n");
			Scanner sc = new Scanner(System.in);
			String input3 = sc.nextLine();
			String choice2 = input3;
			switch (choice2) { // choice for time-span
			case "d":
				if (input3.contains("d")) {
					System.out.printf("How many Days would you like to calculate for? %n");
					int input4 = sc.nextInt();
					System.out.printf("Your Days: %d%n", input4);
					double totaldays = (avgwattsk * input4); // Calc. of avg power-cons. over input day-span
					System.out.printf("These are your avg Kwatts: %.2f%n", totaldays);

				}
			case "w":
				if (input3.contains("w")) {
					System.out.printf("How many Weeks would you like to calculate for? %n");
					int input4 = sc.nextInt();
					System.out.printf("Your Weeks: %d%n", input4);
					double totalweeks = (input4 * 7); // Calc. to make days into weeks
					double totalweeksk = (totalweeks * avgwattsk); // Calc. of avg power-cons. over input week-span
					System.out.printf("These are your avg Kwatts: %.2f%n", totalweeksk);

				}

			case "m":
				if (input3.contains("m")) {
					System.out.printf("How many Months would you like to calculate for? %n");
					int input4 = sc.nextInt();
					System.out.printf("Your Months: %d%n", input4);
					double totalmonths = (input4 * 30); // Calc. to make days into months (avg. of 30 Days)
					double totalmonthsk = (totalmonths * avgwattsk); // Calc. of avg power-cons. over input months-span
					System.out.printf("These are your avg Kwatts: %.2f%n", totalmonthsk);
				}
				break;
			}

		}
	}
}

//String input;
//input = sc.next();
//int i = 1;
//while (i <= 3) {
//	i++;
//	System.out.printf(" What do you want to do next? *Return* or *Keep Going*?%n");
//}
//String choice = input;
//switch (choice) {
//case "keep going":
//	if (input.equalsIgnoreCase("keep going")) {
//		System.out.printf(" You can now use your previous Watts to keep calculating. %n");
//		break;
//	}

//case "return":
// if (input.equalsIgnoreCase("return")) {
// System.out.printf(" You stopped the Program. %n");
// return;
// }