package pl.coderslab;

import java.util.Scanner;

public class ScannerService
{
    public static void print(String str, String color)
    {
        //            Quick Reference (Color)
        //            +~~~~~~+~~~~~~+~~~~~~~~~~~+
        //            |  fg  |  bg  |  color    |
        //            +~~~~~~+~~~~~~+~~~~~~~~~~~+
        //            |  30  |  40  |  black    |
        //            |  31  |  41  |  red      |
        //            |  32  |  42  |  green    |
        //            |  33  |  43  |  yellow   |
        //            |  34  |  44  |  blue     |
        //            |  35  |  45  |  magenta  |
        //            |  36  |  46  |  cyan     |
        //            |  37  |  47  |  white    |
        //            |  39  |  49  |  default  |
        //            +~~~~~~+~~~~~~+~~~~~~~~~~~+

        switch(color) // zmien kolor na
        {
            case "yellow":
                System.out.print((char) 27 + "[33m");
                break;
            case "red":
                System.out.print((char) 27 + "[31m");
                break;
            case "blue":
                System.out.print((char) 27 + "[34m");
                break;
            default:
                System.out.print("");
                break;
        }
        System.out.print(str); // wyswietl napis w danym kolorze
        System.out.print((char) 27 + "[39m"); // wroc na domyslny kolor
    }

    public static int getInt(String promptMsg, String errorMsg)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(promptMsg); // wiadomość dla użytkownika co należy wpisać
        while(! scan.hasNextInt()) // dopóki nie ma int na wejściu
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

    public static String getString()
    {
        return getString("Proszę wpisać tekst: ");
    }

    public static String getString(String promptMsg)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(promptMsg);
        return scan.nextLine();
    }
}
