package pe.joedayz.easyshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.joedayz.easyshop.services.FileUploadService;

/**
 * @author josediaz
 **/
@RestController
@RequestMapping("/api/file")
@CrossOrigin
public class FileUpload {

  @Autowired
  FileUploadService fileUploadService;

  @PostMapping
  public ResponseEntity<?> fileUpload(@RequestParam(value = "file",required = true) MultipartFile file, @RequestParam(value = "fileName",required = true) String fileName){

    int statusCode = fileUploadService.uploadFile(file,fileName);
    return new ResponseEntity<>(statusCode == 201 ? HttpStatus.CREATED: HttpStatus.INTERNAL_SERVER_ERROR);
  }
}