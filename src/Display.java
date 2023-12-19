import java.util.concurrent.*; //Allows the use of TimeUnit.MILLISECONDS.sleep(500); //Time buffer to make program flow smoother.

public class Display {

    public void StartingMenu() {
        System.out.println("========================================================");
        System.out.println("                CLIMATE ACTION PROGRAM                  ");
        System.out.println("========================================================");
        System.out.println("\n[1] ADMIN");
        System.out.println("[2] USER");
        System.out.println("[3] QUIT\n");

    }

    public void AdminMenuLogin() throws InterruptedException {
        // default admin, 123456
        System.out.println("Enter Admin ID: \n");
        TimeUnit.MILLISECONDS.sleep(500); // This feature must be used along with "throws InterruptedException".
        System.out.println("Enter Password: \n");

    }

    public void AdminMenu() {
        System.out.println("\n================ ADMIN ================\n");
        System.out.println("[1] View All Countries Geo Information"); // show all countries data
        System.out.println("[2] Add Data by Country");
        System.out.println("[3] Edit Country Information"); // Edit info
        System.out.println("[4] Filter By Risk Level"); // LOW, MEDIUM, HIGH
        System.out.println("[5] Filter By Climate Type"); // Tropical, Dry, Continental, etc..
        System.out.println("[6] Filter By Disaster Type"); // Drought, Flood, Cyclone, etc..
        System.out.println("[7] Exit \n");
    }

    public void AdminMenuAddCountryList() {
        System.out.println("Select a country to add: \n");
        System.out.println("[1] Malaysia");
        System.out.println("[2] Africa");
        System.out.println("[3] China");
        System.out.println("[4] Greenland");
        System.out.println("[5] Canada");
        System.out.println("[6] United Arab Emirates");
        System.out.println("[7] America\n");
    }

    public void AdminMenuEditCountryList() {
        System.out.println("Select a country to edit: \n");
        System.out.println("[1] Malaysia");
        System.out.println("[2] Africa");
        System.out.println("[3] China");
        System.out.println("[4] Greenland");
        System.out.println("[5] Canada");
        System.out.println("[6] United Arab Emirates");
        System.out.println("[7] America\n");
    }

    public void AdminEditMenu() {
        System.out.println("\nSelect category to edit: ");
        System.out.println("[1] Risk Level");
        System.out.println("[2] Climate Type");
        System.out.println("[3] Disaster Type");
        System.out.println("[4] Fully delete country information");
        System.out.println("[5] Back\n");
    }

    public void AdminMenuRiskLevel() {
        System.out.println("Select a risk level: \n");
        System.out.println("[1] Low");
        System.out.println("[2] Medium");
        System.out.println("[3] High\n");

    }

    public void AdminMenuClimateType() {
        System.out.println("Select a climate type: \n");
        System.out.println("[1] Tropical");
        System.out.println("[2] Dry");
        System.out.println("[3] Temperate");
        System.out.println("[4] Continental");
        System.out.println("[5] Polar\n");

    }

    public void AdminMenuDisasterType() {
        System.out.println("Select a disaster type: \n");
        System.out.println("[1] Flood");
        System.out.println("[2] Drought");
        System.out.println("[3] Tornado");
        System.out.println("[4] Wildfire");
        System.out.println("[5] Earthquake");
        System.out.println("[6] Hurricane");
        System.out.println("[7] Cyclone\n");

    }

    public void UserMenu() {
        System.out.println("================ USER ================\n");
        System.out.println("[1] View All Geographical Information");
        System.out.println("[2] Explore Educational Materials"); // Leads to UserMenuEduMaterials() method that lists
                                                                 // info on disasters/climate types/disaster-prevention.
        System.out.println("[3] SDG13 Vision & Goals"); // Describes the purpose and targets of SDG13.
        System.out.println("[4] Exit\n");

    }

    public void UserMenuEduMaterials() // Info Panel for Educational Materials
    {
        System.out.println("\n--------- EDUCATIONAL MATERIALS ---------");
        System.out.println("[1] Types of Climates");
        System.out.println("[2] Types of Disasters");
        System.out.println("[3] Combating Climate Change: FAQ\n");
    }

    public void UserMenuCountryList() {
        System.out.println("Select a country to view further info or filter the list of countries..\n");
        System.out.println("[1] Select Country"); // Leads to a prompt asking user which country they'd like to select
                                                  // --> Info panel on selected country
        System.out.println("[2] Filter By Risk Level"); // LOW, MEDIUM, HIGH
        System.out.println("[3] Filter By Climate Type"); // Tropical, Dry, Continental, etc..
        System.out.println("[4] Filter By Disaster Type\n"); // Drought, Flood, Cyclone, etc..
    }

    public void UserMenuCountryInfo() {
        System.out.println("----------------------------------------");
        System.out.println("\t\tMALAYSIA");
        System.out.println("----------------------------------------");
    }

    public void DisplayClimateInformation(ClimateInformation data) {
        System.out.println("\n");
        System.out.println("Country: " + data.country);
        System.out.println("Risk Level: " + data.risk.toString());
        System.out.println("Disaster Type: " + data.disasterType.toString());
        System.out.println("Climate Type: " + data.climateType.toString());
    }

