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
        System.out.println("================ ADMIN ================\n");
        System.out.println("=========== Geographical Information =========\n"); 
        System.out.println("Select a country to view further info or filter the list of countries..\n");
        System.out.println("[1] View All Countries Geo Information"); //show all countries data
        System.out.println("[2] Edit Country Information"); //Leads to a menu panel where a country's information can be updated or deleted.
        System.out.println("[3] Filter By Risk Level"); //LOW, MEDIUM, HIGH
        System.out.println("[4] Filter By Climate Type"); //Tropical, Dry, Continental, etc..
        System.out.println("[5] Filter By Disaster Type\n"); //Drought, Flood, Cyclone, etc..
        System.out.println("[6] Exit ");
    }

    public void AdminMenuCountryList()
    {
        System.out.println("Select a country to edit information\n");
        System.out.println("[1] Malaysia"); 
        System.out.println("[2] Africa"); 
        System.out.println("[3] China"); 
        System.out.println("[4] Greenland"); 
        System.out.println("[5] Canada");
        System.out.println("[6] United Arab Emirates");
        System.out.println("[7] America\n");
    }

    public void AdminMenuRiskLevel() 
    {
        System.out.println("Select a risk level");
        System.out.println("[1] Low"); 
        System.out.println("[2] Medium"); 
        System.out.println("[3] High\n"); 
       
    }

    public void AdminMenuClimateType() 
    {
        System.out.println("Select a climate type");
        System.out.println("[1] Tropical"); 
        System.out.println("[2] Dry"); 
        System.out.println("[3] Temperate");
        System.out.println("[4] Continental"); 
        System.out.println("[5] Polar");
       
    }

    public void AdminMenuDisasterType() 
    {
        System.out.println("Select a disaster type");
        System.out.println("[1] Flood"); 
        System.out.println("[2] Drought"); 
        System.out.println("[3] Tornado");
        System.out.println("[4] Wildfire"); 
        System.out.println("[5] Earthquake");
        System.out.println("[6] Hurricane");
        System.out.println("[7] Cyclone\n");
       
    }


    public void UserMenu()
    {
        System.out.println("================ USER ================\n");
        System.out.println("[1] View All Geographical Information");
        System.out.println("[2] Explore Educational Materials"); //Leads to UserMenuEduMaterials() method that lists info on disasters/climate types/disaster-prevention.
        System.out.println("[3] SDG13 Vision & Goals"); //Describes the purpose and targets of SDG13.
        System.out.println("[4] Exit\n");

    }

    public void UserMenuEduMaterials() //Info Panel for Educational Materials 
    {
        System.out.println("[1] Types of Climates");
        System.out.println("[2] Types of Disasters");
        System.out.println("[3] Combating Climate Change: FAQ");
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

    public void DisplayClimateInformation(ClimateInformation data)
    {
        System.out.println("Country: " + data.country);
        System.out.println("Risk Level: " + data.risk.toString());
        System.out.println("Disaster Type: " + data.disasterType.toString());
        System.out.println("Climate Type: " + data.climateType.toString());
        System.out.println("\n");
    }
    
}
