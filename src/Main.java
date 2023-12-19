import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*; //Allows the use of TimeUnit.MILLISECONDS.sleep(500); //Time buffer to make program flow smoother.

public class Main {

    static int inputSelectionValue = 0;
    static Boolean validOption = true;
    static DataManager dataManager = new DataManager();

    static Display display = new Display();
    static MenuHandling menu = new MenuHandling();
    static Scanner scanner = new Scanner(System.in);

    static ClimateInformation.Country countrySelected = null;

    enum State {
        HOME,
        ADMIN,
        USER,
        EXIT
    }

    public static void main(String[] args) throws InterruptedException {

        Boolean validOption = true;
        State currentState = State.HOME;

        while (currentState != State.EXIT) {
            switch (currentState) {
                case HOME:

                    do {
                        validOption = true;
                        display.StartingMenu();

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
                    } else if (inputSelectionValue == 3) {
                        System.out.println("\nExitting Program...");
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println("..");
                        TimeUnit.MILLISECONDS.sleep(500);
                        System.out.println(".");
                        TimeUnit.MILLISECONDS.sleep(500);
                        currentState = State.EXIT;
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

                            if (inputSelectionValue < 1 || inputSelectionValue > 7) {
                                System.out.println("\nInvalid option selected, please try again.\n");
                                TimeUnit.MILLISECONDS.sleep(500);
                                validOption = false;
                                scanner.nextLine();
                            }

                            else if (inputSelectionValue == 7) {
                                System.out.println("\nReturning to main menu..");
                                TimeUnit.MILLISECONDS.sleep(500);
                                System.out.println(".\n");
                                TimeUnit.MILLISECONDS.sleep(500);
                                currentState = State.HOME;
                            } else {
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
                    if (dataManager.climateInformationList != null) {

                        dataManager.ReadFromJSON();
                    } else {
                        System.out.println("No countries data found. Populate the database first.");
                    }
                    do {
                        validOption = true;
                        display.UserMenu();

                        try {
                            // do all processing here
                            inputSelectionValue = scanner.nextInt();

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

                        switch (inputSelectionValue) {
                            case 1 /* VIEW GEO INFO */: {
                                for (ClimateInformation countryData : dataManager.climateInformationList) {
                                    display.DisplayClimateInformation(countryData);
                                }

                                scanner.nextLine();

                                System.out.println("\nPress ENTER to continue...\n");
                                scanner.nextLine();
                                break;
                            }
                            case 2 /* VIEW EDUCATIONAL MATERIALS */: {
                                do {
                                    display.UserMenuEduMaterials();

                                    try {
                                        int userInput = scanner.nextInt();

                                        if (userInput == 1) {
                                            display.EduMaterialsClimateType();
                                            System.out.println("\nPress ENTER to continue..");
                                            scanner.nextLine(); // Clears Input Buffer
                                            scanner.nextLine(); // Waits for user to ENTER before continuing
                                            TimeUnit.MILLISECONDS.sleep(500);
                                        }

                                        else if (userInput == 2) {

                                            display.EduMaterialsDisasterType();
                                            System.out.println("\nPress ENTER to continue..");
                                            scanner.nextLine(); // Clears Input Buffer
                                            scanner.nextLine(); // Waits for user to ENTER before continuing
                                            TimeUnit.MILLISECONDS.sleep(500);

                                        }

                                        else if (userInput == 3) {
                                            display.EduMaterialsClimateChange();
                                            System.out.println("\nPress ENTER to continue..");
                                            scanner.nextLine(); // Clears Input Buffer
                                            scanner.nextLine(); // Waits for user to ENTER before continuing
                                            TimeUnit.MILLISECONDS.sleep(500);
                                        } else {
                                            System.out.println("Please enter a valid input.");
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
                            }
                            case 3 /* VIEW SDG13 MISSION/GOALS */: {
                                display.SDG13Goals();
                                System.out.println("\nPress ENTER to continue..");
                                scanner.nextLine(); // Clears Input Buffer
                                scanner.nextLine(); // Waits for user to ENTER before continuing
                                TimeUnit.MILLISECONDS.sleep(500);
                                break;
                            }
                            case 4 /* EXIT */: {
                                System.out.println("\nReturning to main menu..");
                                TimeUnit.MILLISECONDS.sleep(500);
                                System.out.println(".\n");
                                TimeUnit.MILLISECONDS.sleep(500);
                                currentState = State.HOME;
                            }
                            default:
                                break;
                        }

                    } while (!validOption);
                    break;
                default:
                    break;
            }
        }
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

                System.out.println("\nPress ENTER to continue...\n");
                scanner.nextLine();
                break;

            case 2:

                // Add data by country type
                display.AdminMenuAddCountryList();
                inputSelectionValue = scanner.nextInt();
                countrySelected = CountrySelection(inputSelectionValue);

                if (countrySelected != null) {

                    ClimateInformation currentData = new ClimateInformation();
                    ClimateInformation.ClimateType climateType = null;
                    ClimateInformation.DisasterType disasterType = null;
                    ClimateInformation.Risk risk = null;

                    // check if selected country already exist in database?
                    ClimateInformation temp = dataManager.GetCountryInfo(countrySelected);
                    if (temp != null) {
                        // The selected country already exist in database. return;
                        System.out.println("\nThis country already exist in the database.\n");
                        TimeUnit.MILLISECONDS.sleep(500);
                        break;
                    }

                    display.AdminMenuClimateType();

                    int climateSelected = scanner.nextInt();

                    if (climateSelected >= 0 && climateSelected <= ClimateInformation.ClimateType.values().length) {
                        climateType = ClimateInformation.ClimateType.values()[climateSelected - 1];

                    } else {
                        System.out.println("Invalid option for Climate Type\n");
                        break;
                    }

                    display.AdminMenuDisasterType();
                    int disasterSelected = scanner.nextInt();

                    if (disasterSelected >= 0 && disasterSelected <= ClimateInformation.DisasterType.values().length) {
                        disasterType = ClimateInformation.DisasterType.values()[disasterSelected - 1];

                    } else {
                        System.out.println("Invalid option for Disaster Type\n");
                        break;
                    }

                    display.AdminMenuRiskLevel();
                    int riskSelected = scanner.nextInt();

                    if (riskSelected >= 0 && riskSelected <= ClimateInformation.Risk.values().length) {
                        risk = ClimateInformation.Risk.values()[riskSelected - 1];

                    } else {
                        System.out.println("Invalid option for Risk Level\n");
                        break;
                    }

                    // Confirmation before adding
                    System.out.println("==========================================");
                    System.out.println("Add this information to database? Y/N");
                    System.out.println("==========================================\n");

                    currentData.country = countrySelected;
                    currentData.climateType = climateType;
                    currentData.disasterType = disasterType;
                    currentData.risk = risk;
                    display.DisplayClimateInformation(currentData);

                    char charInput = scanner.next().charAt(0);

                    Boolean confirm = (charInput == 'Y' || charInput == 'y') ? true : false;

                    if (confirm) {
                        // If all input is okay, finally add data to database
                        dataManager.AddData(currentData);
                    } else {
                        System.out.println("Invalid input, please enter only 'Y' or 'N'!\n");
                        TimeUnit.MILLISECONDS.sleep(500);
                        break;
                    }

                }

                break;

            case 3:
                // Edit country info
                display.AdminMenuEditCountryList();

                try {
                    inputSelectionValue = scanner.nextInt();
                    countrySelected = CountrySelection(inputSelectionValue);
                    Boolean validSelection = true;

                    // Show current Country Information
                    if (validSelection) {
                        ClimateInformation dataToDisplay = dataManager.GetCountryInfo(countrySelected);
                        if (dataToDisplay != null) {
                            System.out.println("Current Information: ");
                            display.DisplayClimateInformation(dataToDisplay);
                            display.AdminEditMenu();

                            inputSelectionValue = scanner.nextInt();

                            ProcessAdminEdit(dataToDisplay, inputSelectionValue);

                        } else {
                            System.out.println("Cannot find country in database..\n");
                            TimeUnit.MILLISECONDS.sleep(500);
                        }
                        scanner.nextLine();
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, please try again.\n");
                    TimeUnit.MILLISECONDS.sleep(500);
                    scanner.nextLine();
                }

                break;
            case 4:
                // filter by risk level
                // view all countries by risk level
                display.AdminMenuRiskLevel();
                inputSelectionValue = scanner.nextInt();

                ArrayList<ClimateInformation> dataRiskLevel = FilterByRiskLevel(inputSelectionValue);
                if (dataRiskLevel.size() != 0) {
                    for (ClimateInformation climateInformation : dataRiskLevel) {
                        display.DisplayClimateInformation(climateInformation);
                    }
                    System.out.println("\nPress ENTER to continue...\n");
                    TimeUnit.MILLISECONDS.sleep(500);
                    scanner.nextLine();
                    scanner.nextLine();

                } else {
                    System.out.println("There is no available data..");
                    TimeUnit.MILLISECONDS.sleep(500);
                }

                break;
            case 5:
                // filter by climate type
                display.AdminMenuClimateType();
                inputSelectionValue = scanner.nextInt();

                ArrayList<ClimateInformation> dataClimateType = FilterByClimateType(inputSelectionValue);
                if (dataClimateType.size() != 0) {
                    for (ClimateInformation climateInformation : dataClimateType) {
                        display.DisplayClimateInformation(climateInformation);
                    }
                    scanner.nextLine();
                } else {
                    System.out.println("There is no available data..");
                    TimeUnit.MILLISECONDS.sleep(500);
                }

                break;
            case 6:
                // filter by disaster type
                display.AdminMenuDisasterType();
                inputSelectionValue = scanner.nextInt();

                ArrayList<ClimateInformation> dataDisasterType = FilterByDisasterType(inputSelectionValue);
                if (dataDisasterType.size() != 0) {
                    for (ClimateInformation climateInformation : dataDisasterType) {
                        display.DisplayClimateInformation(climateInformation);
                    }
                    scanner.nextLine();
                } else {
                    System.out.println("There is no available data..");
                    TimeUnit.MILLISECONDS.sleep(500);
                }

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

            case 4:
                // Fully delete a country from the database
                System.out.println("Remove this country from the database? Y/N");

                char charInput = scanner.next().charAt(0);

                Boolean confirm = (charInput == 'Y' || charInput == 'y') ? true : false;

                if (confirm) {
                    if (countrySelected != null) {
                        System.out.println("Country Selected " + countrySelected);
                        dataManager.RemoveData(countrySelected);
                    } else {
                        System.out.println("\nInvalid input, please try again.\n");
                        TimeUnit.MILLISECONDS.sleep(500);
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("\nExiting, going back to admin menu\n");
                    TimeUnit.MILLISECONDS.sleep(500);
                }
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
                // Tropical
                climateType = ClimateInformation.ClimateType.Tropical;
                break;
            case 2:
                // Dry
                climateType = ClimateInformation.ClimateType.Dry;
                break;
            case 3:
                // Temperate
                climateType = ClimateInformation.ClimateType.Temperate;
                break;
            case 4:
                // Continental
                climateType = ClimateInformation.ClimateType.Continental;
                break;
            case 5:
                // Polar
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
                // Flood
                disasterType = ClimateInformation.DisasterType.Flood;
                break;
            case 2:
                // Drought
                disasterType = ClimateInformation.DisasterType.Drought;
                break;
            case 3:
                // Tornado
                disasterType = ClimateInformation.DisasterType.Tornado;
                break;
            case 4:
                // Wildfire
                disasterType = ClimateInformation.DisasterType.Wildfire;
                break;
            case 5:
                // Earthquake
                disasterType = ClimateInformation.DisasterType.Earthquake;
                break;

            case 6:
                // Hurricane
                disasterType = ClimateInformation.DisasterType.Hurricane;
                break;

            case 7:
                // Cyclone
                disasterType = ClimateInformation.DisasterType.Cyclone;
                break;

            default:
                break;
        }

        data.disasterType = disasterType;
        dataManager.UpdateData(data);
    }

    public static ArrayList<ClimateInformation> FilterByRiskLevel(int value) {

        ClimateInformation.Risk risk = null;

        switch (value) {
            case 1:
                risk = ClimateInformation.Risk.LOW;
                break;
            case 2:
                risk = ClimateInformation.Risk.MEDIUM;
                break;
            case 3:
                risk = ClimateInformation.Risk.HIGH;
                break;

            default:
                break;
        }

        return dataManager.GetRiskInfo(risk);
    }

    public static ArrayList<ClimateInformation> FilterByClimateType(int value) {

        ClimateInformation.ClimateType climateType = null;

        switch (value) {
            case 1:
                // Tropical
                climateType = ClimateInformation.ClimateType.Tropical;
                break;
            case 2:
                // Dry
                climateType = ClimateInformation.ClimateType.Dry;
                break;
            case 3:
                // Temperate
                climateType = ClimateInformation.ClimateType.Temperate;
                break;
            case 4:
                // Continental
                climateType = ClimateInformation.ClimateType.Continental;
                break;
            case 5:
                // Polar
                climateType = ClimateInformation.ClimateType.Polar;
                break;

            default:
                break;
        }

        return dataManager.GetClimateTypeInfo(climateType);
    }

    public static ArrayList<ClimateInformation> FilterByDisasterType(int value) {

        ClimateInformation.DisasterType disasterType = null;

        switch (value) {
            case 1:
                // Flood
                disasterType = ClimateInformation.DisasterType.Flood;
                break;
            case 2:
                // Drought
                disasterType = ClimateInformation.DisasterType.Drought;
                break;
            case 3:
                // Tornado
                disasterType = ClimateInformation.DisasterType.Tornado;
                break;
            case 4:
                // Wildfire
                disasterType = ClimateInformation.DisasterType.Wildfire;
                break;
            case 5:
                // Earthquake
                disasterType = ClimateInformation.DisasterType.Earthquake;
                break;

            case 6:
                // Hurricane
                disasterType = ClimateInformation.DisasterType.Hurricane;
                break;

            case 7:
                // Cyclone
                disasterType = ClimateInformation.DisasterType.Cyclone;
                break;

            default:
                break;
        }

        return dataManager.GetDisasterInfo(disasterType);
    }

    public static ClimateInformation.Country CountrySelection(int value) throws InterruptedException {
        ClimateInformation.Country country = null;

        switch (value) {
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
                country = ClimateInformation.Country.Egypt;
                break;
            case 7:
                country = ClimateInformation.Country.America;
                break;

            default:
                System.out.println("Invalid option selected, please try again.\n");
                TimeUnit.MILLISECONDS.sleep(500);
                scanner.nextLine();
                break;
        }

        return country;
    }

}
