package InClassWork;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;



import java.io.*;

public class InputOutput {

    public static void main(String[] args) {

        System.out.println(readFile());
    }

    public static String readFile() {
        String path = System.getProperty("user.home") + "/Desktop/exported_data.xlsx";
        StringBuilder rowData = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = wb.getSheetAt(0);

            boolean isFirstRow = true; // Add a flag to identify the first row

            for (Row row : sheet) {
                // Skip the first row which contains the headers
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                StringBuilder rowString = new StringBuilder();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowString.append(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowString.append(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            rowString.append(cell.getBooleanCellValue());
                            break;
                        default:
                            rowString.append(" ");
                    }
                    rowString.append(" "); // Append space after each cell value
                }

                // Remove the trailing space added after the last cell value of each row
                if (!rowString.isEmpty()) {
                    rowString.deleteCharAt(rowString.length() - 1);
                }

                rowData.append(rowString).append("\n");
            }

            wb.close();
            fileInputStream.close();

            return rowData.toString().trim(); // Trim the final string to remove any leading/trailing whitespace

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ""; // This needs to return a String in case of an exception
        }
    }


    public static void writeFile() {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Student Data");
        String[] columnNames = {"Name", "Email", "Phone"};

        Object[][] data = {
                {"John Doe", "John@example.com", "111-222-3333"},
                {"Mary Doe", "Mary@example.com", "422-122-3433"},
                {"Anna Collins", "Anna@example.com", "421-242-1333"},
                {"Ronaldo Nazario", "r9@example.com", "124-242-3353"},
                {"Lionel Dicaprio", "leo@example.com", "521-232-3335"}
        };
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnNames.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnNames[i]);
        }


        int rowNum = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int column = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(column++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/StudentData.xlsx"))) {
            wb.write(outputStream);
            System.out.println("Excel File Created successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
