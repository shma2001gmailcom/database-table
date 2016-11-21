package org.misha.domain;

/**
 * author: misha
 * date: 11/21/16
 * time: 11:10 PM
 */
public class TableColumn implements Comparable<TableColumn> {
    private final String columnName;
    private final Class<?> type;


    TableColumn(final String s, final Class<?> c, final Table t) {
        columnName = s;
        type = c;
    }

    Class<?> getType() {
        return type;
    }

    @Override
    public int compareTo(final TableColumn o) {
        return columnName.compareTo(o.columnName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TableColumn that = (TableColumn) o;
        return columnName.equals(that.columnName) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = columnName.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(type).replaceFirst("class ", "") + ") " + columnName;
    }
}
