package com.example.recyclerview.model;

public class Compromisso {

    private String titulo;
    private String data;
    private String local;
    private String horario;

    public Compromisso(String titulo, String data, String local, String horario) {
        this.titulo = titulo;
        this.data = data;
        this.local = local;
        this.horario = horario;
    }

    // Getters e Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Compromisso{" +
                "titulo='" + titulo + '\'' +
                ", data='" + data + '\'' +
                ", local='" + local + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
