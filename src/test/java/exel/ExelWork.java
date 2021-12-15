package exel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExelWork {

    public static void work(){

    }

    public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {

        // Создаём объект HSSFWorkBook;
        Workbook book = new HSSFWorkbook();
        // Создаём лист, используя на объекте, созданном в предыдущем шаге, createSheet();
        Sheet sheet = book.createSheet("Birthdays");
        // Создаём на листе строку, используя createRow();Нумерация начинается с нуля
        Row row = sheet.createRow(0);

        // Создаём в строке ячейку — createCell();
        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy
        Cell name = row.createCell(0);
        //    Задаём значение ячейки через setCellValue();
        name.setCellValue("John");

        //    Для записи строк или чисел этого вполне достаточно, но чтобы записать дату, нам понадобится сделать ещё кое-что:
        //    Создать DateFormat;
        //    Создать CellStyle;
        //    Записать DateFormat в CellStyle;
        //    Записать CellStyle в ячейку;
        //    Теперь в эту ячейку можно записать объект Date через всё тот же setCellValue;
        //    Чтобы дата поместилась в ячейку, нам нужно добавить столбцу свойство автоматически менять размер: sheet.autoSizeColumn(1).


        Cell birthdate = row.createCell(1);

        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
        birthdate.setCellStyle(dateStyle);


        // Нумерация лет начинается с 1900-го
        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
        sheet.autoSizeColumn(1);

        // Записываем всё в файл
        // Записываем workbook в File через FileOutputStream;
        book.write(new FileOutputStream(file));
        //    Закрываем workbook, вызывая close().

        book.close();

    }

    public static void readFromExcel(String file) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Birthdays");
        HSSFRow row = myExcelSheet.getRow(0);

        if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
            String name = row.getCell(0).getStringCellValue();
            System.out.println("name : " + name);
        }

        if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
            Date birthdate = row.getCell(1).getDateCellValue();
            System.out.println("birthdate :" + birthdate);
        }

        if(row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_STRING){
            Double adouble =  Double.parseDouble(row.getCell(2).getStringCellValue());
            System.out.println("number : " + adouble);
            Assert.assertEquals(11224, adouble, 0.001);
        }



        myExcelBook.close();

    }
}
