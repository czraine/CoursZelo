package com.example.courszelo.Service;

import com.example.courszelo.entity.DevoirAFaire;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDevoirService {

    void uploadPDF(MultipartFile file);
    byte[] downloadPDF(String devoirId);
    void createDevoirAFaire(DevoirAFaire devoirAFaire, MultipartFile file);
    List<DevoirAFaire> getDevoirsAFaire();
    void submitDevoir(String devoirId, MultipartFile file);
}
