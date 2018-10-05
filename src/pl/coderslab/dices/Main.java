package pl.coderslab.dices;


import pl.coderslab.ScannerService;

public class Main
{
    public static void main(String[] args)
    {

        while (true)
        {
            String diceCode = ScannerService.getString("Kod kostki: ");

            if (diceCode.trim().equals("quit") || diceCode.trim().equals("exit")) // kończymy zabawe gdy user wpisze quit lub exit
            {
                break; // wyjscie z petli i koniec
            }
            System.out.println(diceCode);
            int result = diceThrow(diceCode);

            System.out.println(result);
        }
    }

    private static int diceThrow(String diceCode)
    {
        //todo continue here

        return 0;
    }
}
