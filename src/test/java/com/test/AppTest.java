package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException
     */
    @Test
    public void textFile() throws IOException
    {
        File logFile = new File("C:/Users/benja/Desktop/client.txt");
        if(!logFile.exists())
        {
            System.out.println("Le fichier n'existe pas");
            assert(true);
        }
        else if(logFile.length() == 0) {
            System.out.println("Le ficher est vide");
            assert(true);
        }
        else {
            FileReader fr = new FileReader(logFile);
            BufferedReader br = new BufferedReader(fr);  
            String line;
            int compteur = 0;
            List<String> toTest = new ArrayList<String>();
            while((line = br.readLine()) != null)
            {
                StringBuffer sb = new StringBuffer();    
                sb.append(line);
                String[] temp = sb.toString().split(",");
                
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].length() != 1) {
                        toTest.add(temp[i]);
                    }
                }
                compteur++;
            }
            fr.close();
            if (toTest.size() < (compteur * 4)) {
                System.out.println("le format n'est pas respecter");
                assert(false);
            } else {
                assert(true);
            }
        }
    }
}
