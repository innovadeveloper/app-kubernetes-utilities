package com.innovaappstar.kubernetes.utility.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class PersistentVolumeTableModel extends AbstractTableModel {
    private List<String[]> data;
    private List<String[]> filteredData;

    public PersistentVolumeTableModel() {
        data = new ArrayList<>();
        filteredData = new ArrayList<>();
    }

    public void addRow(String[] rowData) {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeRow(int rowIndex) {
        data.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void clear() {
        data.clear();
        filteredData.clear();
    }

    public void filterData(String filterText, boolean filterByNamespace) {
        filteredData.clear();

        for (String[] rowData : data) {
            String namespace = rowData[0];
            String name = rowData[1];
            if(filterByNamespace && namespace.toLowerCase().contains(filterText.toLowerCase())){
                filteredData.add(rowData);
            }else if(!filterByNamespace && name.toLowerCase().contains(filterText.toLowerCase())){
                filteredData.add(rowData);
            }
        }

        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return filteredData.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rowData = filteredData.get(rowIndex);
        return rowData[columnIndex];
    }
}

