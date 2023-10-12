//
//package tech.csm.util;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import tech.csm.model.User;
//
//public class ExcelGenerator {
//
//	private List<User> userList;
//	private XSSFWorkbook workbook;
//	private XSSFSheet sheet;
//
//	public ExcelGenerator(List<User> userList) {
//		this.userList = userList;
//		workbook = new XSSFWorkbook();
//	}
//
//	private void writeHeader() {
//		sheet = workbook.createSheet("Emp");
//		Row row = sheet.createRow(0);
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		font.setFontHeight(16);
//		style.setFont(font);
//		createCell(row, 0, "ID", style);
//		createCell(row, 1, " Name", style);
//		createCell(row, 2, "Phone No", style);
//		createCell(row, 3, "Mail", style);
//		createCell(row, 4, "Dob", style);
//		createCell(row, 5, "Country", style);
//		createCell(row, 6, "State", style);
//		createCell(row, 7, "District", style);
//		createCell(row, 8, "Photo", style);
//	}
//
//	private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
//		sheet.autoSizeColumn(columnCount);
//		Cell cell = row.createCell(columnCount);
//		if (valueOfCell instanceof Integer) {
//			cell.setCellValue((Integer) valueOfCell);
//		} else if (valueOfCell instanceof String) {
//			cell.setCellValue((String) valueOfCell);
//		} else if (valueOfCell instanceof Date) {
//			cell.setCellValue((Date) valueOfCell);
//		}
//		cell.setCellStyle(style);
//	}
//
//	private void write() {
//		int rowCount = 1;
//		CellStyle style = workbook.createCellStyle();
//		XSSFFont font = workbook.createFont();
//		font.setFontHeight(14);
//		style.setFont(font);
//		for (User record : userList) {
//			Row row = sheet.createRow(rowCount++);
//			int columnCount = 0;
//			createCell(row, columnCount++, record.getUserId(), style);
//			createCell(row, columnCount++, record.getUserName(), style);
//			createCell(row, columnCount++, record.getPhoneNo(), style);
//			createCell(row, columnCount++, record.getMail(), style);
//			createCell(row, columnCount++, new SimpleDateFormat("yyyy-MM-dd").format(record.getDob()), style);
//			createCell(row, columnCount++, record.getCountry().getCountryName(), style);
//			createCell(row, columnCount++, record.getState().getStateName(), style);
//			createCell(row, columnCount++, record.getDistrict().getDistrictName(), style);
//			createCell(row, columnCount++, record.getPhoto(), style);
//		}
//	}
//
//	public void generateExcelFile(HttpServletResponse response) throws IOException {
//		writeHeader();
//		write();
//		ServletOutputStream outputStream = response.getOutputStream();
//		workbook.write(outputStream);
//		workbook.close();
//		outputStream.close();
//	}
//}
