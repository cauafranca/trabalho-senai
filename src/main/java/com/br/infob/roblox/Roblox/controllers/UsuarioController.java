package com.br.infob.roblox.Roblox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/buscar/{id}")
    public Usuario buscarId(@PathVariable Integer id) {
        return usuarioService.buscar(id);
    }

    @PutMapping("atualizar-boolean{id}")
    public String atualizarBoolean(@PathVariable Integer id, @RequestBody Usuario usuario) {
        boolean atualizou = usuarioService.atualizarBoolean(usuario, id);
        if (atualizou) {
             return "Atualização completa dos usuario";
        }
        return "falha ao atualizar os usuario";
    }


    
}
