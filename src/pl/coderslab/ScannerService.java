package pl.coderslab;

import java.util.Scanner;

public class ScannerService
{
    public static int getInt(String promptMsg, String errorMsg)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(promptMsg); // wiadomość dla użytkownika co należy wpisać
        while (!scan.hasNextInt()) // dopóki nie ma int na wejściu
        {
            System.out.print(errorMsg); // to nie jest int, wypisz błąd
            scan.next(); // wczytaj następną wartość
        }
        return scan.nextInt(); // wkońcu wczytany int, więc go zwracamy
    }

    public static int getInt(String promptMsg)
    {
        return getInt(promptMsg, "Proszę podać liczbę całkowitą: ");
    }

    public static int getInt()
    {
        return getInt("Proszę podać liczbę całkowitą: ");
    }
}
