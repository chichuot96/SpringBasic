package vn.topica.itlab4.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import vn.topica.itlab4.form.MyUploadForm;
import vn.topica.itlab4.model.Student;
import vn.topica.itlab4.processDb.ProcessDb;

@Controller
public class MyFileUploadController {
	 private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-bean.xml");
     private ProcessDb studentJDBCTemplate =(ProcessDb)context.getBean("insert");


	// GET: Hiển thị trang form upload
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String uploadOneFileHandler(Model model) {

		MyUploadForm myUploadForm = new MyUploadForm();
		model.addAttribute("myUploadForm", myUploadForm);
//		studentJDBCTemplate.select();
		return "upload";
	}

	// POST: Sử lý Upload
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadOneFileHandlerPOST(HttpServletRequest request, //
			Model model, //
			@ModelAttribute("myUploadForm") MyUploadForm myUploadForm) {

		return this.doUpload(request, model, myUploadForm);

	}


	private String doUpload(HttpServletRequest request, Model model, //
			MyUploadForm myUploadForm) {

		String description = myUploadForm.getDescription();
		System.out.println("Description: " + description);

		// Thư mục gốc upload file.
		String uploadRootPath = request.getServletContext().getRealPath("upload");
		System.out.println("uploadRootPath=" + uploadRootPath);

		File uploadRootDir = new File(uploadRootPath);
		//
		// Tạo thư mục gốc upload nếu nó không tồn tại.
		if (!uploadRootDir.exists()) {
			uploadRootDir.mkdirs();
		}
		
		MultipartFile[] fileDatas = myUploadForm.getFileDatas();
		//
		List<File> uploadedFiles = new ArrayList<File>();
		for (MultipartFile fileData : fileDatas) {
			InputStream is;
			try {
				is = fileData.getInputStream();
				csvToStudent(new InputStreamReader(is));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model.addAttribute("description", description);
		model.addAttribute("uploadedFiles", uploadedFiles);
		return "uploadResult";
	}

	private void csvToStudent(Reader reader) {

		BufferedReader br = new BufferedReader(reader);
		String line;
		try {
			while((line=br.readLine())!=null) {
				System.out.println(line);
				String[] temp=line.split(",");
				Student st=new Student(temp[0],temp[1],temp[2],temp[3]);
				System.out.println(st.toString());
				studentJDBCTemplate.insert(st);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
