
import java.io.FileReader;
import java.io.IOException; // Import the IOException class to handle errors
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.google.gson.Gson; //Google JSON Library for file storage

public class DataManager {

  public ArrayList<ClimateInformation> climateInformationList = new ArrayList<>();

  // for testing, if lazy to populate data.
  public void PopulateRandomData() {

    ClimateInformation newData = new ClimateInformation();

    Random random = new Random();
    int index;

    String[] countryList = { "Malaysia", "China", "India", "America", "Africa" };
    ClimateInformation.ClimateType[] climateTypes = ClimateInformation.ClimateType.values();
    ClimateInformation.DisasterType[] disasterTypes = ClimateInformation.DisasterType.values();
    ClimateInformation.Risk[] risk = ClimateInformation.Risk.values();

    index = random.nextInt(countryList.length);
    newData.country = countryList[index];

    index = random.nextInt(climateTypes.length);
    newData.climateType = climateTypes[index];

    index = random.nextInt(disasterTypes.length);
    newData.disasterType = disasterTypes[index];

    index = random.nextInt(risk.length);
    newData.risk = risk[index];

    climateInformationList.add(newData);
    SaveToJSON(climateInformationList);
  }

  public void SaveToJSON(ArrayList<ClimateInformation> climateInformationList) {

    Gson gson = new Gson();

    try (Writer writer = Files.newBufferedWriter(Paths.get("database.json"))) {
      gson.toJson(climateInformationList, writer);
    } catch (IOException e) {
      e.printStackTrace(); // Handle the exception according to your application's needs
    }
  }

  public void ReadFromJSON() {
    try (FileReader reader = new FileReader("database.json")) {

      Gson gson = new Gson();

      ClimateInformation[] dataArray = gson.fromJson(reader, ClimateInformation[].class);

      if (dataArray == null || dataArray.length == 0) {
        System.out.println("Data is empty");
        return;
      }

      climateInformationList = new ArrayList<>(List.of(dataArray));

      /*for (ClimateInformation data : climateInformationList) {
        System.out.println("Country: " + data.country);
        System.out.println("Risk Level: " + data.risk.toString());
        System.out.println("Disaster Type: " + data.disasterType.toString());
        System.out.println("Climate Type: " + data.climateType.toString());
        System.out.println("\n");

      }*/

    } catch (IOException e) {
      System.out.println("File not found");
    }
  }

  public ClimateInformation GetCountryInfo(String country) {
    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.country.equals(country)) {
        return climateInformation;
      }
    }
    return null;
  }

  public ArrayList<ClimateInformation> GetRiskInfo(ClimateInformation.Risk risk) {

    ArrayList<ClimateInformation> list = new ArrayList<>();

    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.risk == risk) {
        list.add(climateInformation);
      }
    }
    return list;
  }

  public ArrayList<ClimateInformation> GetDisasterInfo(ClimateInformation.DisasterType disasterType) {

    ArrayList<ClimateInformation> list = new ArrayList<>();

    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.disasterType == disasterType) {
        list.add(climateInformation);
      }

    }
    return list;
  }

  public ArrayList<ClimateInformation> GetClimateTypeInfo(ClimateInformation.ClimateType climateType) {

    ArrayList<ClimateInformation> list = new ArrayList<>();

    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.climateType == climateType) {
        list.add(climateInformation);
      }

    }
    return list;
  }

  //fully clears the database
  public void ClearDatabase()
  {
    climateInformationList.clear();
    SaveToJSON(climateInformationList);
  }

  public void RemoveData(String country)
  {
    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.country.equals(country)) {
        climateInformationList.remove(climateInformation);
      }
    }

    SaveToJSON(climateInformationList);
  }

  public void AddData(String country, ClimateInformation.Risk risk, ClimateInformation.ClimateType climateType, ClimateInformation.DisasterType disasterType)
  {
    ClimateInformation newData = new ClimateInformation();

    newData.country = country;
    newData.risk = risk;
    newData.climateType = climateType;
    newData.disasterType = disasterType;

    climateInformationList.add(newData);
    SaveToJSON(climateInformationList);
  }

}
