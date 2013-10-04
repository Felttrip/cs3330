import java.io.*;
public class Interface
{
  Clock a;
  char input;
  BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
  boolean quit;

  public Interface()
  {
    a = new Clock();
    input = 0;
    quit = false;
    
        
  }

  public void menu()
  {
    printMenu();
    while(quit!=true)
    {
      System.out.printf("=> ");
      input=Character.toUpperCase(readChar());
      switch (input)
      {
        case 'S':  System.out.println("s");
                   break;
        case 'R':  System.out.println("r");
                   break;
        case 'N':  System.out.println("n");
                   break;
        case 'Z':  System.out.println("z");
                   break;
        case 'Q':  System.out.println("q");
                   quit=true;
                   break;
        case '?':  printMenu();
                   break;
        default:   System.out.println("Invalid input, use ? for a list of commands");
      }
    }
  }
  
  private void startTime()
  {
    System.out.printf("Set start time ==>");
    
  }
  
  private void printMenu()
  {
    System.out.println("(S)tart Time");
    System.out.println("(R)un");
    System.out.println("(N)umber of Cuckoos");
    System.out.println("(Z)ero out NumCuckoos");
    System.out.println("(Q)uit");
    System.out.println("Help (?)");
  }
  
  //character reading function
  private char readChar()
  {

    String uInput = null;//user input
    do//do while loop to wait for a charater
    {
      try//collect user input
      {
        uInput = br.readLine();
      }
      catch(IOException ioe)//catch IOE
      {
        System.out.println("IO error trying to read number. Exiting now");
        System.exit(1);
      }
      if(uInput.charAt(0)=='?')//special case for ? symbol
      {
        return uInput.charAt(0);
      }
      if(!Character.isLetter(uInput.charAt(0)))//check for charater
      {
        System.out.println("Invalid input, use ? for a list of commands");
        System.out.printf("=> ");
      }
    }
    while(!Character.isLetter(uInput.charAt(0)));

    return uInput.charAt(0);//return character input

  }
}
