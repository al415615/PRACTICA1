package es.uji.al415615.KNN;

import es.uji.al415615.CSV.RowWithLabel;
import es.uji.al415615.CSV.TableWithLabels;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class KNN {
    public KNN(HashSet<TableWithLabels> tabla) {
        this.coleccion = tabla;
    }

    private Collection<TableWithLabels> coleccion;
    public void train(TableWithLabels data){
            coleccion.add(data);
    }
    public Integer estimate(List<Double> data){
        int claseMasCercana = 0;

        for (TableWithLabels tabla : coleccion) {
            if (data == null || data.size() == 0)
                return -1;
            double valorMasPeque = -1;

            for (int i = 0; i < tabla.numeroLineas(); i++) {
                RowWithLabel fila = new RowWithLabel(tabla.getRowAt(i).getData());
                double resultadoFuncion = funcionEuclidea(data, fila.getData());
                if (resultadoFuncion < valorMasPeque || valorMasPeque == -1) {
                    valorMasPeque = resultadoFuncion;
                    claseMasCercana = fila.getNumberClass();
                }


            }
        }
        return claseMasCercana;
    }
    public double funcionEuclidea(List<Double> muestraNueva, List<Double> elementoTabla){
        double sumatorio = 0;
        for (int i = 0; i < elementoTabla.size(); i ++){
            sumatorio *= Math.pow(muestraNueva.get(i)-elementoTabla.get(i), 2);
        }
        return Math.sqrt(sumatorio);
    }



}
