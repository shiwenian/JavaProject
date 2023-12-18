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
                        // System.out.println("Selection "+ inputSelectionValue);
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
                            } else {
                                System.out.println("Selection " + inputSelectionValue);
                                ProcessAdminSelection(inputSelectionValue);
                                // scanner.nextLine();
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

        if (dataManager.climateInformationList != null) {

            dataManager.ReadFromJSON();
        } else {
            System.out.println("No countries data found. Populate the database first.");
        }

        switch (value) {
            case 1:
                // View all countries geo info

                for (ClimateInformation countryData : dataManager.climateInformationList) {
                    display.DisplayClimateInformation(countryData);
                }

                scanner.nextLine();

                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                break;
            case 2:
                // Edit country info

                System.out.println("Displaying Country List");
                display.AdminMenuCountryList();

                try {
                    inputSelectionValue = scanner.nextInt();
                    ClimateInformation.Country country = null;
                    Boolean validSelection = true;

                    switch (inputSelectionValue) {
                        case 1:
                            country = ClimateInformation.Country.Malaysia;
                            break;
                        case 2:
                            country = ClimateInformation.Country.Africa;
                            break;
                        case 3:
                            country = ClimateInformation.Country.China;
                            break;
                        case 4:
                            country = ClimateInformation.Country.Greenland;
                            break;
                        case 5:
                            country = ClimateInformation.Country.Canada;
                            break;
                        case 6:
                            country = ClimateInformation.Country.United_Arab_Emirates;
                            break;
                        case 7:
                            country = ClimateInformation.Country.America;
                            break;

                        default:
                            System.out.println("Invalid option selected, please try again.\n");
                            TimeUnit.MILLISECONDS.sleep(500);
                            scanner.nextLine();
                            validSelection = false;
                            break;
                    }

                    // Show current Country Information
                    if (validSelection) {
                        ClimateInformation dataToDisplay = dataManager.GetCountryInfo(country);
                        if (dataToDisplay != null) {
                            System.out.println("Current Information: \n");
                            display.DisplayClimateInformation(dataToDisplay);
                            display.AdminEditMenu();

                            inputSelectionValue = scanner.nextInt();

                            ProcessAdminEdit(dataToDisplay, inputSelectionValue);

                        } else {
                            System.out.println("Cannot find country in database\n");
                        }
                        scanner.nextLine();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please try again.\n");
                    TimeUnit.MILLISECONDS.sleep(500);
                    scanner.nextLine();
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

    public static void ProcessAdminEdit(ClimateInformation data, int value) throws InterruptedException {
        switch (value) {
            case 1:
                // Edit risk
                display.AdminMenuRiskLevel();
                inputSelectionValue = scanner.nextInt();
                UpdateRiskLevel(data, inputSelectionValue);
                System.out.println("Risk Level Updated\n");
                break;
            case 2:
                // Edit climate
                display.AdminMenuClimateType();
                inputSelectionValue = scanner.nextInt();
                UpdateClimateType(data, inputSelectionValue);
                System.out.println("Climate Type Updated\n");
                break;
            case 3:
                // Edit disaster
                display.AdminMenuDisasterType();
                inputSelectionValue = scanner.nextInt();
                UpdateDisasterType(data, inputSelectionValue);
                System.out.println("Disaster Type Updated\n");
                break;

            default:
                break;
        }
    }

    public static void UpdateRiskLevel(ClimateInformation data, int value) {

        ClimateInformation.Risk risk = null;

        switch (value) {
            case 1:
                // Low
                risk = ClimateInformation.Risk.LOW;
                break;
            case 2:
                // Med
                risk = ClimateInformation.Risk.MEDIUM;
                break;
            case 3:
                // High
                risk = ClimateInformation.Risk.HIGH;
                break;

            default:
                break;
        }

        data.risk = risk;
        dataManager.UpdateData(data);
    }

    public static void UpdateClimateType(ClimateInformation data, int value) {

        ClimateInformation.ClimateType climateType = null;

        switch (value) {
            case 1:
                //Tropical
                climateType = ClimateInformation.ClimateType.Tropical;
                break;
            case 2:
                //Dry
                climateType = ClimateInformation.ClimateType.Dry;
                break;
            case 3:
                //Temperate
                climateType = ClimateInformation.ClimateType.Temperate;
                break;
            case 4:
                //Continental
                climateType = ClimateInformation.ClimateType.Continental;
                break;
            case 5:
                //Polar
                climateType = ClimateInformation.ClimateType.Polar;
                break;

            default:
                break;
        }

        data.climateType = climateType;
        dataManager.UpdateData(data);
    }

    public static void UpdateDisasterType(ClimateInformation data, int value) {

        ClimateInformation.DisasterType disasterType = null;

        switch (value) {
            case 1:
                //Flood
                disasterType = ClimateInformation.DisasterType.Flood;
                break;
            case 2:
                //Drought
                disasterType = ClimateInformation.DisasterType.Drought;
                break;
            case 3:
                //Tornado
               disasterType = ClimateInformation.DisasterType.Tornado;
                break;
            case 4:
                //Wildfire
                disasterType = ClimateInformation.DisasterType.Wildfire;
                break;
            case 5:
                //Earthquake
                disasterType = ClimateInformation.DisasterType.Earthquake;
                break;

                case 6:
                //Hurricane
                disasterType = ClimateInformation.DisasterType.Hurricane;
                break;

                case 7:
                //Cyclone
                disasterType = ClimateInformation.DisasterType.Cyclone;
                break;

            default:
                break;
        }

        data.disasterType = disasterType;
        dataManager.UpdateData(data);
    }

}
