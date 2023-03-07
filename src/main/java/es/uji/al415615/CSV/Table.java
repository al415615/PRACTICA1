package es.uji.al415615.CSV;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    public List<Row> datos;

    public Table(List<String> headers, List<Row> datos) {
        this.headers = headers;
        this.datos = datos;
    }

    public int numeroLineas(){
        int lineas = 0;

        for (Row dato : datos){
            lineas++;
        }

        return lineas;
    }
    public int numeroColumnas(){
        return headers.size();
    }

    public List<String> mostrarCabecera(){
        return headers;
    }




    public Row getRowAt(int rowNumber){
        if (datos.size() == 0)
            return new Row(new ArrayList<>());
        return datos.get(rowNumber);
    }
    public List<Double> mostrarFila(int rowNumber){
        return datos.get(rowNumber).getData();
    }

    // este método no lo uso
    public Row addRow(List<Double> campos){
        Row fila = new Row(campos);
        datos.add(fila);
        return fila;
    }




}
