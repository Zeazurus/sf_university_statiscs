package io;

//Использование Apache POI
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import model.*;

public class XlsWriter {

    private XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList,
                                          String filePath) throws IOException {

        //Создания таблицы и листа
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

            //Настройка стиля для заголовков
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);

            //Генерация заголовка таблицы
            int rowNumber = 0;
            Row headerRow = statisticsSheet.createRow(rowNumber++);
            Cell studyProfileCellHeader = headerRow.createCell(0);
            studyProfileCellHeader.setCellValue("Профиль обучения");
            studyProfileCellHeader.setCellStyle(headerStyle);
            Cell avgExamScoreCellHeader = headerRow.createCell(1);
            avgExamScoreCellHeader.setCellValue("Средний балл за экзамены по профилю");
            avgExamScoreCellHeader.setCellStyle(headerStyle);
            Cell numberOfStudentsByStudyProfileCellHeader = headerRow.createCell(2);
            numberOfStudentsByStudyProfileCellHeader.setCellValue("Количество студентов по профилю");
            numberOfStudentsByStudyProfileCellHeader.setCellStyle(headerStyle);
            Cell numberOfUniversitiesByProfileCellHeader = headerRow.createCell(3);
            numberOfUniversitiesByProfileCellHeader.setCellValue("Количество университетов по профилю");
            numberOfUniversitiesByProfileCellHeader.setCellStyle(headerStyle);
            Cell universityNamesCellHeader = headerRow.createCell(4);
            universityNamesCellHeader.setCellValue("Университеты");
            universityNamesCellHeader.setCellStyle(headerStyle);

            //Заполнение строк таблицы данными
            for (Statistics statistics : statisticsList) {
                Row dataRow = statisticsSheet.createRow(rowNumber++);
                Cell studyProfileCell = dataRow.createCell(0);
                studyProfileCell.setCellValue(statistics.getStudyProfile().getProfileName());
                Cell avgExamScoreCell = dataRow.createCell(1);
                avgExamScoreCell.setCellValue(statistics.getAvgExamScore());
                Cell numberOfStudentsByStudyProfileCell = dataRow.createCell(2);
                numberOfStudentsByStudyProfileCell.setCellValue(statistics.getNumberOfStudentsByStudyProfile());
                Cell numberOfUniversitiesByStudyProfileCell = dataRow.createCell(3);
                numberOfUniversitiesByStudyProfileCell.setCellValue(statistics.getNumberOfUniversitiesByStudyProfile());
                Cell universityNamesCell = dataRow.createCell(4);
                universityNamesCell.setCellValue(statistics.getUniversityNames());
            }

            //Запись таблицы в файл
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }
        }
    }
}
