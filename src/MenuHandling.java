import java.util.InputMismatchException;
import java.util.concurrent.*;
import java.util.Scanner;

public class MenuHandling {
  Scanner scanner = new Scanner(System.in);

  public Boolean AdminLoginMenuHandling(int userChoice) throws InterruptedException
  {
    Boolean validOption = true;
    Boolean isAdmin = true;
    Boolean returnToStartingMenu = false;
    switch (userChoice) {
            case 1:
                do {
                    validOption = true;
                    Boolean success = false;

                    // Admin ID: admin | Admin Password: 12345
                    System.out.println("\nEnter Admin ID or '-999' to exit: \n");
                    String username = scanner.nextLine();

                    if (username.equals("-999")) {
                        System.out.println("\nExiting...");
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("..");
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println(".");
                        TimeUnit.MILLISECONDS.sleep(500);
                        returnToStartingMenu = true;
                        break;
                    } else {
                        TimeUnit.MILLISECONDS.sleep(500); // This feature must be used along with "throws InterruptedException".

                        try {

                            System.out.println("Enter password: \n");

                            userChoice = scanner.nextInt();

                            success = ValidateLogin(userChoice, username);
                            if (success)
                            {
                                isAdmin = true;
                                scanner.nextLine();
                                break;
                            }
                            else
                            {
                                validOption = false;
                                scanner.nextLine();
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid login details, please try again.\n");
                            TimeUnit.MILLISECONDS.sleep(500);
                            validOption = false;
                            scanner.nextLine();
                            success = false;
                        }
                    }

                } while (!validOption);
            break;

            case 2:
                isAdmin = false;
                scanner.nextLine();
                break;
        }
        
        return returnToStartingMenu;
  }

  public Boolean ValidateLogin(int inputValue, String inputString) throws InterruptedException {

    Boolean result = false;

     if(inputString.equals("admin") && inputValue == 12345) {
      System.out.println("Successful Login!");
      TimeUnit.MILLISECONDS.sleep(500);
      result = true;

    } else {
      System.out.println("Invalid ID or password, please try again or exit using '-999'\n");
      TimeUnit.MILLISECONDS.sleep(500);
      result = false;
    }

    return result; // Returns to starting menu if FALSE and continues if TRUE
  }

  
}

