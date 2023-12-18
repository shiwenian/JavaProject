import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*; //Allows the use of TimeUnit.MILLISECONDS.sleep(500); //Time buffer to make program flow smoother.
import com.google.gson.Gson; //Google JSON Library for file storage

public class Main {

    static ClimateInformation currentData = new ClimateInformation();
    static int inputSelectionValue = 0;
    static Boolean validOption = true;
    static DataManager dataManager = new DataManager();

    static Display display = new Display();
    static MenuHandling menu = new MenuHandling();
    static Scanner scanner = new Scanner(System.in);

    enum State {
        HOME,
        ADMIN,
        USER,
        EXIT
    }

    public static void main(String[] args) throws InterruptedException {

        Boolean validOption = true;
        State currentState = State.ADMIN;

        while (currentState != State.EXIT) {
            switch (currentState) {
                case HOME:

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

                    if (inputSelectionValue == 1) {

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
                                validOption = false;
                                break;
                            } else {
                                TimeUnit.MILLISECONDS.sleep(500);

                                try {

                                    System.out.println("Enter password: \n");

                                    inputSelectionValue = scanner.nextInt();

                                    success = menu.ValidateLogin(inputSelectionValue, username);
                                    if (success) {
                                        currentState = State.ADMIN;
                                    } else {
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

                    } else if (inputSelectionValue == 2) {
                        currentState = State.USER;
                        scanner.nextLine();
                    }

                    break;

                case ADMIN:
                    do {
                        validOption = true;
                        //System.out.println("Selection "+ inputSelectionValue);
                        display.AdminMenu();

                        try {
                            // do all processing here
                            inputSelectionValue = scanner.nextInt();

                            if (inputSelectionValue < 1 || inputSelectionValue > 6) {
                                System.out.println("Invalid option selected, please try again.\n");
                                TimeUnit.MILLISECONDS.sleep(500);
                                validOption = false;
                                scanner.nextLine();
                            }

                            else if (inputSelectionValue == 6) {
                                currentState = State.HOME;
                            }
                            else
                            {
                                System.out.println("Selection "+ inputSelectionValue);
                                ProcessAdminSelection(inputSelectionValue);
                                //scanner.nextLine();
                            }


                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please try again.\n");
                            TimeUnit.MILLISECONDS.sleep(500);
                            validOption = false;
                            scanner.nextLine();
                        }

                    } while (!validOption);

                    break;

                case USER:
                    do {
                        validOption = true;
                        display.UserMenu();

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
                    break;
                default:
                    break;
            }
        }

        // press 1 - Select Malaysia
        // string inputStr = scanner
        // display.DisplayClimateInformation(dataManager.GetCountryInfo(inputStr));
    }

    public static void ProcessAdminSelection(int value) throws InterruptedException {
        switch (value) {
            case 1:
                // View all countries geo info

                if (dataManager.climateInformationList != null) {

                    dataManager.ReadFromJSON();

                    for (ClimateInformation countryData : dataManager.climateInformationList) {
                        display.DisplayClimateInformation(countryData);
                    }

                    scanner.nextLine();
                } else {
                    System.out.println("No countries data found. Populate the database first.");
                }

                System.out.println("Press ENTER to continue");
                 scanner.nextLine();
                break;
            case 2:
                // Edit country info
                
                System.out.println("Displaying Country List");
                validOption = true;
                display.AdminMenuCountryList();

                try {
                     inputSelectionValue = scanner.nextInt();

                     //process 1-7
                } catch (Exception e) {
                    // TODO: handle exception
                }

                
                
                break;
            case 3:
                // filter by risk level
                break;
            case 4:
                // filter by climate type
                break;
            case 5:
                // filter by disaster type
                break;

        }
    }

}
