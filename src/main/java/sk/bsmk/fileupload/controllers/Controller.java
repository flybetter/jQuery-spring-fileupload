package sk.bsmk.fileupload.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by bsmk on 9/7/14.
 */
@RestController
public class Controller {

  @RequestMapping(method = RequestMethod.POST, value = "/fileUpload")
  public ResponseEntity<String> upload(MultipartHttpServletRequest request) {
    return new ResponseEntity<String>("uploaded", HttpStatus.OK);
  }

}
