package com.profile.demo.service;

import com.profile.demo.model.Usuario;
import com.profile.demo.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public Usuario salvaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getByIdUsuario(Integer codUsuario) {
        return usuarioRepository.findById(codUsuario);
    }

    @Override
    public Usuario atualizaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteByIdUsuario(Integer codUsuario) {
        usuarioRepository.deleteById(codUsuario);
    }    
}
