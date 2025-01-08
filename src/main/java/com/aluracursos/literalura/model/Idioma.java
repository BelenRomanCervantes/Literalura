package com.aluracursos.literalura.model;

public enum Idioma {
    ESPANIOL("es", "Español"),
    INGLES("en", "Inglés"),
    PORTUGUES("pt","Portugués"),
    FRANCES("fr","Francés"),
    ITALIANO("it", "Italiano"),
    ALEMAN("de", "Alemán");

    private String idiomaGutendex;
    private String idiomaEspanol;

    Idioma (String idiomaGutendex, String idiomaEspanol){
        this.idiomaGutendex = idiomaGutendex;
        this.idiomaEspanol = idiomaEspanol;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaGutendex.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    @Override
    public String toString() {
        return idiomaEspanol;
    }
}
