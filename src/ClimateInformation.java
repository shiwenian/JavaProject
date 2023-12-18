public class ClimateInformation
{
    public String country; 


    public enum Risk
    {
        LOW,
        MEDIUM,
        HIGH
    }

    public Risk risk;

    public enum ClimateType
    {
        Tropical,
        Dry,
        Temperate,
        Continental,
        Polar
    }

    public ClimateType climateType;

    public enum DisasterType
    {
        Flood,
        Drought,
        Tornado,
        Wildfire,
        Earthquake,
        Hurricane,
        Cyclone,
    }

    public DisasterType disasterType;
}
