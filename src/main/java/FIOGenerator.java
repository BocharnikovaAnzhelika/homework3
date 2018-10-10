import java.io.IOException;

public class FIOGenerator {
    private String pathToStorage = "src/main/resources/FIO";
    private String pathToFemaleNames = pathToStorage + "/FemaleNames.txt";
    private String pathToMenNames = pathToStorage + "/MenNames.txt";
    private String pathToPatronymics = pathToStorage + "/Patronymics.txt";
    private String pathToSurname = pathToStorage + "/Surnames.txt";

    public String getFemaleName() throws IOException {
        return GetterFromFile.getter(pathToFemaleNames);
    }

    public String getManName() throws IOException {
        return GetterFromFile.getter(pathToMenNames);
    }

    public String getPatronymic() throws IOException {
        return GetterFromFile.getter(pathToPatronymics);
    }

    public String getSurname() throws IOException {
        return GetterFromFile.getter(pathToSurname);
    }

}
