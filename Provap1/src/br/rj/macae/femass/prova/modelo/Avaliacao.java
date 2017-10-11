/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.prova.modelo;

/**
 *
 * @author YMoraes
 */
public class Avaliacao {
    private int id;
    private String nome;
    private Double massa;
    private Double estatura;
    private Integer idade;
    private String sexo;
    private Double imc;

    public Avaliacao() {
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double estatura, Double massa) {
        this.imc = this.massa/(this.estatura*this.estatura);
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getMassa() {
        return massa;
    }

    public Double getEstatura() {
        return estatura;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMassa(Double massa) {
        this.massa = massa;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String classificaIMC(String sexo, Double imc){
        if(this.sexo=="Masculino"){
            if(this.imc>43){
                return "Obesidade mórbida";
            }
            if(this.imc>30&&this.imc<39.9){
                return "Obesidade moderada";
            }
            if(this.imc>25&&this.imc<29.9){
                return "Obesidade leve";
            }
            if(this.imc>20&&this.imc<24.9){
                return "Normal";
            }
            if(this.imc<20){
                return "Abaixo do normal";
            }
        }
        if(this.sexo=="Feminino"){
            if(this.imc>39){
                return "Obesidade mórbida";
            }
            if(this.imc>29&&this.imc<38.9){
                return "Obesidade moderada";
            }
            if(this.imc>24&&this.imc<28.9){
                return "Obesidade leve";
            }
            if(this.imc>19&&this.imc<23.9){
                return "Normal";
            }
            if(this.imc<19){
                return "Abaixo do normal";
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return this.nome+" | IMC: "+String.format("%.2f", imc)+classificaIMC(this.getSexo(),this.getImc());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
