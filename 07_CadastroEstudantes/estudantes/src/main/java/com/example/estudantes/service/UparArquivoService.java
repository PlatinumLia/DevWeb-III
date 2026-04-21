package com.example.estudantes.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UparArquivoService {
    public String upload(MultipartFile arq) throws IOException{
        String pastaUploads = "src/main/resources/static/uploads/";
        String nomeArq = UUID.randomUUID() + "_" + arq.getOriginalFilename();
        
        Path path = Paths.get(pastaUploads + nomeArq);

        Files.createDirectories(path.getParent());

        Files.copy(arq.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    
        return nomeArq;
    }
}