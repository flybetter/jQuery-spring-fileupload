package sk.bsmk.fileupload.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sk.bsmk.fileupload.Application;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UploadControllerTest {

  @Autowired
  UploadController uploadController;

  @Test
  public void test() throws Exception {

    MockMultipartFile firstFile = new MockMultipartFile("file1", "filename.txt", "text/plain", "some xml".getBytes());
    MockMultipartFile secondFile = new MockMultipartFile("file2", "other-file-name.data", "text/plain", "some other type".getBytes());
    MockMultipartFile thirdFile = new MockMultipartFile("file3", "file.txt", "text/plain", "some data".getBytes());

    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(uploadController).build();
    mockMvc.perform(MockMvcRequestBuilders.fileUpload("/file-upload")
        .file(firstFile)
        .file(secondFile)
        .file(thirdFile))
        .andExpect(status().is(200))
        .andExpect(content().string("total: 3"));

  }

}