package br.com.zup.desafio.models;

import javax.persistence.*;


@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "MODELO")
    private String veiculo;

    @Column(name = "ANO")
    private String ano_modelo;

    @Column(name = "VALOR")
    private String preco;

    @Column(name = "DISPONIVEL")
    private boolean disponivel;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String modelo) {
        this.veiculo = modelo;
    }

    public String getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(String ano) {
        this.ano_modelo = ano;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
