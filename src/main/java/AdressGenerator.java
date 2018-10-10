import java.io.IOException;

public class AdressGenerator {

    private String pathToStorage = "src/main/resources/Addresses";
    private String pathToCountries = pathToStorage + "/Countries.txt";
    private String pathToCities = pathToStorage + "/Cities.txt";
    private String pathToRegion = pathToStorage + "/Regions.txt";
    private String pathToStreet = pathToStorage + "/Streets.txt";

    public String  getCountry() throws IOException {
        return GetterFromFile.getter(pathToCountries);
    }

    public String getCity() throws IOException {
        return GetterFromFile.getter(pathToCities);
    }

    public String getRegion() throws IOException {
        return GetterFromFile.getter(pathToRegion);
    }

    public String getStreet() throws IOException {
        return GetterFromFile.getter(pathToStreet);
    }


}
