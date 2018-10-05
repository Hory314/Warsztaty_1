package pl.coderslab.dices;


import pl.coderslab.ScannerService;

public class Main
{
    public static void main(String[] args)
    {

        while(true)
        {
            String diceCode = ScannerService.getString("Kod kostki: ");

            if(diceCode.trim().equals("quit") || diceCode.trim().equals("exit")) // kończymy zabawe gdy user wpisze quit lub exit
            {
                break; // wyjscie z petli i koniec
            }
            //System.out.println(diceCode);
            Dice dice = new Dice(diceCode);


            //System.out.println(result);
        }
    }

    /*private static int Dice(String diceCode)
    {
        resolveDiceCode(diceCode)

        //todo continue here

        return 0;
    }*/
}
