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
//    mergeSort -- Sorts the array form lowest to highest                   !
//    merge -- used in the merger sort                                      !
//    median -- used to find the median value                               !
//                                                                          !
//  CREDITS                                                                 !
//    All code written by Nathaniel Thompson.                               !
//                                                                          !
//--------------------------------------------------------------------------+

public class Stats
{
  //variables accesable by all methods
  private double data[],temp[], sum, avg, min, max, med;
  private int arraySize, i,arrPos, remain;
  public String tab; //experimenting with public variables
  
  //Stats constructor
  public Stats(int size)
  {
    arraySize=size;
    data=new double[arraySize];
    sum=0.0;
    avg=0.0;
    med=0.0;
    tab="     ";
    remain=0;
    arrPos=0;
  }
  
  //Stats default constructor
  public Stats()
  {
    this(1);
  }

  //loadNums method for array
  public void loadNums(double arr[])
  {
    for(i=0; i<arraySize; i++) //for loop to fill the data array
    {
      data[i]=arr[i];
    }
  }

  //loadNums method for single numbers
  public void loadNums(double num)
  {
     data[arrPos]=num;
     arrPos++;
     remain=arraySize-arrPos;// remining spaces left in the array
    
  }
  
  //printNums method
  public void printNums()
  {
    System.out.printf("Array: ");
    
    if(arrPos==0)
    {
      System.out.printf(  "<data array is empty>");
      return;
    }
    for(i=0; i<arrPos; i++)
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
  public double getMed() {return med;}
  public int getRemaining() {return remain;}

  //calcSum method
  public void calcSum()
  {
    sum = 0.0; //flush sum
    for(i=0;i<arrPos;i++)
    {
      sum = data[i]+sum;
    }

  }
  
  //calcAvg method
  public void calcAvg()
  {
    this.calcSum();
    avg = sum / arrPos;
  }

  //calcMin method
  public void calcMin()
  {
    min=data[0];
    for(i=0;i<arrPos;i++)
    {
      if(data[i]<=min)
        min=data[i];
    }
  }
  
  //calcMax method
  public void calcMax()
  {
    max = data[0];
    for(i=0;i<arrPos;i++)
    {
      if(data[i]>=max)
        max=data[i];
    }
  }

  //mergeSort method
  private void mergeSort(int first, int last)
  {
    //Needed variables for merge sort
    int mid;
    
    if(first<last)
    {
      mid=(first+last)/2;
      mergeSort(first,mid);
      mergeSort(mid+1,last);
      merge(first,mid,last);
      
    }
  }
  //used to call the mergeSort from the Interface class, sorts entire array
  public void mergeSort()
  {
    this.mergeSort(0,arrPos-1);
  }
  
  //merge method for use in mergeSort
  private void merge(int low, int mid, int high)
  {
    temp = new double[arrPos+i];
    for (int i=low; i<=high; i++) 
    {
      temp[i] = data[i];
    }

    int i = low;
    int j = mid + 1;
    int k = low;

    while (i <= mid && j <= high) 
    {
      if (temp[i] <= temp[j]) 
      {
        data[k] = temp[i];
        i++;
      } 
      else 
      {
        data[k] = temp[j];
        j++;
      }
      k++;
    }
   
    while (i <= mid) 
    {
      data[k] = temp[i];
      k++;
      i++;
    }
  }

  //median method
  public void calcMed()
  {
    mergeSort();
    //check for odd or even conditions
    if(arrPos%2!=0)
    {
      med=(data[arrPos/2]);
    }
    else
    {
      med=(data[arrPos/2]+data[(arrPos/2)+1])/2;
    }
  }

}
