//------------------------------>Interface  Program<----------------------------------+
////                                                                                    !
////  NAME:      Nathaniel Thompson                                                     !
////  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
////  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
////  TERM:      Fall, 2013                                                             !
////  PROJECT:   Assignment 2 -- Statistics                                             !
////  FILENAME:  Interface.java                                                         !
////                                                                                    !
//  OVERALL PURPOSE                                                                   !
//  The purpose of file is to set up an interface for the Stats.java objects          !
//  and test them appropriatly                                                        ! 
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    External file   Stats.java                                                      !
//    Functions:      adNums -- inserts the values given into the array               !
//                    printNums -- prints the values on the array                     !
//                    getSum -- returns the sum of the elemnts of the array           !
//                    getAvg -- returns the avg of the elements of the array          !
//                    calcSum -- calculates the sum of the elements of the array      !
//                    calcAvg -- calculates the average of the elements of the array  !
//                    calcMin -- calculates the smallest element in the array         !
//                    calcMax -- calculates the largest element in the array          !
//                                                                                    !
//  METHOD                                                                            !
//    Step 1 - Initialize objects and variables                                       !
//    Step 2 - use a while loop to collect the size of the array from the user        !
//    Step 3 - Send array size to Stats class and create an array of the correct size !
//    Step 4 - Read input from reader, convert to double values                       !
//    Step 5 - pass array to loadNums, run calcSum, run calcAvgm run calcMin,         !
//             run calcMax                                                            !
//    Step 6 print results                                                            !
//                                                                                    !
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
    this(10);
  }

  //menu method
  public void menu()
  {
    printMenu(); 
    while(!flag)//flag is set true by q and Q allows progam to exit
    {
      System.out.printf("\n=> ");
      input = readChar();//collect the input
      input = Character.toUpperCase(input);//put charater in upper case
    
      switch(input)//check input
      {
        case 'N': pass=false;
                  while(!pass)
	  	  {
                   try//collect a number to put in the array
  		   {
                      System.out.printf("Number: Enter a Number =>  ");
                      numInput = br.readLine();
                      a.loadNums(Double.parseDouble(numInput));
		      pass=true;
                      System.out.format("%s entered into the array\nThere are %d slots remaining in the data array",numInput,a.getRemaining());
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
        case 'P': a.printNums();
                  break; 
        case 'S': a.calcSum();
                  System.out.format("Sum: %f",a.getSum());
                  break;
        case 'A': a.calcAvg();
                  System.out.format("Average: %f",a.getAvg());
                  break;
        case 'L': a.calcMin();
                  System.out.format("Minimum: %f",a.getMin());
                  break;
        case 'H': a.calcMax();
                  System.out.format("Maximum: %f",a.getMax());
                  break;
        case 'M': a.calcMed();
                  System.out.format("Median: %f",a.getMed());
                  break;
        //case 'I'   

        case 'Q': flag=true;
                  System.exit(1);
                  break;
        case 'a': System.out.println("thats an a yes it is");
                  break;
        default:  System.out.println("Command not found\nEnter ? for a list of commands");
                  break;
      }
    }
    System.exit(1);
    System.out.println("what!");
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
      catch(IOException ioe)
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      if(!Character.isLetter(uInput.charAt(0)))//check for charater
      {
        System.out.println("Invalid input, use ? for a list of commands");
      }
    }
    while(!Character.isLetter(uInput.charAt(0)));
    return uInput.charAt(0);//return character input
    
  }

  //menu printing function
  private void printMenu()
  {
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

