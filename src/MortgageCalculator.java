import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bu proqram istifadəçidən alınan əsas məbləğ, illik faiz dərəcəsi və kredit müddətinə
 * əsasən aylıq və ümumi ipoteka ödənişlərini hesablayır.
 * <p>
 * İstifadə qaydası:
 * 1. Proqramı işə salın.
 * 2. Əsas məbləği (principal) daxil edin (məsələn, 100000).
 * 3. İllik faiz dərəcəsini daxil edin (məsələn, 5.5).
 * 4. Kredit müddətini illərlə daxil edin (məsələn, 30).
 * 5. Proqram aylıq və ümumi ödəmə məbləğini hesablayıb ekranda göstərəcək.
 */

public class MortgageCalculator {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENT_TO_DECIMAL = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the principal amount: ");
            double principal = sc.nextDouble();
            if (principal <= 0) {
                throw new IllegalArgumentException("Principal amount must be greater than zero!");
            }

            System.out.println("Enter the annual interest rate: ");
            float annualInterestRate = sc.nextFloat();
            if (annualInterestRate <= 0) {
                throw new IllegalArgumentException("Annual interest rate must be greater than zero!");
            }

            System.out.println("Enter the term in years: ");
            int termInYears = sc.nextInt();
            if (termInYears <= 0) {
                throw new IllegalArgumentException("Term in years must be greater than zero!");
            }

            double monthlyPayment = calculateMonthlyPayment(principal, annualInterestRate, termInYears);

            System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment)); // aylıq ödəmə məbləğini valyuta formatında ekrana çıxarırıq.
            System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * termInYears * MONTHS_IN_YEAR)); // Ümumi ödənəcək məbləği tapmaq üçün aylıq ödəmə məbləğini ödəmə sayına vururq.

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculateMonthlyPayment(double principal, float annualInterestRate, int termInYears) {
        float monthlyInterestRate = (annualInterestRate / PERCENT_TO_DECIMAL) / MONTHS_IN_YEAR; //İllik faiz dərəcəsini aylıq faiz dərəcəsinə çevirmək üçün onu 12-yə bölürük.
        int numberOfPayments = termInYears * MONTHS_IN_YEAR; //Ümumi ödəmə sayını tapmaq üçün kredit müddətini 12 ayla vururuq.
        double monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1); //Bu düstur aylıq ödəmə məbləğini tapmaq üçündür.
        return monthlyPayment;
    }
}