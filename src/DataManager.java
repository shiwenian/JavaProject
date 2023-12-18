
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

    ClimateInformation currentData = new ClimateInformation();

    Random random = new Random();
    int index;

    String[] countryList = { "Malaysia", "China", "India", "America", "Africa" };
    ClimateInformation.ClimateType[] climateTypes = ClimateInformation.ClimateType.values();
    ClimateInformation.DisasterType[] disasterTypes = ClimateInformation.DisasterType.values();
    ClimateInformation.Risk[] risk = ClimateInformation.Risk.values();

    index = random.nextInt(countryList.length);
    currentData.country = countryList[index];

    index = random.nextInt(climateTypes.length);
    currentData.climateType = climateTypes[index];

    index = random.nextInt(disasterTypes.length);
    currentData.disasterType = disasterTypes[index];

    index = random.nextInt(risk.length);
    currentData.risk = risk[index];

    climateInformationList.add(currentData);
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

      for (ClimateInformation data : climateInformationList) {
        System.out.println("Country: " + data.country);
        System.out.println("Risk Level: " + data.risk.toString());
        System.out.println("Disaster Type: " + data.disasterType.toString());
        System.out.println("Climate Type: " + data.climateType.toString());
        System.out.println("\n");

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ClimateInformation GetRiskInfo(ClimateInformation.Risk risk) {
    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.risk == risk) {
        return climateInformation;
      }
    }
    return null;
  }

  public ClimateInformation GetDisasterInfo(ClimateInformation.DisasterType disasterType) {
    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.disasterType == disasterType) {
        return climateInformation;
      }
    }
    return null;
  }

  public ClimateInformation GetClimateTypeInfo(ClimateInformation.ClimateType climateType) {
    for (ClimateInformation climateInformation : climateInformationList) {
      if (climateInformation.climateType == climateType) {
        return climateInformation;
      }
    }
    return null;
  }
}
