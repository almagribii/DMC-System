package org.demo.controller;

import org.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // Untuk mengembalikan respons HTTP
import org.springframework.web.bind.annotation.PostMapping; // Untuk anotasi POST method
import org.springframework.web.bind.annotation.RequestBody; // Untuk membaca body request
import org.springframework.web.bind.annotation.RequestMapping; // Untuk base URL
import org.springframework.web.bind.annotation.RestController; // Untuk menandai kelas ini sebagai REST Controller

// --- Kelas Pembantu untuk Menerima Request Login ---
// Ini adalah POJO yang akan memetakan body JSON dari request POST ke /login
class LoginRequest {
    private String username;
    private String password;

    // Konstruktor default (penting untuk JSON mapping)
    public LoginRequest() {}

    // Konstruktor dengan semua atribut (opsional, tapi bagus)
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters dan Setters (penting untuk JSON mapping)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

@RestController // Anotasi ini menandakan kelas ini sebagai Spring REST Controller
@RequestMapping("/api/auth") // Ini adalah base path untuk semua endpoint di controller ini
public class AuthController {

    private final AuthService authService;

    // Spring akan meng-inject AuthService secara otomatis
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // --- Endpoint Login ---
    @PostMapping("/login") // Anotasi ini memetakan permintaan POST ke URL /api/auth/login
    public ResponseEntity<AuthService.UserAuthResult> login(@RequestBody LoginRequest loginRequest) {
        // Panggil service untuk melakukan autentikasi
        AuthService.UserAuthResult result = authService.authenticateUser(
                loginRequest.getUsername(), // Ambil username dari request body
                loginRequest.getPassword()  // Ambil password dari request body
        );

        if (result.isAuthenticated()) {
            // Jika autentikasi berhasil, kembalikan status HTTP 200 OK
            // Body respons akan berisi objek UserAuthResult yang diubah menjadi JSON
            return ResponseEntity.ok(result);
        } else {
            // Jika autentikasi gagal, kembalikan status HTTP 401 Unauthorized
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
    }
}