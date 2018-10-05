package pl.coderslab.lotto;


import pl.coderslab.ScannerService;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> zaklad = new ArrayList<>(); // lista typowanych przez usera liczb

        for (int i = 0; i < 6; i++)
        {
            int typowanaLiczba = ScannerService.getInt("Jaką liczbę typujesz w Lotto? (1-49): ");

            if (typowanaLiczba < 1 || typowanaLiczba > 49) // jesli liczba poza zakresem losowania to pobierz na nowo
            {
                System.out.println("Nie ma takiej liczby w losowaniu!");
                i--; // odejmij licznik...
                continue; // i pobierz jeszcze raz liczbe
            }

            if (zaklad.contains(typowanaLiczba)) // jesli juz podalismy taka liczbe
            {
                System.out.println("Już wybrałeś tę liczbę!");
                i--; // odejmij licznik...
                continue; // i pobierz inną liczbę
            }

            zaklad.add(typowanaLiczba); // liczba ok, wiec dodaj ja do listy
        } // koniec wyboru liczb

        Collections.sort(zaklad); // posortuj wybrane liczby

        System.out.print("Wybrane liczby to:    " + showIntegerListElements(zaklad)); // wyswietlam userowe liczby

        ArrayList<Integer> losowanie = getLotto(); // losuje 6 liczb
        Collections.sort(losowanie); // sortuje te liczby
        System.out.println("Wylosowane liczby to: " + showIntegerListElements(losowanie)); // wyswietlam wylosowane liczby
        int trafione = getCountOfSameListElements(zaklad, losowanie);
        System.out.println("Trafiłeś " + trafione + " liczb."); // wyswietlam ile trafione

        switch (trafione)
        {
            case 3:
                System.out.println("Trafiłeś trójkę - wygrana!");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę - wygrana!");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę - wygrana!");
                break;
            case 6:
                System.out.println("Trafiłeś szóstkę - GŁÓWNA WYGRANA!");
                break;
            default:
                System.out.println("Nie wygrałeś.");
                break;
        }
    }

    public static int getCountOfSameListElements(ArrayList<Integer> zaklad, ArrayList<Integer> losowanie)
    {
        int count = 0;
        for (Integer liczbaZzakladu : zaklad)
        {
            for (Integer liczbaZlosowania : losowanie)
            {
                if (liczbaZzakladu == liczbaZlosowania)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public static String showIntegerListElements(ArrayList<Integer> list)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) // wyswietl liczby
        {
            sb.append(list.get(i));
            if (!(i + 1 == list.size())) // jesli nie ostatni el...
            {
                sb.append(", "); // ... to dodaje przecinek
            }
        }

        return sb.append("\n").toString();
    }

    public static ArrayList<Integer> getLotto()
    {
        ArrayList<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < 6; i++)
        {
            int l = pl.coderslab.game1.Main.generateInt(1, 49); // wylosowana liczba od [1 - 49]
            if (lotto.contains(l)) // jak zaklad juz zawiera te liczbe
            {
                // System.err.println("Juz mam te liczbe");
                i--; // zmniejsz licznik i jescze raz pobierz
                continue;
            }
            lotto.add(l);
        }
        return lotto;
    }
}
