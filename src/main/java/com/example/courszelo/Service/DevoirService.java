package com.example.courszelo.Service;

import com.example.courszelo.Repository.DevoirAFaireRepository;
import com.example.courszelo.Repository.DevoirRepository;
import com.example.courszelo.entity.Devoir;
import com.example.courszelo.entity.DevoirAFaire;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@AllArgsConstructor
public class DevoirService  implements IDevoirService{
    private final DevoirRepository devoirRepository;
    private final DevoirAFaireRepository devoirAFaireRepository;


    @Override
    public void uploadPDF(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("Fichier vide");
            }

            Devoir devoir = new Devoir();

            String uploadDir = "./uploads/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            devoir.setCheminFichierPDF(filePath.toString());
            devoirRepository.save(devoir);

        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du téléversement du fichier", e);
        }
    }

    @Override
    public byte[] downloadPDF(String devoirId) {
        // Récupérez l'entité Devoir correspondant à l'ID
        Devoir devoir = devoirRepository.findById(devoirId)
                .orElseThrow(() -> new IllegalArgumentException("Devoir non trouvé"));

        try {
            // Lisez le contenu du fichier PDF et renvoyez-le en tant que tableau d'octets
            Path filePath = Paths.get(devoir.getCheminFichierPDF());
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du téléchargement du fichier", e);
        }
    }

    @Override
    public void createDevoirAFaire(DevoirAFaire devoirAFaire, MultipartFile file) {
        devoirAFaireRepository.save(devoirAFaire);
    }

    @Override
    public List<DevoirAFaire> getDevoirsAFaire() {
        return devoirAFaireRepository.findAll();
    }

    @Override
    public void submitDevoir(String devoirId, MultipartFile file) {
        Devoir devoir = devoirRepository.findById(devoirId)
                .orElseThrow(() -> new IllegalArgumentException("Devoir non trouvé"));

        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("Fichier vide");
            }

            String uploadDir = "./uploads/";
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);

            // Mettez à jour le chemin du fichier du devoir soumis
            devoir.setCheminFichierPDF(filePath.toString());
            devoirRepository.save(devoir);

        } catch (IOException e) {
            throw new RuntimeException("Erreur lors du téléversement du fichier", e);
        }
    }
}
