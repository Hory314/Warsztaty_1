package pl.coderslab.dices;


import pl.coderslab.ScannerService;

public class Main
{
    public static void main(String[] args)
    {
        Dice dice = new Dice(); // tworzymy pusta kostke (czyli domyslnie stworzy 1 rzut szczecienną)

        while(true)
        {
            try
            {
                String diceCode = ScannerService.getString("Podaj kod kostki: ");


                if(diceCode.trim().equals("quit") || diceCode.trim().equals("exit")) // kończymy zabawe gdy user wpisze quit lub exit
                {
                    break; // wyjscie z petli i koniec
                }
                else if(diceCode.trim().equals("")) // jak jest pusty to powtarzam ostatni rzut(y) utworzonej juz kostki
                {
                    ScannerService.print("\nWyrzucono: " + dice.getNextThrow() + "\n", "blue"); // rzucam tą samą kostką
                }
                else
                {
                    dice = new Dice(diceCode);
                    ScannerService.print("\nWyrzucono: " + dice.getNextThrow() + "\n", "blue");
                }
            }
            catch(Exception e)
            {
                ScannerService.print(e.getMessage() + "\n", "red");
            }
        }
    }
}
