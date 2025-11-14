package com.br.infob.roblox.Roblox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.infob.roblox.Roblox.models.Usuario;
import com.br.infob.roblox.Roblox.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;
 
    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (email.equals(usuario.getEmail()) && senha.equals(usuario.getSenha())) {
            return "Login efetuado com sucesso";
        }
        return "falha ao realizar o acesso";
    }
    
    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    

    public Usuario salvar(Usuario usuario, String confSenha) {
        if(usuario.getSenha().equals(confSenha)) {
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario buscar(Integer id) {
            return usuarioRepository.findById(id).get();
    }

    public boolean atualizarBoolean(Usuario usuario, Integer id) {
            if (usuarioRepository.existsById(id)) {
                usuario.setId(id);
                usuarioRepository.save(usuario);
                return true;
            }
            
            return false;
        }

}
