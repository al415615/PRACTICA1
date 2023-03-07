package CSV;

import es.uji.al415615.CSV.CSV;
import es.uji.al415615.CSV.RowWithLabel;
import org.junit.jupiter.api.DisplayName;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Test número de filas")
    void numeroFilas() throws FileNotFoundException {
        CSV dinero = new CSV();
        assertEquals(25, dinero.readTable("src/main/resources/miles_dollars.csv").numeroLineas());

        CSV flores = new CSV();
        assertEquals(150, flores.readTablewithLabels("src/main/resources/iris.csv").numeroLineas());

        CSV archivoVacio = new CSV();
        assertEquals(0, archivoVacio.readTable("src/main/resources/vacio.csv").numeroLineas());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test número de columnas")
    void numeroColumnas() throws FileNotFoundException {
        CSV dinero = new CSV();
        try {
            assertEquals(2, dinero.readTable("src/main/resources/miles_dollars.csv").numeroColumnas());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CSV flores = new CSV();
        assertEquals(4, flores.readTablewithLabels("src/main/resources/iris.csv").numeroColumnas());

        CSV archivoVacio = new CSV();
        assertEquals(0, archivoVacio.readTable("src/main/resources/vacio.csv").numeroColumnas());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test nombre de etiquetas")
    void nombreEtiquetas() throws FileNotFoundException {

        List<String> listaDinero =  new ArrayList<>();
        listaDinero.add("Miles");
        listaDinero.add("Dollars");

        CSV dinero = new CSV();
        try {
            assertEquals(listaDinero, dinero.readTable("src/main/resources/miles_dollars.csv").mostrarCabecera());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<String> listaFlores =  new ArrayList<>();
        listaFlores.add("sepal length");
        listaFlores.add("sepal width");
        listaFlores.add("petal length");
        listaFlores.add("petal width");

        CSV flores = new CSV();
        try {
            assertEquals(listaFlores, flores.readTablewithLabels("src/main/resources/iris.csv").mostrarCabecera());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CSV archivoVacio = new CSV();
        assertEquals(new ArrayList<>(), archivoVacio.readTable("src/main/resources/vacio.csv").mostrarCabecera());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test 4 ")
        // añadir numero random para test 4
    void numeroFilaAsignado() throws FileNotFoundException {


        //Test con la primera línea

        CSV flores = new CSV();
        assertEquals(1,flores.readTablewithLabels("src/main/resources/iris.csv").getRowAt(0).getNumberClass() );

        //Test con la ultima línea

        assertEquals(3,flores.readTablewithLabels("src/main/resources/iris.csv").getRowAt(149).getNumberClass() );

        CSV archivoVacio = new CSV();
        assertEquals(0,archivoVacio.readTablewithLabels("src/main/resources/vacio.csv").getRowAt(0).getNumberClass() ) ;

    }
    @org.junit.jupiter.api.Test
    @DisplayName("Test 5")

    void Test5() throws FileNotFoundException {

        //Test con la primera línea
        List<Double> filaDineroPrimera = new ArrayList<>();
        filaDineroPrimera.add(1211.0);
        filaDineroPrimera.add(1802.0);


        CSV dinero = new CSV();
        assertEquals(filaDineroPrimera, dinero.readTable("src/main/resources/miles_dollars.csv").getRowAt(0).getData());

        //Test con la última línea
        List<Double> filaDineroUltima = new ArrayList<>();
        filaDineroUltima.add(5439.0);
        filaDineroUltima.add(6964.0);

        assertEquals(filaDineroUltima, dinero.readTable("src/main/resources/miles_dollars.csv").getRowAt(24).getData());

        //Test con la primera línea
        List<Double> filaFloresPrimera = new ArrayList<>();
        filaFloresPrimera.add(5.1);
        filaFloresPrimera.add(3.5);
        filaFloresPrimera.add(1.4);
        filaFloresPrimera.add(0.2);

        RowWithLabel floresPrimera = new RowWithLabel(filaFloresPrimera, 1);


        CSV flores = new CSV();
        assertEquals(floresPrimera.compareTo(flores.readTablewithLabels("src/main/resources/iris.csv").getRowAt(0)), true);

        //Test con la ultima línea
        List<Double> filaFloresUltima = new ArrayList<>();
        filaFloresUltima.add(5.9);
        filaFloresUltima.add(3.0);
        filaFloresUltima.add(5.1);
        filaFloresUltima.add(1.8);

        RowWithLabel floresUltima = new RowWithLabel(filaFloresUltima, 3);

        assertEquals(floresUltima.compareTo(flores.readTablewithLabels("src/main/resources/iris.csv").getRowAt(149)), true);

        CSV archivoVacio = new CSV();
        assertEquals(new ArrayList<>(), archivoVacio.readTable("src/main/resources/vacio.csv").getRowAt(0).getData());

    }






}