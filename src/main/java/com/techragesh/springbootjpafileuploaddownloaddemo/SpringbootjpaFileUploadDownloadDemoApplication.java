package com.techragesh.springbootjpafileuploaddownloaddemo;

import com.techragesh.springbootjpafileuploaddownloaddemo.model.FileUpload;
import com.techragesh.springbootjpafileuploaddownloaddemo.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@SpringBootApplication
public class SpringbootjpaFileUploadDownloadDemoApplication implements CommandLineRunner {

	@Autowired
	FileUploadRepository fileUploadRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaFileUploadDownloadDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ClassPathResource forImage = new ClassPathResource("static/attachments/pic-1.jpeg");
		byte[] content1 = new byte[(int) forImage.contentLength()];
		forImage.getInputStream().read(content1);
		FileUpload upload1 = new FileUpload(1L,"Casa-Grand", "jpeg", content1);

		ClassPathResource forDoc = new ClassPathResource("static/attachments/home.txt");
		byte[] content2 = new byte[(int) forDoc.contentLength()];
		forDoc.getInputStream().read(content2);
		FileUpload upload2 = new FileUpload(2L,"Casa-Grand", "txt", content2);

		ClassPathResource forPdf = new ClassPathResource("static/attachments/layout.pdf");
		byte[] content3 = new byte[(int) forPdf.contentLength()];
		forPdf.getInputStream().read(content3);
		FileUpload upload3 = new FileUpload(3L,"Casa-Grand", "pdf", content3);

		//store files
		fileUploadRepository.saveAll(Arrays.asList(upload1, upload2, upload3));

		//retrieve files
		for (FileUpload upload: fileUploadRepository.findAll()) {
			Files.write(Paths.get("downloads/" + upload.getHouseName() + "." + upload.getHouseType()), upload.getImages());
		}

	}
}
