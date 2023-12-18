import java.util.concurrent.*; //Allows the use of TimeUnit.MILLISECONDS.sleep(500); //Time buffer to make program flow smoother.


public class Display {
    
    public void StartingMenu()
    {
        System.out.println("========================================================");
        System.out.println("                CLIMATE ACTION PROGRAM                  ");
        System.out.println("========================================================");
        System.out.println("\n[1] ADMIN");
        System.out.println("[2] USER\n");

    }

    public void AdminMenuLogin() throws InterruptedException
    {
        //default admin, 123456
        System.out.println("Enter Admin ID: \n");
        TimeUnit.MILLISECONDS.sleep(500); //This feature must be used along with "throws InterruptedException".
        System.out.println("Enter Password: \n");
        
    }

    public void AdminMenu()
    {
        System.out.println("\n");
        System.out.println("[1] View Geographical Information"); // --> List of Countries (same as user menu) --> 1) Edit/Update 2) Delete 3) Exit
        System.out.println("[2] Exit ");
    }

    public void AdminMenuCountryList()
    {
        System.out.println("Select a country to view further info or filter the list of countries..\n");
        System.out.println("[1] View Country Information"); //Leads to a prompt asking user which country they'd like to select --> Info panel on selected country
        System.out.println("[2] Edit Country Information"); //Leads to a menu panel where a country's information can be updated or deleted.
        System.out.println("[3] Filter By Risk Level"); //LOW, MEDIUM, HIGH
        System.out.println("[4] Filter By Climate Type"); //Tropical, Dry, Continental, etc..
        System.out.println("[5] Filter By Disaster Type\n"); //Drought, Flood, Cyclone, etc..
    }

    public void AdminMenuOptions() //Displayed after admin selects the 'Edit Country Information' prompt.
    {
        //placeholder
    }

    public void UserMenu()
    {
        System.out.println("\n");
        System.out.println("\n[1] View Geographical Information");
        System.out.println("[2] Explore Educational Materials"); //Leads to UserMenuEduMaterials() method that lists info on disasters/climate types/disaster-prevention.
        System.out.println("[3] SDG13 Vision & Goals"); //Describes the purpose and targets of SDG13.

    }

    public void UserMenuEduMaterials() //Info Panel for Educational Materials 
    {
        System.out.println("[1] Types of Climates");
        System.out.println("[2] Types of Disasters");
        System.out.println("[3] Combating Climate Change: FAQ");
    }

    public void UserMenuGeoInfo()
    {
        System.out.println("-------------- SELECT A REGION --------------"); 
        System.out.println("[1] North America America"); //USA, Mexico, Canada, Alaska
        System.out.println("[2] Asia"); //Japan, Malaysia, India, Vietnam
        System.out.println("[3] Middle East"); // Egypt, Turkey, United Arab Emirates
        System.out.println("[4] View All Regions"); 

        //Selection leads to UserMenuCountryList method
    }

    public void UserMenuCountryList()
    {
        System.out.println("Select a country to view further info or filter the list of countries..\n");
        System.out.println("[1] Select Country"); //Leads to a prompt asking user which country they'd like to select --> Info panel on selected country
        System.out.println("[2] Filter By Risk Level"); //LOW, MEDIUM, HIGH
        System.out.println("[3] Filter By Climate Type"); //Tropical, Dry, Continental, etc..
        System.out.println("[4] Filter By Disaster Type\n"); //Drought, Flood, Cyclone, etc..
    }

    public void UserMenuCountryInfo()
    {
        System.out.println("----------------------------------------");    
        System.out.println("\t\tMALAYSIA");
        System.out.println("----------------------------------------");    
    }
    
}
