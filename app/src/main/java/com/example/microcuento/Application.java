package com.example.microcuento;

/**
 * Creamos esta clase para almacenar el dato que vanmos a compatir entre los activity
 * importante debemos indicar en el manifest que esta clase es la que va a ser la
 * aplication principal de la app y lo hacemos añaadiendo el atributo android:name
 */
public class Application extends android.app.Application {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
