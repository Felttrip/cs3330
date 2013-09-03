//------------------------->HelloTest Program<------------------------------+
//                                                                          !
//  NAME:      Nathaniel Thompson                                           !
//  CLASS:     CMP_SC 3330 - Object Oriented Programing                     !
//  PROFESSOR: Dean Zeller (Lab A - 8:00, TA )                              !
//  TERM:      Fall, 2013                                                   !
//  PROJECT:   Assignment 1 -- Hello World                                  !
//  FILENAME:  HelloTest.java                                               !
//                                                                          !
//  OVERALL PURPOSE                                                         !
//  The purpose of file is to test the Hello.java file by calling it        !
//  appropriatly                                                            !
//                                                                          !
//  LIBRARIES AND EXTERNAL FILES                                            !
//    External file   Hello.java                                            !
//    Functions:        sayHello()                                          !
//                                                                          !
//  METHOD                                                                  !
//    Step 1 - Initialize object and variables                              !
//    Step 2 - run sayHello function                                        !
//                                                                          !
//                                                                          !
//  CREDITS                                                                 !
//    All code written by Nathaniel Thompson.                               !
//                                                                          !
//--------------------------------------------------------------------------+

public class HelloTest
{
    public static void main (String[] args)
    {
        //Step 1 initialize objects and variables
        Hello h = new Hello();
        //Step 2 run say hello function
        h.sayHello();
    }
}
