package org.example.textfiledownload;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TextDownloadController {

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile() {
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.CONTENT_DISPOSITION, """
                        attachment; filename="%s"\
                        """.formatted("text.txt"))
                .body(new ByteArrayResource("hello world".getBytes()));
    }
}
