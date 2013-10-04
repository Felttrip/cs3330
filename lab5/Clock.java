//------------------------------>Cuckoo Clock Simulator<------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 5 -- Cuckoo Clock Simulator                                 !
//  FILENAME:  Clock.java                                                             !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    Contains all of the methods for the Cuckoo Clock Simulation                     !
//  CONSTRUCTORS                                                                      !
//    Clock() -- sets class level variables to the default values                     !
//  METHODS                                                                           !
//    setTimeS(int x) -- sets timeS                                                   !
//    run() -- runs with start == timeS                                               !
//    run(int start) -- runs with time start                                          !
//    cuckoo() --prints one cuckoo                                                    !
//    cuckoo(int n) -- sounds a cuckoo n times                                        !
//    printTimes() -- prints current time with h:mm format                            !
//    getNumCuckoos() -- return the current number of cuckoos given                   !
//                       durring the simulation                                       !
//    resetsNumCuckoos() -- resets numCuckoos                                         !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+

public class Clock
{
  //class level variables
  private int time;
  private int numCuckoos;
  private int timeS;

  //Counstructor
  public Clock()
  {
    time = 0;
    numCuckoos = 0;
    timeS = 0;
  }
  
  //sets timeS
  public void setTimeS(int x)
  {
    timeS = x;
    System.out.printf("Start Time set to %d:00\n",timeS);
  }
  
  //starts clock ath hour timeS
  public void run()
  {
    this.run(timeS);
  }
  //Starts clock at start hour runs for one hour
  public void run(int start)
  {
    System.out.println("Starting clock...");
    if(start<1||start>12)
    {
      System.out.println("Error, out of range, this is a 12 hour clock");
      return;
    } 
    time = start*100;
    int fin = time+100;
    if (fin==1300)
    {
      fin=100;
    }
    System.out.printf("Start time: %d:%02d\nFinish time: %d:%02d\n",time/100,time%100,fin/100,fin%100);
    for(int i=0;i<=60;i++)
    {
      printTimes();
      if(time%100==0)
      {
        System.out.printf(" -- ");
        cuckoo(time/100);
        
      }

      time++;
      
      if(time%100==60)
      {
        time=(start+1)*100;
        System.out.println("");
      }
      
      if (time==1300)
      {
        time=100;
      }  
    }
    System.out.printf("\nEnding clock...\n");
 
  }

  //sound a single cuckoo
  private void cuckoo()
  {
     System.out.printf("Cuckoo!  "); 
     numCuckoos++;
     return;
  }

  //sound a cuckoo n times 
  private void cuckoo(int n)
  {
    
    for(int i=0;i<n;i++)
    {
      cuckoo();
    }
    System.out.println("");
    return;
  }

  //print current time with h:mm format
  public void printTimes()
  {
    System.out.printf(" %d:%02d ",time/100,time%100);
  }

  //return the current number of cuckoos given durring the simulation
  public int getNumCuckoos()
  {
    return numCuckoos;
  }
  
  //reset numCukoos to zero
  public void resetNumCuckoos()
  {
    numCuckoos=0;
  }
}
