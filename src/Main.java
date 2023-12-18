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
        Boolean returnToStartingMenu = false;
        Display display = new Display();
        MenuHandling menu = new MenuHandling();
        Scanner scanner = new Scanner(System.in);

        do
        {
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

            returnToStartingMenu = menu.AdminLoginMenuHandling(inputSelectionValue);

        }while(returnToStartingMenu);
        

        // Process Admin or User Menu
        if (isAdmin) {
            display.AdminMenu();
        } 
        else 
        {
            Boolean backToMenu = false;
            do
            {
                int userMenuSelection = 0;
                UtilitiesForSystem.ClearScreen();
                do {
                    validOption = true;
                    display.UserMenu();

                    try {
                        userMenuSelection = scanner.nextInt();

                        if (inputSelectionValue < 1 || inputSelectionValue > 4) {
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

                switch (userMenuSelection) {
                    case 1: //View Geographical Information
                    {
                        break;
                    }
                    case 2: //View Educational Material
                    {
                        break;
                    }
                    case 3: //SDDG13 Goals/Missions
                    {
                        break;
                    }
                    case 4: //Exit
                    {
                        System.out.println("\nExiting..");
                        TimeUnit.MILLISECONDS.sleep(1000);
                        backToMenu = true;
                        break;
                    }
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }

            } while(!backToMenu);
        }

        scanner.close();
    }

    public static void PopulateData() {
        // ClimateInformation newData = new ClimateInformation();

        currentData.country = "Malaysia";
        currentData.climateType = ClimateInformation.ClimateType.Tropical;
        currentData.disasterType = ClimateInformation.DisasterType.Flood;
    }

    public static void SetClimateType(ClimateInformation data, int value) {
        ClimateInformation.ClimateType climateType = null;

        switch (value) {
            case 1:
                climateType = ClimateInformation.ClimateType.Continental;
                break;
            case 2:
                climateType = ClimateInformation.ClimateType.Tropical;
                break;
            case 3:
                climateType = ClimateInformation.ClimateType.Dry;
                break;

            default:
                break;
        }

        data.climateType = climateType;
    }

    public static void SetDisasterType(ClimateInformation data, ClimateInformation.DisasterType disasterType) {
        data.disasterType = disasterType;
    }

}
