package com.example.administrador.agepubli;

/**
 * Created by pali on 30/09/15.
 */
public class ListOpciones {
    private static final String TAG = "Opciones";

    private String id;
    private String option;
    private String value;

    public ListOpciones(String id, String option, String value) {
        this.id = id;
        this.option = option;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
