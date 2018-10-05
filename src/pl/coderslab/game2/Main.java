package pl.coderslab.game2;

import pl.coderslab.ScannerService;

import java.util.Scanner;

public class Main
{

    public static void guess(int start, int stop, int counter)
    {
        int computerTry = Math.floorDiv(start + stop, 2);

        System.out.print("Czy to " + computerTry + "? ");
        String odpowiedz = ScannerService.getString();

        if (odpowiedz.equals("trafiles") || odpowiedz.equals("tak"))
        {
            System.out.println("Wygrałem w " + counter +" ruchach :)");
        } else if (odpowiedz.equals("mniej"))
        {
            guess(start, computerTry, ++counter);
        } else if (odpowiedz.equals("wiecej"))
        {
            guess(computerTry + 1, stop, ++counter);
        } else // jak user przekaze bledne dane na wejsciu (inne niz 'mniej' 'wiecej' lub 'trafiles'
        {
            guess(start, stop, counter); // to ponow dla obecnych danych
        }
    }

    public static void guess(int start, int stop)
    {
        guess(start, stop, 0);
    }

    public static void main(String[] args)
    {
        System.out.println("Pomyśl liczbę od 1 do 1000, a ja ją zgadnę :)"+"\nWpisuj `mniej`, `wiecej` lub `trafiles`");

        guess(1, 10000);

    }
}
