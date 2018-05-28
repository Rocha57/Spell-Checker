package qcs.rocha;

import java.io.*;
import java.util.*;

public class spellchecker {

    BufferedReader br = null;
    FileReader fr = null;

    Hashtable<String,String> dictionary;   // To store all the words of the dictionary
    boolean suggestWord ;           // To indicate whether the word is spelled correctly or not.

    public static void main(String [] args)
    {
        spellchecker checker = new spellchecker();
    }

    public spellchecker()
    {
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        dictionary = new Hashtable<String,String>();
        //System.out.println("******Welcome to the spell checker using Hashtable*****");
        //System.out.println("The spell checker would check every line from the input file and then give suggestions if needed after each line. \n\n");

        try
        {

            //Read and store the words of the dictionary
            BufferedReader dictReader = new BufferedReader(new FileReader("dictionary.txt"));

            while (dictReader.ready())
            {
                String dictInput = dictReader.readLine() ;
                String [] dict = dictInput.split("\\s");

                for(int i = 0; i < dict.length;i++)
                {
                    // key and value are identical
                    dictionary.put(dict[i], dict[i]);
                }
            }
            dictReader.close();

            //READ FROM THE FILES AND WRITE THE OUTPUTS TO ANOTHER FILES

            String fileName, inputFilename, outputfilename, outputWord = "";

            File inputDirectory = new File(System.getProperty("user.dir")+"/test_suite/erros/Semerros/");

            File outputDirectory = new File(System.getProperty("user.dir")+"/outputs/erros/Semerros/");

            for (final File fileEntry : inputDirectory.listFiles()) {
                if (fileEntry.isDirectory()) {
                    System.out.println("FILE DIRECTORY: " + fileEntry.getName());
                } else {
                    System.out.println("FILE NAME: " + fileEntry.getName());
                }
            }


            FilenameFilter textFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            };

            File[] files = inputDirectory.listFiles(textFilter);

            spellingsuggest suggest = new spellingsuggest("wordprobabilityDatabase.txt");

            for (File myFile : files) {
                System.out.println("Começou o caso de teste para: " + myFile.getName());
                Thread.sleep(2000);
                inputFilename = inputDirectory + "/" +  myFile.getName();
                outputfilename = outputDirectory + "/output_" +  myFile.getName();

                // Read and check the input from the text file
                fr = new FileReader(inputFilename);
                br = new BufferedReader(fr);

                String currentLine;



                //START READING BOY
                while ((currentLine = br.readLine()) != null){

                    try {

                            String[] result = currentLine.split("\\s");

                            for (int x=0; x<result.length; x++)
                            {
                                suggestWord = true;

                                //if((result[x].length() == 1 && Character.isLetter(result[x].charAt(0))) || result[x].length() > 1){
                                outputWord = checkWord(result[x]);
                                //}


                                if(suggestWord)
                                {
                                    //System.out.println("Suggestions for "+result[x]+" are:  " + suggest.correct(outputWord)+"\n");
                                    //writer.println(result[x] + " -> " + suggest.correct(outputWord) );
                                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputfilename, true))) {
                                        bw.write(result[x] + " -> " + suggest.correct(outputWord) +"\n");
                                        bw.flush();
                                    }

                                }
                            }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }

                br.close();
                fr.close();


                // Initialising a spelling suggest object

            }
        }catch (IOException e)
        {
            System.out.println("IOException Occured! ");
            e.printStackTrace();
            //System.exit(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String checkWord(String wordToCheck)
    {
        String wordCheck, unpunctWord;
        String word = wordToCheck.toLowerCase();

        // if word is found in dictionary then it is spelt correctly, so return as it is.
        //note: inflections like "es","ing" provided in the dictionary itself.
        if ((wordCheck = (String)dictionary.get(word)) != null)
        {
            suggestWord = false;            // no need to ask for suggestion for a correct word.
            return wordCheck;
        }

        // Removing punctuations at end of word and giving it a shot ("." or "." or "?!")
        int length = word.length();


        //Checking for the beginning of quotes(example: "she )
        if (length > 1 && word.substring(0,1).equals("\""))
        {
            unpunctWord = word.substring(1, length);

            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;            // no need to ask for suggestion for a correct word.
                return wordCheck ;
            }
            else // not found
                return unpunctWord;                  // removing the punctuations and returning
        }

        // Checking if "." or ",",etc.. at the end is the problem(example: book. when book is present in the dictionary).
        if( word.substring(length - 1).equals(".")  || word.substring(length - 1).equals(",") ||  word.substring(length - 1).equals("!")
                ||  word.substring(length - 1).equals(";") || word.substring(length - 1).equals(":"))
        {
            unpunctWord = word.substring(0, length-1);

            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;            // no need to ask for suggestion for a correct word.
                return wordCheck ;
            }
            else
            {
                return unpunctWord;                  // removing the punctuations and returning
            }
        }

        // Checking for "!\"",etc ...  in the problem (example: watch!" when watch is present in the dictionary)
        if (length > 2 && word.substring(length-2).equals(",\"")  || word.substring(length-2).equals(".\"")
                || word.substring(length-2).equals("?\"") || word.substring(length-2).equals("!\"") )
        {
            unpunctWord = word.substring(0, length-2);

            if ((wordCheck = (String)dictionary.get(unpunctWord)) != null)
            {
                suggestWord = false;            // no need to ask for suggestion for a correct word.
                return wordCheck ;
            }
            else // not found
                return unpunctWord;                  // removing the inflections and returning
        }



        // After all these checks too, word could not be corrected, hence it must be misspelt word. return and ask for suggestions
        return word;
    }

}