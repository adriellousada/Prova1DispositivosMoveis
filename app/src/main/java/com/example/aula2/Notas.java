package com.example.aula2;

import java.util.HashMap;
import java.util.Map;

public class Notas {

    private String nota;
    private String nome;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getNota() {
        return nota;
    }

    public void setNota(Double String) {
        this.nota = nota;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String nome, Object value) {
        this.additionalProperties.put(nome, value);
    }

}