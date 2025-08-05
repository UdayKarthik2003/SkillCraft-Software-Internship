import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temp = scanner.nextDouble();

        System.out.print("Enter input scale (C/F/K): ");
        String from = scanner.next().toUpperCase();

        System.out.print("Enter target scale (C/F/K): ");
        String to = scanner.next().toUpperCase();

        double result = convertTemperature(temp, from, to);
        System.out.printf("Converted Temperature: %.2f %s\n", result, to);
    }

    public static double convertTemperature(double value, String from, String to) {
        double celsius;

        // Convert to Celsius first
        switch (from) {
            case "C": celsius = value; break;
            case "F": celsius = (value - 32) * 5/9; break;
            case "K": celsius = value - 273.15; break;
            default: throw new IllegalArgumentException("Invalid scale: " + from);
        }

        // Convert from Celsius to target
        switch (to) {
            case "C": return celsius;
            case "F": return (celsius * 9/5) + 32;
            case "K": return celsius + 273.15;
            default: throw new IllegalArgumentException("Invalid scale: " + to);
        }
    }
}