    public void EduMaterialsClimateType()
    {
        {
            System.out.println("\n--------------------- Types of Climates ---------------------\n");
            System.out.println(">> Tropical");
            System.out.println("High temperatures throughout the year, with minimal temperature variation. Consistent day length and abundant rainfall. Common vegetation includes tropical rainforests.\n");
            System.out.println(">> Dry");
            System.out.println("Low precipitation, resulting in arid or semi-arid conditions. Wide temperature variations between day and night. Vegetation varies from deserts to grasslands.\n");
            System.out.println(">> Temperate");
            System.out.println("Moderate temperatures with distinct seasons – warm summers and cool winters. Well-distributed rainfall throughout the year. Broadleaf deciduous forests, grasslands, and mixed forests are common.\n");
            System.out.println(">> Continental");
            System.out.println("Greater temperature extremes between summer and winter, with hot summers and cold winters. Precipitation varies but is often moderate. Vegetation can include deciduous and coniferous forests.\n");
            System.out.println(">> Polar");
            System.out.println(" Extremely cold temperatures, especially in winter, with little seasonal variation. Short summers with long days and long winters with extended darkness. Low precipitation, often in the form of snow. Tundra and polar deserts characterize the vegetation.\n");
            }
    }

    public void EduMaterialsDisasterType()
    {
        System.out.println("\n--------------------- Types of Disasters ---------------------\n");
        System.out.println(">> Flood");
        System.out.println("Flooding occurs when water exceeds normal levels, submerging land. It can result from heavy rainfall, storm surges, dam failures, or rapid melting of snow.\n");
        System.out.println(">> Drought");
        System.out.println("Drought is an extended period of below-average rainfall, leading to water shortages. It can affect agriculture, water supplies, and ecosystems.\n");
        System.out.println(">> Tornado");
        System.out.println("Tornadoes are violent windstorms characterized by a twisting, funnel-shaped cloud. They form from powerful thunderstorms and can cause"); 
        System.out.println("significant damage along their narrow path.\n");
        System.out.println(">> Wildfire");
        System.out.println("Wildfires are uncontrolled fires that spread rapidly through vegetation, often in forests or grasslands. They can be triggered by"); 
        System.out.println("lightning, human activities, or a combination of factors.\n");
        System.out.println(">> Earthquake");
        System.out.println("Earthquakes are caused by the sudden release of energy in the Earth's crust, leading to the shaking of the ground. They can occur along"); 
        System.out.println("fault lines or tectonic plate boundaries.\n");
        System.out.println(">> Hurricane");
        System.out.println("Hurricanes are powerful tropical cyclones with strong winds and heavy rainfall. They form over warm ocean waters and can bring about"); 
        System.out.println("storm surges and intense rainfall.\n");
        System.out.println(">> Cyclone");
        System.out.println("Cyclones are the same meteorological phenomena as hurricanes but are referred to as cyclones in the Indian Ocean and some other regions."); 
        System.out.println("They include both tropical cyclones and typhoons.\n");
    }

    public void EduMaterialsClimateChange()
    {
        System.out.println("\n---------------- Combating Climate Change : FAQ ----------------\n");
        System.out.println("What can we do to combat climate change?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(">> Reduce Greenhouse Gas Emissions:\n");
        System.out.println("- Transition to renewable energy sources such as solar, wind, and hydro power.");
        System.out.println("- Increase energy efficiency in buildings, transportation, and industries.\n");
        System.out.println(">> Promote Sustainable Transportation:\n");
        System.out.println("- Encourage the use of public transportation, cycling, and walking.");
        System.out.println("- Support the development and use of electric vehicles.\n");
        System.out.println(">> Raise Awareness and Education:\n");
        System.out.println("- Educate yourself and others about climate change impacts and solutions.");
        System.out.println("- Raise awareness in your community and among your social networks.\n");
        System.out.println("How will climate change affect us?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Temperature Increase: Global temperatures have risen, leading to more frequent and intense heatwaves. This warming contributes to various environmental changes, including"); 
        System.out.println("melting ice caps and glaciers.\n");
        System.out.println("Sea Level Rise: The warming of the planet is causing glaciers and polar ice caps to melt, contributing to rising sea levels. This poses a threat to low-lying coastal areas, leading to"); 
        System.out.println("increased risks of flooding and saltwater intrusion.\n");
        System.out.println("Ecosystem Disruption: Climate change is impacting ecosystems, leading to shifts in plant and animal habitats, changes in migration patterns, and disruptions to biodiversity. Some species"); 
        System.out.println("may struggle to adapt, leading to population declines or even extinction.");
        System.out.println("-----------------------------------------------------------------\n");
    }

    public void SDG13Goals()
    {

        System.out.println("---------------- Sustainable Development Goal 13 (SDG13) ----------------");
        System.out.println("\n================== Vision - Climate Action ==================\n");
        System.out.println("Ensure a resilient and sustainable future for all, where the planet is protected from the adverse impacts of climate change, and"); 
        System.out.println("societies thrive in a low-carbon, climate-resilient environment.\n");

        System.out.println("================== SDG13 Goals/Mission ================== \n");
        System.out.println("Mitigation of Greenhouse Gas Emissions: ");
        System.out.println("------------------------------------------------");
        System.out.println("Promote efforts to reduce global greenhouse gas emissions to limit the increase in global average temperature.");
        System.out.println("Encourage the adoption of renewable energy sources and the phasing out of fossil fuels.\n");

        System.out.println("Adaptation and Resilience: ");
        System.out.println("------------------------------------------------");
        System.out.println("Enhance adaptive capacity, strengthen resilience, and reduce vulnerability to the impacts of climate change.");
        System.out.println("Implement strategies to adapt to changing climate conditions, especially in vulnerable and marginalized communities.\n");

        System.out.println("Sustainable Development Integration: ");
        System.out.println("------------------------------------------------");
        System.out.println("Integrate climate change measures into national policies, strategies, and planning to promote sustainable development.");
        System.out.println("Ensure that climate action supports and does not undermine efforts to achieve other Sustainable Development Goals.\n");

    }

}
