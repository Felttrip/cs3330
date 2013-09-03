//------------------------->Stats Class<------------------------------------+
//                                                                          !
//  NAME:      Nathaniel Thompson                                           !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                     !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA Michael Bruch)                 !
//  TERM:      Fall, 2013                                                   !
//  PROJECT:   Assignment 1 -- Hello World                                  !
//  FILENAME:  Hello.java                                                   !
//                                                                          !
//  OVERALL PURPOSE                                                         !
//  The purpose of this object is to calculate the sum, average, min,       !
//  and max of a set of numbers.                                            !
//                                                                          !
//  LIBRARIES AND EXTERNAL FUNCTIONS                                        !
//    None                                                                  !
//                                                                          !
//  CONSTRUCTORS                                                            !
//    Stats(int size) -- Makes a double array of size "size"                !
//    Stats() -- Makes a double array of size 10                            !
//  METHODS                                                                 !
//    loadNums -- inserts the values given into the array                   !
//    printNums -- prints the values on the array                           !
//    getSum -- returns the sum of the elemnts of the array                 !
//    getAvg -- returns the avg of the elements of the array                !
//    calcSum -- calculates the sum of the elements of the array            !
//    calcAvg -- calculates the average of the elements of the array        !
//    calcMin -- calculates the smallest element in the array               !
//    calcMax -- calculates the largest element in the array                !
//                                                                          !
//                                                                          !
//  CREDITS                                                                 !
//    All code written by Nathaniel Thompson.                               !
//                                                                          !
//--------------------------------------------------------------------------+

public class Stats
{
  //variables accesable by all methods
  private double data[], sum, avg, min, max;
  private int arraySize, i;
  public String tab; //experimenting with public variables
  
  //Stats constructor
  public Stats(int size)
  {
    arraySize=size;
    data=new double[arraySize];
    sum=0.0;
    avg=0.0;
    tab="     ";
  }
  
  //Stats default constructor
  public Stats()
  {
    this(1);
  }

  //loadNums method
  public void loadNums(double arr[])
  {
    for(i=0; i<arraySize; i++) //for loop to fill the data array
    {
      data[i]=arr[i];
    }
  }
  
  //printNums method
  public void printNums()
  {
    System.out.printf(tab + "Input: ");
    for(i=0; i<arraySize; i++)
    {
      if(i==arraySize-1)
        System.out.println( data[i] );
      else
        System.out.printf(data[i] + ", ");
    }
  }

  //getSum and getAvg methods
  public double getSum() {return sum;}
  public double getAvg() {return avg;}
  public double getMin() {return min;}
  public double getMax() {return max;}

  //calcSum method
  public void calcSum()
  {
    sum = 0.0; //flush sum
    for(i=0;i<arraySize;i++)
    {
      sum = data[i]+sum;
    }

  }
  
  //calcAvg method
  public void calcAvg()
  {
    this.calcSum();
    avg = sum / arraySize;
  }

  //calcMin method
  public void calcMin()
  {
    min=data[0];
    for(i=0;i<arraySize;i++)
    {
      if(data[i]<=min)
        min=data[i];
    }
  }
  
  //calcMax method
  public void calcMax()
  {
    max = data[0];
    for(i=0;i<arraySize;i++)
    {
      if(data[i]>=max)
        max=data[i];
    }
  }
}
