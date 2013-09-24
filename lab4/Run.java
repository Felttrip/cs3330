//------------------------------>Interface  Program<----------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 3 -- Menu Interface                                         !
//  FILENAME:  Run.java                                                               !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    The purpose of file is to instanciate the infterface class and                  !
//    run the menu method.                                                            !
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    External file   Stats.java                                                      !
//                    Interface.java                                                  !
//    Libraries       java.io.*                                                       !
//  METHOD                                                                            !
//    Step 1 - Initialize the Interface object                                        !
//    Step 2 - Run the menu method                                                    !
//    Step 3 - Exit the program                                                       !
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
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    
    String fInput = null;
    char input = 'a';
    System.out.println("Welcome to Nate's Statistics Program");
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
      
    if(input=='Y'||input=='y')//using an array
    {
      System.out.println("What is the filename?");
      try
      {
        fInput = br.readLine();
      }
      catch(IOException ioe)
      {
        System.out.println("IO Exception Error, quitting");
        System.exit(1);
      }
      try
      {
        a = new Interface(fInput);
      }
      catch(FileNotFoundException err)
      {
        System.out.println("File not found, quitting now.");
        System.exit(1);
      }
    }

    else if(input=='N'||input=='n')//no array
    {
      System.out.println("You have 10 slots remaining in the array");
      a = new Interface(10);
    }
    else
    {
      System.out.println("error, quitting");
      System.exit(1);
    }
    //step 2
    a.menu();
    //step 3
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
        System.out.println("1 Invalid input please use Y or n");
      }
    }
    while(!Character.isLetter(uInput.charAt(0)));

    return uInput.charAt(0);//return character input

  }

}
