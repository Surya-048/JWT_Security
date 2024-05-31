package rest.Rest_Beginning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class FileController {


    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Response must contain file");
        }else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
                String filename = sdf.format(new Date());
                String path = "/home/rapidsoft/Documents/image/" + filename + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                byte[] fileData = file.getBytes();
                FileOutputStream fos = new FileOutputStream(path);
                fos.write(fileData);
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.ok("Working");
    }
}
