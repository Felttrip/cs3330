//------------------------------>Interface  Program<----------------------------------+
//                                                                                    !
//  NAME:      Nathaniel Thompson                                                     !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                               ! 
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                                        !
//  TERM:      Fall, 2013                                                             !
//  PROJECT:   Assignment 3 -- Menu Interface                                         !
//  FILENAME:  Run.java                                                               !
//                                                                                    !
//  OVERALL PURPOSE                                                                   !
//    The purpose of file is to instanciate the infterface class and                  !
//    run the menu method.                                                            !
//                                                                                    !
//  LIBRARIES AND EXTERNAL FILES                                                      !
//    External file   Stats.java                                                      !
//                    Interface.java                                                  !
//    Libraries       java.io.*                                                       !
//  METHOD                                                                            !
//    Step 1 - Initialize the Interface object                                        !
//    Step 2 - Run the menu method                                                    !
//    Step 3 - Exit the program                                                       !
//                                                                                    !
//  CREDITS                                                                           !
//    All code written by Nathaniel Thompson.                                         !
//                                                                                    !
//------------------------------------------------------------------------------------+

import java.io.*;

public class Run
{
  
  public static void main(String[] args)
  {
    System.out.println("Welcome to Nate's Statistics Program");
    System.out.println("You have 10 slots remaining in the array");
    //step 1
    Interface a = new Interface(10);
    //step 2
    a.menu();
    //step 3
    System.exit(0);
  }
}
