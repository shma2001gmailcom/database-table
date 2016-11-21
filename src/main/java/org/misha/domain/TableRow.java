package org.misha.domain;

import java.util.Map;
import java.util.TreeMap;

/**
 * author: misha
 * date: 11/21/16
 * time: 11:10 PM
 */
public class TableRow {
    private final Table table;
    private final Map<TableColumn, Object> rawRow = new TreeMap<>();

    TableRow(final Table t) {
        table = t;
    }

    private void set(final TableColumn column, final Object value) {
        if (!table.containsColumn(column)) {
            throw new IllegalArgumentException("no such column");//todo:fixme
        }
        if (!column.getType().isAssignableFrom(value.getClass())) {
            throw new IllegalArgumentException("incompatible types");//todo:fixme
        }
        rawRow.put(column, value);
    }

    private Object get(final TableColumn tableColumn) {
        return rawRow.get(tableColumn);
    }

    Object get(final String columnName) {
        return get(table.get(columnName));
    }

    public void set(final String columnName, final Object value) {
        set(table.get(columnName), value);
    }

    @Override
    public String toString() {
        return "\n" + rawRow;
    }
}
