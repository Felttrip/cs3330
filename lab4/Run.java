//------------------------------>Interface  Program<----------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 4 -- File IO                                                !
//  FILENAME:  Run.java                                                               !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    The purpose of file is to instanciate the interface class and                   !
//    run the menu method.                                                            !
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    External file   Stats.java                                                      !
//                    Interface.java                                                  !
//    Libraries       java.io.*                                                       !
//	FUNCTIONS                                                                         !
//	  readChar -- handles reading a character form the user                           !
//  METHOD                                                                            !
//    Step 1 - Initialize variables                                                   !
//    Step 2 - Check for file                                                         !
//    Step 3 - open the menu by running a.menu                                        !
//    Step 4 - Exit The program                                                       !
//  EXTRA CREDIT                                                                      !
//    Preprocessing is preformed on the file if the user wished to load an entire     !
//    array at the begining of the program.                                           !                                                 !
//                                                                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+

import java.io.*;

public class Run
{
  
  public static void main(String[] args)
  {
    //Step 1 Initialize variables
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    String fInput = null;
    char input = 'a';
    int size = 10;
    boolean pass = false;
    System.out.println("Welcome to Nate's Statistics Program");

    //Step 2 check for file
    System.out.println("Would you like to read from a file? <Y/n>");
    Interface a = null; 
    do//find out if reading from a file or not
    {  
      input = readChar();
      if(input!='Y'&&input!='y'&&input!='n'&&input!='N')//error for incorrect letters
      {
        System.out.println("Invalid input please use Y or n");
      }
    }
    while(input!='Y'&&input!='y'&&input!='n'&&input!='N');
      
    if(input=='Y'||input=='y')//using a file
    {
      System.out.println("What is the filename?");
      try//collect filename
      {
        fInput = br.readLine();
      }
      catch(IOException ioe)
      {
        System.out.println("IO Exception Error, quitting");
        System.exit(1);
      }
      try  //create a new Interface object passing the filename
      {
        a = new Interface(fInput);
      }
      catch(FileNotFoundException err) //if file isnopt found, quit
      {
        System.out.println("File not found, quitting now.");
        System.exit(1);
      }
    }

    else if(input=='N'||input=='n')//no array
    {
      System.out.println("How big would you like the array to be?"); //collect size of array
      while(!pass || size<1) //wait for pass condition and correwct array size
      {
        try
        {
          fInput=br.readLine();
          if(fInput.equals("")) //user just hits enter
          {
            pass=true;
          }
          else if(size<=0) //user puts in wrong array size 
          {
            System.out.println("Please use an array size > 0");
          }
          else  //everything else is good parse size
          {
            size = Integer.parseInt(fInput);
          }
          pass=true;
        }
        catch(IOException err)
        {
          System.out.println("Input Output Error, exiting now");
          System.exit(1);
        }
        catch(NumberFormatException Nerr)
        {
          System.out.println("Error, expecting type int, please enter an integer.");
        }
      }

      System.out.format("You have %d slots remaining in the array",size); //let user know how large array is
      a = new Interface(size); //create a new Interface using size, size default == 10
    }
    else //if for some reason program reaches this else, a condition was not covered and we should quit
    {
      System.out.println("error, quitting");
      System.exit(1);
    }

    //Step 3 open the menu and begin bulk of program
    a.menu();
    
    //Step 4 exit when done
    System.exit(0);
  }

  //charater reading function
  private static char readChar()
  {
    BufferedReader cbr = new BufferedReader (new InputStreamReader(System.in));
    String uInput = null;//user input
    do//do while loop to wait for a charater
    {
      try//collect user input
      {
        uInput = cbr.readLine();
      }
      catch(IOException ioe)//catch IOE
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      if(!Character.isLetter(uInput.charAt(0)))//check for charater
      {
        System.out.println(" Invalid input please use Y or n");
      }
    }
    while(!Character.isLetter(uInput.charAt(0)));

    return uInput.charAt(0);//return character input

  }

}
