package es.uji.al415615.CSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    public TableWithLabels(List<String> headers, List<Row> datos, Map<String, Integer> labelsToIndex) {
        super(headers, datos);
        this.labelsToIndex = labelsToIndex;
    }

    private Map<String, Integer> labelsToIndex;


    public RowWithLabel getRowAt (int rowNumber){
        if (datos.size() == 0)
            return new RowWithLabel(new ArrayList<>());
        return (RowWithLabel) datos.get(rowNumber);
    }

}
