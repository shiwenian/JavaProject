import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*; //Allows the use of TimeUnit.MILLISECONDS.sleep(500); //Time buffer to make program flow smoother.
import com.google.gson.Gson; //Google JSON Library for file storage

public class Main {

    static ClimateInformation currentData = new ClimateInformation();
    static int inputSelectionValue = 0;
    static Boolean validOption = true;
    static Boolean isAdmin = false;
    static DataManager dataManager = new DataManager();

    public static void main(String[] args) throws InterruptedException {

        Boolean validOption = true;

        Display display = new Display();
        MenuHandling menu = new MenuHandling();
        Scanner scanner = new Scanner(System.in);


        do {
            validOption = true;
            display.StartingMenu();

            try {
                // do all processing here
                inputSelectionValue = scanner.nextInt();

                if (inputSelectionValue < 1 || inputSelectionValue > 2) {
                    System.out.println("Invalid option selected, please try again.");
                    TimeUnit.MILLISECONDS.sleep(500);
                    validOption = false;
                    scanner.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid option selected, please try again.");
                TimeUnit.MILLISECONDS.sleep(500);
                validOption = false;
                scanner.nextLine();
            }

        } while (!validOption);

        switch (inputSelectionValue) {
            case 1:
                scanner.nextLine();
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
                        main(args);
                        break;
                    } else {
                        TimeUnit.MILLISECONDS.sleep(500); // This feature must be used along with "throws InterruptedException".

                        try {

                            System.out.println("Enter password: \n");

                            inputSelectionValue = scanner.nextInt();

                            success = menu.ValidateLogin(inputSelectionValue, username);
                            if (success)
                                isAdmin = true;
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

        // Process Admin or User Menu
        if (isAdmin) {
            display.AdminMenu();
        } 
        else 
        {
            inputSelectionValue = 0;
            UtilitiesForSystem.ClearScreen();
            do {
                validOption = true;
                display.UserMenu();

                try {
                    // do all processing here
                    inputSelectionValue = scanner.nextInt();

                    if (inputSelectionValue < 1 || inputSelectionValue > 3) {
                        System.out.println("Invalid option selected, please try again.");
                        TimeUnit.MILLISECONDS.sleep(500);
                        validOption = false;
                        scanner.nextLine();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid option selected, please try again.");
                    TimeUnit.MILLISECONDS.sleep(500);
                    validOption = false;
                    scanner.nextLine();
                }

            } while (!validOption);

            
        }

        scanner.close();

         //press 1 - Select Malaysia
        //string inputStr = scanner
        //display.DisplayClimateInformation(dataManager.GetCountryInfo(inputStr));
    }

   

}
