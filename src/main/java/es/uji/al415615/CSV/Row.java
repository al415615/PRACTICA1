package es.uji.al415615.CSV;

import java.util.List;

public class Row {

    public List<Double> datos;

    public Row(List<Double> datos) {
        this.datos = datos;
    }

    public List<Double> getData(){
        return datos;
    }
}
