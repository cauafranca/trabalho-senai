package com.br.infob.roblox.Roblox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.infob.roblox.Roblox.models.Endereco;
import com.br.infob.roblox.Roblox.repositories.EnderecoRepository;


@Service
public class EnderecoService {

    @Autowired
    public EnderecoRepository enderecoRepository;

      
    public Endereco buscar(Integer id) {
        return enderecoRepository.findById(id).get();
    }

        
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
 
   


}
