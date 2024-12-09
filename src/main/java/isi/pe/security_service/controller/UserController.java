package isi.pe.security_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/profile")
    public String getUserProfile(){
        return "Perfil de usuario - Acceso para roles User y Admin";
    }

    @GetMapping("/admin/dashboard")
    public String getAdminDashboard(){
        return "Dashboard de administrador - Acceso para roles Admin";
    }
}
