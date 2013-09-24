//------------------------->Stats Class<------------------------------------+
//                                                                          !
//  NAME:      Nathaniel Thompson                                           !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                     !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA Michael Bruch)                 !
//  TERM:      Fall, 2013                                                   !
//  PROJECT:   Assignment 3 -- Menu Interface                               !
//  FILENAME:  Stats.java                                                   !
//                                                                          !
//  OVERALL PURPOSE                                                         !
//  The purpose of this object is to do various statistical calculations    !
//  defined in the methods portion                                          !
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
//    getMin -- returns the minimum value in the array                      !
//    getMax -- returns the maximum value in the array                      !
//    getMed -- returns the median value in the array                       !
//    getRemaining -- returns the number of indices left in the array       !
//    calcSum -- calculates the sum of the elements of the array            !
//    calcAvg -- calculates the average of the elements of the array        !
//    calcMin -- calculates the smallest element in the array               !
//    calcMax -- calculates the largest element in the array                !
//    calcMed -- calculates the median value in the array                   !
//    mergeSort -- Sorts the array form lowest to highest or vice versa if  !
//                 flag is used                                             !
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
  private double data[],temp[], sum, avg, min, max, med, var,std;
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
    var=0.0;
    std=0.0;
    tab="     ";
    remain=10;
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
    remain=0;//set remaining to 0, cannot add numbers to static arrays
    for(i=0; i<arraySize; i++) //for loop to fill the data array
    {
      arrPos++;//set arrPos for use in other functions
      data[i]=arr[i];
    }
  }

  //loadNums method for single numbers
  public boolean loadNums(double num)
  {
     if(remain>0)//make sure array isn't full
     {
       data[arrPos]=num;
       arrPos++;
       remain=arraySize-arrPos;// remining spaces left in the array
       return true;
     }
     else//return false if array is full
     {
       return false;
     }
    
  }
  
  //printNums method
  public void printNums()
  {
    System.out.printf("Array: ");
    
    if(arrPos==0)//check for empty array
    {
      System.out.printf(  "<data array is empty>");
      return;
    }
    for(i=0; i<arrPos; i++)//iterate through array
    {
      if(i==arraySize-1)
        System.out.println( data[i] );
      else
        System.out.printf(data[i] + ",");
    }
  }

  //getSum, getAvg, getMin, getMax, getMed, getRemaining methods
  public double getSum() {return sum;}
  public double getAvg() {return avg;}
  public double getMin() {return min;}
  public double getMax() {return max;}
  public double getMed() {return med;}
  public double getVar() {return var;}
  public double getStd() {return std;}
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
    //Needed variable for merge sort
    int mid;
    
    if(first<last)//break down ito smaller pieces
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
  //used when merge sort is called with a flag for decreasing sort
  public void mergeSort(int flag)
  {
    double swap=0.0; //swap used forreversing order
    mergeSort(0,arrPos-1); //run merge sort
    if(flag==-1) //catch flag
    {
      for(i=0;i<arrPos/2;i++) //reverse order
      {
        swap=data[i];
        data[i]=data[arrPos-i-1];
        data[arrPos-i-1]=swap;
      }
    }
  }
  
  //merge method for use in mergeSort
  private void merge(int low, int mid, int high)
  {
    temp = new double[arrPos+i]; //temp array
    for (int i=low; i<=high; i++) //fill temp with data
    {
      temp[i] = data[i];
    }

    int i = low;
    int j = mid + 1;
    int k = low;

    while (i <= mid && j <= high) //iterate through the indices the array placing the values in the correct order
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
    mergeSort(); //sort first
    //check for odd or even conditions
    if(arrPos%2!=0)
    {
      med=(data[arrPos/2]);
    }
    else
    {
      med=(data[arrPos/2]+data[(arrPos/2)-1])/2;
    }
  }
  
  //varience function
  public void calcVar()
  {
    //calculate needed parts
    calcAvg();
    double x=0;//used for sum of numbers^2
    for(i=0;i<arrPos;i++)
    {
      x+=(data[i]-avg)*(data[i]-avg);
    }
    var=(x/arrPos);
  }

  //standard deviation\
  public void calcStd()
  {
    calcVar();
    std=Math.sqrt(var);
  }

}
