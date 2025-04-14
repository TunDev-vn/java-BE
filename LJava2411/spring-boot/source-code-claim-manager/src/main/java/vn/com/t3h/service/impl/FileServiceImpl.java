package vn.com.t3h.service.impl;

import org.springframework.stereotype.Service;
import vn.com.t3h.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String getBase64FromPath(String path) {
        String base64 = null;
        // convert file to String base 64
        try {
            File file = new File(path);
            byte[] bytes = Files.readAllBytes(file.toPath());
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return base64;
    }
}
