package CSV;

import es.uji.al415615.CSV.CSV;
import es.uji.al415615.KNN.KNN;
import es.uji.al415615.CSV.TableWithLabels;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    @Test
    @DisplayName("Test estimación")
    void estimateTest() throws FileNotFoundException {
        CSV flores = new CSV();
        HashSet<TableWithLabels> coleccion = new HashSet<>();

        KNN prueba =  new KNN(coleccion);
        prueba.train(flores.readTablewithLabels("src/main/resources/iris.csv"));
        List<Double> filaFlores1 = new ArrayList<>();
        filaFlores1.add(5.1);
        filaFlores1.add(3.5);
        filaFlores1.add(1.4);
        filaFlores1.add(0.2);
        filaFlores1.add(0.0);

        assertEquals(0, prueba.estimate(filaFlores1));
        assertEquals(-1, prueba.estimate(null));

        assertEquals(-1, prueba.estimate(new ArrayList<>()));


    }

    @Test
    @DisplayName("Test función Euclidea")
    void funcionEuclideaTest() throws FileNotFoundException {
        CSV flores = new CSV();
        HashSet<TableWithLabels> coleccion = new HashSet<>();
        coleccion.add(flores.readTablewithLabels("src/main/resources/iris.csv"));
        KNN prueba =  new KNN(coleccion);

        List<Double> filaFlores1 = new ArrayList<>();
        filaFlores1.add(5.1);
        filaFlores1.add(3.5);
        filaFlores1.add(1.4);
        filaFlores1.add(0.2);
        filaFlores1.add(0.0);
        assertEquals(0.0, prueba.funcionEuclidea(filaFlores1, filaFlores1));

        List<Double> filaFlores2 = new ArrayList<>();
        filaFlores2.add(4.9);
        filaFlores2.add(3.0);
        filaFlores2.add(1.4);
        filaFlores2.add(0.2);
        filaFlores2.add(0.0);

        assertEquals(0.54, Math.round(prueba.funcionEuclidea(filaFlores1, filaFlores2)),2);



    }


}