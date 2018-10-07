package pl.coderslab.popular_words;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        saveWords("https://www.onet.pl/");

        String[] excluded = new String[]{"oraz", "ponieważ", "dla", "ich", "niż", "ale", "się"};
        saveFilteredWords(excluded);
    }

    public static void saveFilteredWords(String[] excluded)
    {
        Path path1 = Paths.get("./popular_words.txt");
        Path path2 = Paths.get("./filtered_popular_words.txt");
        ArrayList<String> out = new ArrayList<>();
        boolean found = false;

        try
        {
            for(String line : Files.readAllLines(path1))
            {
                found = false;
                for(String el : excluded)
                {
                    if(line.equalsIgnoreCase(el))
                    {
                        found = true;
                        break;
                    }
                }
                if(! found)
                {
                    out.add(line);
                }
            }

            Files.deleteIfExists(path2);
            Files.createFile(path2);
            Files.write(path2, out);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void saveWords(String URI)
    {
        Connection connect = Jsoup.connect(URI);

        try
        {
            Document document = connect.get();
            Elements links = document.select("span.title");
            PrintWriter pw = new PrintWriter("./popular_words.txt");

            for(Element elem : links)
            {
                String tag = elem.text();
                StringTokenizer st = new StringTokenizer(tag, " .,\"„”:`'[]()?!-#");

                while(st.hasMoreTokens())
                {
                    String token = st.nextToken();
                    if(token.length() < 3)
                    {
                        continue;
                    }
                    pw.append(token + "\n");
                }
            }
            pw.close(); // save file
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
