package InClassWork;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class ExportPostGre {
    public static void main(String[] args) {
        exportPostgreData();
    }

    public static void exportPostgreData() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/2024Class";
        String username = "postgres";
        String password = "revenge7";

        String sqlQuery = "SELECT * FROM myClass";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = preparedStatement.executeQuery();
             XSSFWorkbook workbook = new XSSFWorkbook()) { // Auto-closeable resource

            var sheet = workbook.createSheet("ExportedData");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create header row with column names
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < columnCount; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(metaData.getColumnName(col + 1));
            }

            int rowNum = 1;
            while (resultSet.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int col = 0; col < columnCount; col++) {
                    Cell cell = row.createCell(col);
                    cell.setCellValue(resultSet.getString(col + 1));
                }
            }


            try (FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/exported_data.xlsx"))) {
                workbook.write(out);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}