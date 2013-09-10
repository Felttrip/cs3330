//------------------------------>Interface  Program<----------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 2 -- Statistics                                             !
//  FILENAME:  Interface.java                                                         !
//                                                                                    !
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
  public static void main(String[] args)
  {
    //Step 1 - Initialize objects and variable
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
    int arraySize1=0, arraySize2=0, arraySize3=0;
    String input = " ";
    boolean pass = false;
    double[] array1=null, array2=null, array3=null;
    Stats a=null,b=null,c=null;

    //Step 2 - use a while loop to collect the size of the array from the user
    while(!pass||arraySize1<=0||arraySize2<=0||arraySize3<=0)
    {
      try
      {
        System.out.printf("Please enter the number of elements to be calculated for the first array: ");
        input = br.readLine();
        arraySize1 = Integer.parseInt(input);
        //Step 3.1 - Create a object with class stats
        a = new Stats(arraySize1);
        array1 = new double[arraySize1];

        System.out.printf("Please enter the number of elements to be calculated for the second array: ");
        input = br.readLine();
        arraySize2 = Integer.parseInt(input);
        //Step 3.2 - Create b object with class stats
        b = new Stats(arraySize2);
        array2 = new double[arraySize2];
  
        System.out.printf("Please enter the number of elements to be calculated for the third array: ");
        input = br.readLine();
        arraySize3 = Integer.parseInt(input);
        //Step 3.3 - Create c object with class stats
        c = new Stats(arraySize3);
        array3 = new double[arraySize3];

        
        if(arraySize1<=0||arraySize2<=0||arraySize3<=0)//If statement to check for correct array size value
        {
          System.out.println("Please use an array size > 0");
        }

        pass = true; //if all parts run correctly go on to next step
      }
      catch (NegativeArraySizeException e) //catch negative array values
      {
        System.out.println("Error, negative array size, please use a value>0");
      }
      catch (NumberFormatException e) //catch if value is not int
      {
        System.out.println("Number Format error, expecting value of type integer, please try again");
      }
      catch (IOException ioe)  //catch an IO exception error
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      catch(OutOfMemoryError er) //catch an out of memory error if the array is too large
      {
        System.out.println("The size of the array is too damn high! (you ran out of memory) Please try again with a smaller value");
      }
    }
    

    //Step 4 - Read input from reader, convert to double values
    //collect for array1
    pass=false; //set pass to false for new while loop
    int place=0; //use place to remember where in the for loop we are if an error throws
    while(!pass)
    {
      try
      {
        for(int i=place; i<arraySize1; i++)
        {
          place = i; //mark current place
          System.out.printf("Enter element number " + (i+1) + " for the first array:");
          input = br.readLine();
          array1[i] = Double.parseDouble(input);
        }
        pass=true; //set true if no errors
      }
      catch (NumberFormatException e) //catch if value is not double
      {
        System.out.println("Number Format error, expecting value of type double, please try again.");
      }
      catch (IOException ioe) //catch an IO exception error
      {
        System.out.println("IO error trying to read number. Exiting now.");
        System.exit(1);
      }
    }

    //collect for array2
    System.out.println(" ");
    pass=false;
    place=0;
    while(!pass)
    {
      try
      {
        for(int i=place; i<arraySize2; i++)
        {
          place = i; //mark current place
          System.out.printf("Enter element number " + (i+1) + " for the second array:");
          input = br.readLine();
          array2[i] = Double.parseDouble(input);
        }
        pass=true; //set true if no errors
      }
      catch (NumberFormatException e) //catch if value is not double
      {
        System.out.println("Number Format error, expecting value of type double, please try again.");
      }
      catch (IOException ioe) //catch an IO exception error
      {
        System.out.println("IO error trying to read number. Exiting now.");
        System.exit(1);
      }
    }
    
    //Collect for array3
    System.out.println(" ");
    pass=false;
    place=0;
    while(!pass)
    {
      try
      {
        for(int i=place; i<arraySize3; i++)
        {
          place = i; //mark current place
          System.out.printf("Enter element number " + (i+1) + " for the third array:");
          input = br.readLine();
          array3[i] = Double.parseDouble(input);
        }
        pass=true; //set true if no errors
      }
      catch (NumberFormatException e) //catch if value is not double
      {
        System.out.println("Number Format error, expecting value of type double, please try again.");
      }
      catch (IOException ioe) //catch an IO exception error
      {
        System.out.println("IO error trying to read number. Exiting now.");
        System.exit(1);
      }
    }


    //Step 5 - pass array1, array2 and array3 to loadNums, run calcSum, run calcAvgm run calcMin, run calcMax
    a.loadNums(array1);
    a.calcSum();
    a.calcAvg();
    a.calcMin();
    a.calcMax();
    
    b.loadNums(array2);
    b.calcSum();
    b.calcAvg();
    b.calcMin();
    b.calcMax();

    c.loadNums(array3);
    c.calcSum();
    c.calcAvg();
    c.calcMin();
    c.calcMax();

    //Step 6 print results for a b and c
    System.out.println("First Array ");
    a.printNums();
    System.out.println(a.tab + "Sum:  " + a.getSum());   //experimenting with public variables in Stats class
    System.out.println(a.tab + "Avg:  " + a.getAvg());   //tab is defined as follows
    System.out.println(a.tab + "Min:  " + a.getMin());   //"public String tab;"
    System.out.println(a.tab + "Max:  " + a.getMax());   //"tab = '     '"

    System.out.println("Second Array ");
    b.printNums();
    System.out.println(b.tab + "Sum:  " + b.getSum());   //experimenting with public variables in Stats class
    System.out.println(b.tab + "Avg:  " + b.getAvg());   //tab is defined as follows
    System.out.println(b.tab + "Min:  " + b.getMin());   //"public String tab;"
    System.out.println(b.tab + "Max:  " + b.getMax());   //"tab = '     '"

    System.out.println("Third Array ");
    c.printNums();
    System.out.println(c.tab + "Sum:  " + c.getSum());   //experimenting with public variables in Stats class
    System.out.println(c.tab + "Avg:  " + c.getAvg());   //tab is defined as follows
    System.out.println(c.tab + "Min:  " + c.getMin());   //"public String tab;"
    System.out.println(c.tab + "Max:  " + c.getMax());   //"tab = '     '"

  }
}
