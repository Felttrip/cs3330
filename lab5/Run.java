//------------------------------>Cuckoo Clock Simulator<------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 5 -- Cuckoo Clock Simulator                                 !
//  FILENAME:  Run.java                                                             !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    Instanciate an Interface objct and run the menu                                 !
//  METHOD                                                                            !
//    Instanciate an Interface object                                                 !
//                                                                                    !
//  EXTRA CREDIT                                                                      !
//    added error checking in Interface.java and Clock.java for times outside of      !
//    the 12 hour clock and other incorrect inputs                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+


public class Run
{
  public static void main(String[] args)
  {
    //instanciate an interface object
    Interface a = new Interface();
    a.menu();
    return ;
  }
}
