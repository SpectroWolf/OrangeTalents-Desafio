package br.com.zup.desafio.services;

import br.com.zup.desafio.helpers.VeiculoHelper;
import br.com.zup.desafio.models.Veiculo;
import br.com.zup.desafio.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void insert(Veiculo veiculo){
        veiculoRepository.save(veiculo);
    }

    public Veiculo find(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).get();
        veiculo.setDisponivel(VeiculoHelper.disponibilidadeVeiculo(veiculo));
        return veiculo;
    }
}
