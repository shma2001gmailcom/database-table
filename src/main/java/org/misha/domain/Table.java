package org.misha.domain;

import java.util.*;

/**
 * author: misha
 * date: 11/21/16
 * time: 9:31 PM
 */
public class Table implements ColumnIterator, RowIterator{
    private final Map<String, TableColumn> columns = new TreeMap<>();
    private final String tableName;
    private final Set<TableRow> rows = new HashSet<>();

    public Table(final String s) {
        tableName = s;
    }

    public TableColumn createColumn(final String columnName, final Class<?> type) {
        final TableColumn result = new TableColumn(columnName, type, this);
        columns.put(columnName, result);
        return result;
    }

    public TableRow createRow() {
        final TableRow tableRow = new TableRow(this);
        rows.add(tableRow);
        return tableRow;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public Iterator<TableRow> rowIterator() {
        return rows.iterator();
    }

    @Override
    public Iterator<Map.Entry<String, TableColumn>> columnIterator() {
        return columns.entrySet().iterator();
    }

    TableColumn get(final String columnName) {
        return columns.get(columnName);
    }

    boolean containsColumn(TableColumn c) {
        return columns.values().contains(c);
    }

    @Override
    public String toString() {
        return tableName + rows;
    }
}
