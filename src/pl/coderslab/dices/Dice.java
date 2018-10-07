package pl.coderslab.dices;

import pl.coderslab.ScannerService;
import pl.coderslab.game1.Main;

import java.util.StringTokenizer;

public class Dice
{
    private String diceCode;
    private int throwsNumber;
    private int diceSize;
    private int resultMove;

    Dice(String diceCode) throws Exception
    {
        this.diceCode = diceCode.isEmpty() ? "D6" : diceCode.toUpperCase(); // jak puste, to domyslnie 1 rzut normalna kostką, jak nie to kod przekazany od usera (do duzej czcionki w razie W)
        this.resolveCode();
    }

    Dice()
    {
        this.throwsNumber = 1;
        this.diceSize = 6;
        this.resultMove = 0;
        this.diceCode = "D6";
    }

    public int getNextThrow()
    {
        int result = 0;
        int simpleThrow = 0;
        for(int i = 0; i < this.throwsNumber; i++)
        {
            simpleThrow = Main.generateInt(1, this.diceSize); // jeden rzut od 1 do rozmiar kostki i dopisuje do wyniku
            // ScannerService.print(simpleThrow + "+", "blue");
            ScannerService.print(simpleThrow + ((i + 1 == this.throwsNumber) ? ("") : ("+")), "blue");
            result += simpleThrow;
        }
        ScannerService.print(((this.resultMove >= 0) ? (" (+") : (" (")) + this.resultMove + ")", "blue");
        result += this.resultMove;
        return result;
    }

    private void resolveCode() throws Exception
    {
        //        2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
        //        D6 – zwykły rzut kostką sześcienną,
        //        2D3 – rzut dwiema kostkami trójściennymi,
        //        D12-1 – rzut kością D12, od wyniku odejmij 1.
        StringTokenizer st = new StringTokenizer(this.diceCode, "D+-", true);
        String token = "";

        this.diceSize = 6;
        this.throwsNumber = 1;
        this.resultMove = 0;

        int i = 0;
        while(st.hasMoreTokens())
        {
            token = st.nextToken();
            //System.out.println(token);
            if(i == 0 && (token.equals("+") || token.equals("-"))) // jesli mamy tylko + lub -
            {
                if(st.hasMoreTokens())
                {
                    try
                    {
                        this.resultMove = Integer.parseInt(token + st.nextToken());
                    }
                    catch(NumberFormatException ex)
                    {
                        //ScannerService.println("Niepoprawny kod!", "red");
                        throw new Exception("Niepoprawny kod!");
                    }
                    break;
                }
            }


            if(i == 0 && (! token.equals("D"))) // jesli to pierwszy przebieg i pierwszy token to nie jest D
            {
                //i++;
                try
                {
                    this.throwsNumber = Integer.parseInt(token);    // czyli mamy liczbe rzutów
                }
                catch(NumberFormatException ex)
                {
                    //ScannerService.println("Niepoprawny kod.", "red");
                    throw new Exception("Niepoprawny kod!");//== break;
                    //break;
                }
            }
            else if(token.equals("D")) // jak wystąpi D, to jedziemy dalej z tokenizerem
            {
                if(st.hasMoreTokens()) // sprawdzamy czy jest nastepy token po D
                {
                    token = st.nextToken(); // size kostki lub + -
                    try
                    {
                        this.diceSize = Integer.parseInt(token); // jesli uda sie parsowac to jest to size kostki...
                        if(this.diceSize < 1)
                        {
                            throw new Exception("Niepoprawny kod!");// size kostki musi byc >=1
                        }
                    }
                    catch(NumberFormatException ex) // ...jesli nie to jest to znak
                    {
                        checkModifier(st, token);
                    }
                }
            }
            else
            {
                checkModifier(st, token);
            }
            i++;
        }
        //System.out.println("***rzuty: " + this.throwsNumber + "\n***size: " + this.diceSize + "\n***przesuniecie: " + this.resultMove);
        ScannerService.print(this.throwsNumber + " rzut(y) kostką " + this.diceSize + "-ścienną, przesunięcie o " + this.resultMove + "\n", "yellow");
    }

    private void checkModifier(StringTokenizer st, String token) throws Exception
    {
        try
        {
            if(token.equals("+") && st.hasMoreTokens())
            {
                this.resultMove = Integer.parseInt(st.nextToken()); // plusowy move
            }
            else if(token.equals("-") && st.hasMoreTokens())
            {
                this.resultMove = Integer.parseInt("-" + st.nextToken()); // minusowy move
            }
            else
            {
                //ScannerService.println("Niepoprawny kod.", "red");
                throw new Exception("Niepoprawny kod!");
            }
        }
        catch(NumberFormatException ex2)
        {
            // ScannerService.println("Niepoprawny kod.", "red");
            throw new Exception("Niepoprawny kod!");
        }
    }
}