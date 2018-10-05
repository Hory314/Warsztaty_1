package pl.coderslab.game1;

import pl.coderslab.ScannerService;

import java.util.Random;

public class Main
{
    public static int generateInt(int from, int to)
    {
        Random generator = new Random();
        return generator.nextInt(to - from + 1) + from; // losujemy liczbe // nextInt(ileLiczbChceWylosowac) + od ilu włącznie
    }

    public static void main(String[] args)
    {

        int start = 1000, stop = 10000, tries = 0;

        int generatedNumber = generateInt(start, stop);
        while (true)
        {
            int userInputNumber = ScannerService.getInt("Zgadnij liczbę (od " + start + " do " + stop + "): ", "Proszę podać liczbę całkowitą: "); // pobieramy liczbe od usera
            tries++;
            if (generatedNumber < userInputNumber)
            {
                System.out.println("Za dużo");
            } else if (generatedNumber > userInputNumber)
            {
                System.out.println("Za mało");
            } else
            {
                System.out.println("Zgadłeś za " + tries + " razem!");
                break;
            }
        }
    }
}
