package es.uji.al415615.CSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CSV {
    public Table readTable(String nombre) throws FileNotFoundException {



            Scanner sc = new Scanner(new File(nombre));
            List<String> cabecera = new ArrayList<>();

            if (sc.hasNextLine()) {
                String linea = sc.nextLine();
                cabecera = Arrays.asList(linea.split(","));


            }

            List<Row> filas = new ArrayList<>();


            while (sc.hasNextLine()) {
                List<Double> datos = new ArrayList<>();
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                for (int i = 0; i < campos.length; i++) {
                    datos.add(Double.parseDouble(campos[i]));

                }
                filas.add(new Row(datos));

            }
            Table tabla = new Table(cabecera, filas);
            sc.close();
            return tabla;
    }

    public TableWithLabels readTablewithLabels(String nombre) throws FileNotFoundException {

            Scanner sc = new Scanner(new File(nombre));

            List<String> cabecera = new ArrayList<>();
            if (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                for (int i = 0 ; i < campos.length - 1; i++){
                    cabecera.add(campos[i]);
                }

            }

            List<Row> filas = new ArrayList<>();
            Map<String, Integer> mapa = new HashMap<>();


            while (sc.hasNextLine()) {
                List<Double> datos = new ArrayList<>();
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                int indice = 0;
                for (int i = 0; i < campos.length; i++) {
                    if (i == campos.length - 1) {
                        indice = devuelveIndice(campos[i], mapa);
                    } else
                        datos.add(Double.parseDouble(campos[i]));


                }

                RowWithLabel fila = new RowWithLabel(datos,indice);
                filas.add(fila);
            }

                TableWithLabels tabla = new TableWithLabels(cabecera, filas, mapa);
                sc.close();
                return tabla;

    }


    public int devuelveIndice(String clase, Map<String, Integer> mapa){
        if(!mapa.containsKey(clase))
            mapa.put(clase, mapa.size() + 1);
        return mapa.get(clase);
    }




}




