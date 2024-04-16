package com.example.courszelo.Controller;

import com.example.courszelo.Service.DevoirService;
import com.example.courszelo.entity.DevoirAFaire;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/Devoirs")
public class DevoirController {

    private final DevoirService devoirService;

    @PostMapping("/pdf")
    public ResponseEntity<?> uploadPDF(@RequestParam("file") MultipartFile file) {
        devoirService.uploadPDF(file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{devoirId}/pdf")
    public ResponseEntity<byte[]> downloadPDF(@PathVariable String devoirId) {
        byte[] pdfBytes = devoirService.downloadPDF(devoirId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
    }

    @PostMapping("/create-afaire")
    public ResponseEntity<?> createDevoirAFaire(@RequestBody DevoirAFaire devoirAFaire, @RequestParam("file") MultipartFile file) {
        devoirService.createDevoirAFaire(devoirAFaire, file);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/afaire")
    public ResponseEntity<List<DevoirAFaire>> getDevoirsAFaire() {
        List<DevoirAFaire> devoirsAFaire = devoirService.getDevoirsAFaire();
        return ResponseEntity.ok().body(devoirsAFaire);
    }

    @PostMapping("/{devoirId}/submit")
    public ResponseEntity<?> submitDevoir(@PathVariable String devoirId, @RequestParam("file") MultipartFile file) {
        devoirService.submitDevoir(devoirId, file);
        return ResponseEntity.ok().build();
    }
}
