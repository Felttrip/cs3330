//------------------------------>Cuckoo Clock Simulator<------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 5 -- Cuckoo Clock Simulator                                 !
//  FILENAME:  Interface.java                                                         !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    Generates the interface for the cuckoo clock                                    !
//                                                                                    !
//  EXTERNAL LIBRAIES AND FILES                                                       !
//    libraries                                                                       !
//      java.io.*                                                                     !
//    files                                                                           !
//      Clock.java -- see Clock.java documentation for methods                        !
//                                                                                    !
//  CONSTRUCTORS                                                                      !
//    Interface() -- give the class level variables their default values              !
//                                                                                    !
//  METHODS                                                                           !
//    menu() -- sends the user to the correct method depending on input               !
//    startTime() -- collects the start time from the user                            !
//    printMenu() -- print the menu of avalable commands                              !
//    readChar() -- read the char from the user                                       !
//                                                                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+

//external library
import java.io.*;

//class Interface
public class Interface
{
  //class level variables
  Clock a;
  char input;
  BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
  boolean quit;

  //Interface constructor
  public Interface()
  {
    a = new Clock();
    input = 0;
    quit = false;
        
  }

  //menu Method
  public void menu()
  {
    //print menu and dcollect user input, send user to correct method
    System.out.printf("Cuckoo Clock Sim\n----------------\nBy: Nate Thompson\n\n");
    printMenu();
    while(quit!=true)
    {
      System.out.printf("=> ");
      input=Character.toUpperCase(readChar());
      switch (input)
      {
        case 'S':  startTime();
                   break;
        case 'R':  a.run();
                   break;
        case 'N':  System.out.printf("Number of Cuckoos = %d\n",a.getNumCuckoos());
                   break;
        case 'Z':  System.out.println("Zero out NumCuckoo counter.");
                   a.resetNumCuckoos(); 
                   System.out.printf("Number of Cuckoos = %d\n",a.getNumCuckoos());
                   break;
        case 'Q':  quit=true;
                   break;
        case '?':  printMenu();
                   break;
        default:   System.out.println("Invalid input, use ? for a list of commands");
      }
    }
  }
  
  //collect start time
  private void startTime()
  {
    String input = null;
    int num = 0;
    boolean pass = false;
    do
    {
      System.out.printf("Set start time ==>");
      try
      {
        input = br.readLine();
        num = Integer.parseInt(input);
        a.setTimeS(num);     
        pass = true;
      }
      catch(IOException ioe)
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      catch(NumberFormatException err)
      {
        System.out.println("Expecting type integer, try again");
      }  
   }
   while(pass!=true);
    
  }
  
  //print menu
  private void printMenu()
  {
    System.out.println("(S)tart Time");
    System.out.println("(R)un");
    System.out.println("(N)umber of Cuckoos");
    System.out.println("(Z)ero out NumCuckoos");
    System.out.println("(Q)uit");
    System.out.println("Help (?)");
  }
  
  //character reading function
  private char readChar()
  {

    String uInput = null;//user input
    do//do while loop to wait for a charater
    {
      try//collect user input
      {
        uInput = br.readLine();
      }
      catch(IOException ioe)//catch IOE
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      if(uInput.charAt(0)=='?')//special case for ? symbol
      {
        return uInput.charAt(0);
      }
      if(!Character.isLetter(uInput.charAt(0)))//check for charater
      {
        System.out.println("Invalid input, use ? for a list of commands");
        System.out.printf("=> ");
      }
    }
    while(!Character.isLetter(uInput.charAt(0)));

    return uInput.charAt(0);//return character input

  }
}
