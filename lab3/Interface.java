//------------------------------>Interface  Program<----------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 3 -- Menu Interface                                         !
//  FILENAME:  Interface.java                                                         !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//  The purpose of file is to set up an interface for the Stats.java objects with a   !
//  menu driven interface.                                                            ! 
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    External file   Stats.java  Refer to Stats.java dcumentation for included       !
//                                functions.                                          !
//                                                                                    !
//  CONSTRUCTORS                                                                      !
//    Interface(int size) -- creates a stats object of size 'size'                    !
//    Interface() --creates a stats object of size 10                                 !
//  METHODS                                                                           !
//    menu -- controlls the menu driven interface.  Will call readChar and printMenu  !
//            methods and call various methods of Stats object depending on user      !
//            input                                                                   !
//    readChar -- collects the user input as a string and parses it to return valid   !
//                characters                                                          !
//    printMenu -- prints the list of options the user can use                        !
//                                                                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+
import java.io.*;

public class Interface
{
  //class level variables
  BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
  int arraySize = 0;
  char input ='a';
  String numInput = null;
  boolean flag = false, pass=false;
  double[] array = null;
  Stats a = null;

  //Interface constructor
  public Interface(int size)
  {
    a = new Stats(size); //instanciate a stats object
  }
  
  //Interface constructor for when no size is given
  public Interface()
  {
    this(10); //stats object of size 10
  }

  //menu method
  public void menu()
  {
    printMenu(); //first menu print
    while(!flag)//flag is set true by q and Q allows progam to exit
    {
      System.out.printf("\n=> "); //print input arrow
      input = readChar();//collect the input
      input = Character.toUpperCase(input);//put charater in upper case
      switch(input)//check input
      {
        case 'N': pass=false;  //case for adding number to the array
                  while(!pass)
	  	  {
                   try//collect a number to put in the array
  		   {
                      System.out.printf("Number: Enter a Number =>  ");
                      numInput = br.readLine();
                      if(a.loadNums(Double.parseDouble(numInput)))//will return false if array is full
		      {
                        System.out.format("%s entered into the array\nThere are %d slots remaining in the data array",numInput,a.getRemaining());
                      }
                      else
                      {
                        System.out.println("Array is full, please restart to create a fresh array");
                      }
                      pass=true;//no errors thrown exit while loop
		    }
		    catch(NumberFormatException x)//catch a number format exception
		    {
		      System.out.println("Number Format error, expecting value of type double, please try again.");
		    }
                    catch (IOException ioe) //catch an IO exception error
                    {
                      System.out.println("IO error trying to read number. Exiting now.");
                      System.exit(1);
                    }
		  }
                  break;
        case 'P': a.printNums();  //case to print the numbers in the array
                  break;            
        case 'S': a.calcSum();    //case to calculate the sum
                  System.out.format("Sum: %f",a.getSum());
                  break;
        case 'A': a.calcAvg();    //case to calculate the average
                  System.out.format("Average: %f",a.getAvg());
                  break;
        case 'L': a.calcMin();    //case to calculate the min value
                  System.out.format("Minimum: %f",a.getMin());
                  break;
        case 'H': a.calcMax();    //case to calculate the max value
                  System.out.format("Maximum: %f",a.getMax());
                  break;
        case 'M': a.calcMed();    //case to calcualte the median
                  System.out.format("Median: %f",a.getMed());
                  break;
        case 'I': a.mergeSort();  //case to sort in increading order
                  System.out.println("Sort increasing order");
                  a.printNums();
                  break;
        case 'D': a.mergeSort(-1);//case to sort in decreaing order, flag is used
                  System.out.println("Sort decreasing order");
                  a.printNums();
                  break;
        case '?': printMenu();    //case to reprint menu
                  break;            
        case 'Q': flag=true;      //case to quit
                  System.exit(1);
                  break;
        default:  System.out.println("Command not found\nEnter ? for a list of commands"); //default command not found
                  break;
      }
    }
  }

  //character collecting and parsing function
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

  //menu printing function
  private void printMenu()
  {
    //premade strings for ease of formating
    String nText = "Add a number to the data array";
    String pText = "Display all numbers on a line";
    String sText = "Calculate and display the sum of the numbers";
    String aText = "Calculate and display the average of the numbers";
    String lText = "Calculate and display the lowest (min) of the numbers";
    String hText = "Calculate and display the highest (max) of the numbers";
    String mText = "Calculate and display the median of the numbers";
    String iText = "Sort the numbers in increasing order";
    String dText = "Sort the numbers in decreasing order";
    String helpText = "Display this Menu";
    String qText = "Exit the program";
    //formated menu
    System.out.format("Comands Available:\n%-15s %s","  (N)umber",nText);
    System.out.format("\n%-15s %s","  (P)rint",pText);
    System.out.format("\n%-15s %s","  (S)um",sText);
    System.out.format("\n%-15s %s","  (A)verage",aText);
    System.out.format("\n%-15s %s","  (L)ow",lText);
    System.out.format("\n%-15s %s","  (H)igh",hText);
    System.out.format("\n%-15s %s","  (M)edian",mText);
    System.out.format("\n%-15s %s","  (I)ncreasing",iText);
    System.out.format("\n%-15s %s","  (D)ecreasing",dText);
    System.out.format("\n%-15s %s","  (?) Help",helpText);
    System.out.format("\n%-15s %s","  (Q)uit",qText);

  }
}

