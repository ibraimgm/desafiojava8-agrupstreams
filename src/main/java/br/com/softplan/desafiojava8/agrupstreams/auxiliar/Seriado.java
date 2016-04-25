package br.com.softplan.desafiojava8.agrupstreams.auxiliar;

public class Seriado {
    private String titulo;
    private Integer ano;
    private Integer numeroEpisodios;
    private Boolean exibidoNoBrasil;

    public Seriado(String titulo, Integer ano, Integer numeroEpisodios, Boolean exibidoNoBrasil) {
        super();
        this.titulo = titulo;
        this.ano = ano;
        this.numeroEpisodios = numeroEpisodios;
        this.exibidoNoBrasil = exibidoNoBrasil;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(Integer numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public Boolean getExibidoNoBrasil() {
        return exibidoNoBrasil;
    }

    public void setExibidoNoBrasil(Boolean exibidoNoBrasil) {
        this.exibidoNoBrasil = exibidoNoBrasil;
    }

}
