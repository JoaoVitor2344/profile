package com.profile.demo.controller;

import com.profile.demo.model.Usuario;
import com.profile.demo.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api("Api Usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioServices;

    @GetMapping("/usuarios")
    @ApiOperation("Obter Usuários")
    @ApiResponses({
        @ApiResponse(code=200,message="Usuários encontrado"),
        @ApiResponse(code=404,message="Usuários não encontrado")
    })
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServices.listaUsuarios());
    }

    @GetMapping("usuario/{codusuario}")
    @ApiOperation("Obter Usuário")
    @ApiResponses({
        @ApiResponse(code=200,message="Usuários encontrado"),
        @ApiResponse(code=404,message="Usuários não encontrado")
    })
    public ResponseEntity<Optional<Usuario>> getByIdUsuario(@PathVariable Integer codusuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServices.getByIdUsuario(codusuario));
    }

    @PostMapping("usuario")
    @ApiOperation("Cadastrar Fornecedor")
    @ApiResponses({
        @ApiResponse(code=200,message="Fornecedor cadastrado"),
        @ApiResponse(code=404,message="Não foi possivel cadastrar o fornecedor")
    })
    public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServices.salvaUsuario(usuario));
    }

    @PutMapping("usuario")
    @ApiOperation("Atualizar Usuario")
    @ApiResponses({
        @ApiResponse(code=200,message="Usuario atualizado"),
        @ApiResponse(code=404,message="Não foi possivel atualizar o usuario")
    })
    public ResponseEntity<Usuario> atualizaUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioServices.atualizaUsuario(usuario));
    }

    @DeleteMapping("usuario/{codusuario}")
    @ApiOperation("Remover Usuário")
    @ApiResponses({
        @ApiResponse(code=200,message="Usuário removido"),
        @ApiResponse(code=404,message="Não foi possivel remover o usuário")
    })
    public ResponseEntity<String> deleteByIdUsuario(@PathVariable Integer codusuario){
        usuarioServices.deleteByIdUsuario(codusuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário removido com sucesso");
    }
}
