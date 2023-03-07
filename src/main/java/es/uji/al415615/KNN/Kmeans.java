package es.uji.al415615.KNN;

import es.uji.al415615.CSV.Row;
import es.uji.al415615.CSV.RowWithLabel;
import es.uji.al415615.CSV.Table;
import es.uji.al415615.CSV.TableWithLabels;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kmeans {

    private int numClusters;
    private int numIterations;

    private Random random;

    public Kmeans(int numClusters, int numIterations, long seed){
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.random = new Random(seed);
    }
//    public void train(Table datos){
//
//        int numLineas = datos.numeroLineas();
//
//        //hacemos centroides aleatorias
//        int contador = 0;
//        List<Row> representantes = new ArrayList<>();
//
//        while (contador < numClusters){
//            int numero = random.nextInt(0, numLineas-1);
//            Row representante = datos.getRowAt(numero);
//            if(!representantes.contains(representante)){
//                representantes.add(representante);
//                contador++;
//            }
//        }
//
//        //hacemos asignaciones
//        for (int i= 0; i < numLineas; i++ ){
//            int claseMasCercana = 0;
//
//            double valorMasPeque = -1;
//
//            for (int i = 0; i < datos.numeroColumnas(); i++) {
//                RowWithLabel fila = new RowWithLabel(datos.getRowAt(i).getData());
//                double resultadoFuncion = funcionEuclidea(data, fila.getData());
//                    if (resultadoFuncion < valorMasPeque || valorMasPeque == -1) {
//                        valorMasPeque = resultadoFuncion;
//                        claseMasCercana = fila.getNumberClass();
//                    }
//
//
//                }
//            }
//        }
//
//
//
//    }
//    public Integer estimate(List<Double> dato){
//
//    }
//
//    public double funcionEuclidea(List<Double> muestraNueva, List<Double> elementoTabla){
//        double sumatorio = 0;
//        for (int i = 0; i < elementoTabla.size(); i ++){
//            sumatorio *= Math.pow(muestraNueva.get(i)-elementoTabla.get(i), 2);
//        }
//        return Math.sqrt(sumatorio);
//    }
}
