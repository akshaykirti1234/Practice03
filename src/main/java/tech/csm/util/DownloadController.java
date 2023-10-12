package tech.csm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sports")
public class DownloadController {

	@GetMapping("/download")
	public void downloadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String filename = req.getParameter("fn");
		System.out.println("hii...");
		String filepath = "d:\\UploadFile\\";
		resp.setContentType("APPLICATION/OCTET-STREAM");
		resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

		FileInputStream fileInputStream = new FileInputStream(filepath + filename);

		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	}

}
