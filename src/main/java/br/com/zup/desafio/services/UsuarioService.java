package br.com.zup.desafio.services;

import br.com.zup.desafio.helpers.VeiculoHelper;
import br.com.zup.desafio.models.Usuario;
import br.com.zup.desafio.models.Veiculo;
import br.com.zup.desafio.repositories.UsuarioRepository;
import br.com.zup.desafio.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    VeiculoRepository veiculoRepository;

    public void insert(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario find(Long id){
        Usuario usuario = usuarioRepository.findById(id).get();

        if(usuario.getVeiculos().size() > 0 )
           usuario.setVeiculos(VeiculoHelper.disponibilidadeVeiculos(usuario.getVeiculos()));

        return usuario;
    }

    public void vincular(Long userId, Long veiculoId){
        Usuario usuario = this.find(userId);
        Veiculo veiculo = veiculoRepository.findById(veiculoId).get();
        usuario.addVeiculo(veiculo);
        this.insert(usuario);
    }
}
