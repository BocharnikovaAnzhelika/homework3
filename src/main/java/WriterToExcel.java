import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WriterToExcel {

    public void writeIntoExcel() throws IOException{
        File file = createFile();
        Workbook book = new HSSFWorkbook();

        Sheet sheet = makeHeader(book);
        fillTable(sheet);

        book.write(new FileOutputStream(file));

        book.close();
    }

    private File createFile() throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        //создаем файл с указанием относительного пути к файлу
        long randomPart = (long) (Math.random()*100000000);
        String nameOfDirectory = "BAV_" + randomPart;

        File directory = new File(nameOfDirectory);
        if (directory.mkdir()) {
            System.out.println("Создана директория: " + nameOfDirectory);
        }else System.out.println("Не удалось создать директорию. Попытайтесь снова");

        String relativePath = nameOfDirectory + fileSeparator + "file.xls";
        File file = new File(relativePath);
        if(file.createNewFile()){
            System.out.println("В директории создан пустой файл txt");
        }else System.out.println("Не удалось создать файл");

        return file;
    }


    private Sheet makeHeader(Workbook book) throws IOException {
        Sheet sheet = book.createSheet("Клиенты");

        // Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        String[] headers = {"Имя",
                "Фамилия",
                "Отчество",
                "Возраст",
                "Пол",
                "Дата рождения",
                "ИНН",
                "Почтовый индекс",
                "Страна",
                "Область",
                "Город",
                "Улица",
                "Дом",
                "Квартира"
        };
        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy

        List<Cell> names = new ArrayList<Cell>();

        int i = 0;
        for (String h : headers) {
            names.add(row.createCell(i));
            names.get(i).setCellValue(h);
            i++;
        }
//
//        DataFormat format = book.createDataFormat();
//        CellStyle dateStyle = book.createCellStyle();
//        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//        birthdate.setCellStyle(dateStyle);
//
//
//        // Нумерация лет начинается с 1900-го
//        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
//        sheet.autoSizeColumn(1);
        // Записываем всё в файл


        return sheet;
    }

    private Sheet fillTable(Sheet sheet) throws IOException {
        int rownum = (int) (Math.random() * 1000) % 30 + 1;

        for (int r = 1; r <= rownum; r++){

            Row row = sheet.createRow(r);
            List<Cell> names = new ArrayList<Cell>();

            FIOGenerator fioGenerator = new FIOGenerator();
            AdressGenerator adressGenerator = new AdressGenerator();
            InnGenerator innGenerator = new InnGenerator();
            int index = (int) (Math.random() * 1000000);
            DateGenerator dateGenerator = new DateGenerator();
            GregorianCalendar birthday = dateGenerator.getRandomBirthday();

            int sex = (int) (Math.random() * 100) % 2;
            String Sex = "Мужской";
            String Name = fioGenerator.getManName();
            String Surname = fioGenerator.getSurname();
            String Patronymic = fioGenerator.getPatronymic() + "ич";
            if (sex == 1) {
                Sex = "Женский";
                Name = fioGenerator.getFemaleName();
                Surname += "а";
                Patronymic += fioGenerator.getPatronymic() + "на";
            }

            String[] elements = {
                    Name,
                    Surname,
                    Patronymic,
                    String.valueOf(dateGenerator.getAge(birthday)),
                    Sex,
                    birthday.getTime().getDate() + ":" + birthday.getTime().getMonth() + ":" + (birthday.getTime().getYear()+1900),
                    innGenerator.generate(),
                    String.valueOf(index),
                    adressGenerator.getCountry(),
                    adressGenerator.getRegion(),
                    adressGenerator.getCity(),
                    adressGenerator.getStreet(),
                    String.valueOf((int) (Math.random() * 100)),
                    String.valueOf((int) (Math.random() * 100))
            };

            int i = 0;
            for (String element : elements) {
                names.add(row.createCell(i));
                names.get(i).setCellValue(element);
                i++;
            }
        }

        return sheet;
    }
}
