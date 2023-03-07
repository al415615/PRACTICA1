package es.uji.al415615.CSV;

import java.util.List;

public class RowWithLabel extends Row {

    private int numberClass;

    public RowWithLabel(List<Double> datos) {
        super(datos);
    }

    public RowWithLabel(List<Double> datos, int numberClass) {
        super(datos);
        this.numberClass = numberClass;
    }
    public boolean compareTo(RowWithLabel otro){
        int contador = 0;
        for (Double campo : datos){
            if (!campo.equals(otro.getData().get(contador))){
                return false;
            }
            contador++;
        }
        return true;
    }
    public int setNumberClass(int numero){
        numberClass = numero;
        return numero;
    }
    public int getNumberClass(){
        return numberClass;
    }
}
