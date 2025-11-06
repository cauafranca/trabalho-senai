package com.br.infob.roblox.Roblox.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.infob.roblox.Roblox.models.Usuario;
import com.br.infob.roblox.Roblox.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public Usuario cadastro(@RequestBody Usuario usuario) {
        return usuarioService.cadastro(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean logou = usuarioService.Login(usuario.getEmail(), usuario.getSenha());
        if (logou) {
            return "Login realizado com sucesso";
        }
        return "Email ou senha incorretos";
    }
    
}
