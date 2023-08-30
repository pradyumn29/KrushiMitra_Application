//package com.app.service;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.app.custom_exceptions.ResourceNotFoundException;
//import com.app.entities.Employee;
//import com.app.pojos.Products;
//import com.app.repositiory.ProductRepository;
//
//import io.swagger.v3.oas.models.responses.ApiResponse;
//import nonapi.io.github.classgraph.utils.FileUtils;
//
//@Service
//@Transactional
//public class ImageHandlingServiceImpl implements ImageHandlingService {
//	// dep : emp dao i/f
//	@Autowired
//	private ProductRepository prodRepo;
//	// how to inject the property from app property file :
////SpEL : spring Expression language
//	@Value("${upload.location}")
//	private String uploadFolder;
//
//	// add custom init method to check if folder exists ,`	
//	// if not create a new one !
//	@PostConstruct
//	public void myInit() {
//		System.out.println("in init " + uploadFolder);
//		// chk if folder exists
//		File dir = new File(uploadFolder);
//		if (dir.exists())
//			System.out.println("folder alrdy exists !!!!");
//		else {
//			dir.mkdirs();// creating required dirs
//			System.out.println("created a new folder");
//		}
//
//	}
//
////	@Override
////	public void uploadImageToFolder(Long prodId, MultipartFile file) throws IOException {
////	
////		Products prod = prodRepo.findById(prodId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id!!!!"));
////		String imagePath = uploadFolder.concat(file.getOriginalFilename());
////		System.out.println(imagePath);
////		// to write byte[] data from uploaded file to a server side folder
////		// Files.write(Path.of(imagePath),file.getBytes());
////		FileUtils.writeByteArrayToFile(new File(imagePath), file.getBytes());
////		// setter
////		prod.setImageUrl(imagePath);// saves the image path in db
////	}
////
////	@Override
////	public byte[] downloadImageFromFolder(Long empId) throws IOException {
////		// chk if emp exists
////		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id!!!!"));
////		// => emp persistent
////		// get image path from DB
////		String path = emp.getImagePath();
////		if (path == null)
////			throw new ResourceNotFoundException("Image not yet assigned!!!!");
////		// emp : valid ,image exists
////		// image file --> byte[]
////		//form db : return emp.getImage();
////		return FileUtils.readFileToByteArray(new File(path));
////	}
//
//}
