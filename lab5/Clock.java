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
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    Libraries                                                                       !
//    External files                                                                  !
//                                                                                    !
//  CONSTRUCTORS                                                                      !
//  METHODS                                                                           !
//                                                                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+

public class Clock
{
  //class level variables
  private int time;
  private int numCuckoos;

  //Counstructor
  public Clock()
  {
    time = 0;
    numCuckoos = 0;
    
  }

  //Starts clock at start hour runs for one hour
  void run(int start)
  {
    
    time = start*100;
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
      }
      
      if (time==1300)
      {
        time=100;
      }

      
    }
    
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
