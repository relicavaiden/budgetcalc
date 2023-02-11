import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("What is your budget?");
        Scanner scan = new Scanner(System.in);

        double budget = scan.nextDouble();
        double sum = 0;
        int i = 0;
        ArrayList<Double> proportion = new ArrayList<Double>();
        System.out.println("Enter the amount for each item.");
        System.out.println("The system will stop if the amount exceedes 100%");

        do{
            System.out.print("What are your expenses for the week? " +
                    (i + 1) + ":");
            double value = scan.nextDouble();
            proportion.add(value);
            sum += proportion.get(i);
            i++;
        } while(sum <= 100); {
            scan.close();
            if (sum > 100) {
                double cumulativeSum = 0.0;
                for (int j = 0; j < proportion.size() - 1; j++) {
                    cumulativeSum += proportion.get(j);
                }
                proportion.set(proportion.size() - 1,
                        100 - cumulativeSum);
            }
            for (double value : proportion) {
                double expense = value * budget / 100.0;
                System.out.println("Your " + value + "% equals $" + expense);
            }
        }


    }
}