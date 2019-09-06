package com.example.aula2;

import java.util.HashMap;
import java.util.Map;

public class Notas {

    private double nota;
    private String name;
    private String email;
    private String phone;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getNota() {
        return nota;
    }

    public void setId(Integer nota) {
        this.nota = nota;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}