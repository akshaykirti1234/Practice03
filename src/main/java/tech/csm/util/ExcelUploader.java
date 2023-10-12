//package tech.csm.util;
//
//import java.io.FileInputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import tech.csm.model.Country;
//import tech.csm.model.District;
//import tech.csm.model.State;
//import tech.csm.model.User;
//import tech.csm.service.CountryService;
//import tech.csm.service.DistrictService;
//import tech.csm.service.StateService;
//import tech.csm.service.UserService;
//
//@Controller
//public class ExcelUploader {
//
//	@Autowired
//	private CountryService countryService;
//	@Autowired
//	private StateService stateService;
//	@Autowired
//	private DistrictService districtService;
//	@Autowired
//	private UserService userService;
//
//	@PostMapping("/upload")
//	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
//		String contentType = file.getContentType();
//		List<User> userList = new ArrayList<>();
//		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
//			try (FileInputStream fileone = (FileInputStream) file.getInputStream()) {
//				Workbook workbook = WorkbookFactory.create(fileone);
//				Row row;
//				Sheet sheet = workbook.getSheetAt(0);
//
//				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//					row = sheet.getRow(i);
//					User user = new User();
//					user.setUserId((int) row.getCell(0).getNumericCellValue());
//					user.setUserName(row.getCell(1).getStringCellValue());
//					user.setPhoneNo(row.getCell(2).getStringCellValue());
//					user.setMail(row.getCell(3).getStringCellValue());
//					String date = row.getCell(4).getStringCellValue();
//					user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(date));
//
//					Country country = countryService.getCountryByName(row.getCell(5).getStringCellValue());
//					user.setCountry(country);
//
//					State state = stateService.getStateByName(row.getCell(6).getStringCellValue());
//					user.setState(state);
//
//					District district = districtService.getDistrictByName(row.getCell(7).getStringCellValue());
//					user.setDistrict(district);
//					user.setPhoto(row.getCell(8).getStringCellValue());
//
//					userList.add(user);
//				}
//				System.out.println("****************************88" + userList);
//				userService.saveAllUser(userList);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return "redirect:./";
//	}
//}
