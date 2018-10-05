package pl.coderslab.dices;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dice
{
    private String diceCode;
    private int throwsNumber;
    private int diceSize;
    private int resultMove;

    public static boolean isNumeric(String str)
    {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    Dice(String diceCode)
    {
        this.diceCode = diceCode.isEmpty() ? "D6" : diceCode.toUpperCase(); // jak puste, to domyslnie 1 rzut normalna kostką, jak nie to kod przekazany od usera (do duzej czcionki w razie W)
        this.resolveCode();
    }

    Dice()
    {
        this(""); // wywołuję inny  konstruktor tej klasy (ten ze stringiem w paramatrze)
    }

    public int getNextThrow()
    {
        return 0;
    }

    private void resolveCode()
    {
        //        2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
        //        D6 – zwykły rzut kostką sześcienną,
        //        2D3 – rzut dwiema kostkami trójściennymi,
        //        D12-1 – rzut kością D12, od wyniku odejmij 1.
        ArrayList<String> charList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(this.diceCode, "D", true);

        String token = "";

        while(st.hasMoreTokens())
        {
            token = st.nextToken();
            System.out.println("Token: " + token);

            if(token.equals("D"))
            {
                //todo continue here AND THINK
            }


            if(isNumeric(token)) // jesli ten el to liczba, to wiemy ze to sa rzuty i wiemy ile ich jest
            {
                this.throwsNumber = Integer.parseInt(token);
                System.out.println("this.throwsNumber: " + this.throwsNumber);

            }
        }

/*
        while(st.hasMoreTokens())
        {
            //            System.out.println(st.nextToken());
             token = st.nextToken();
            if(token.matches("\\d"))
            {
                this.throwsNumber = Integer.parseInt(token);

            }
        }*/


        //        for(int i = 0; i < this.diceCode.length(); i++)
        //        {
        //            charList.add(Character.toString(this.diceCode.charAt(i)));
        //        }
        //
        //        for(String el : charList)
        //        {
        //            if()
        //        }


    }
}