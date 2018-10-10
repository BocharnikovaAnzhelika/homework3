import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriterToExcel {

    public void writeIntoExcel() throws IOException{
        File file = createFile();

        Workbook book = makeHeader(file);

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


    private Workbook makeHeader(File file) throws IOException {
        Workbook book = new HSSFWorkbook();
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
        book.write(new FileOutputStream(file));

        return book;
    }
}
