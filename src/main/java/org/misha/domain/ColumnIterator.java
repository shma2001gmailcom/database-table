package org.misha.domain;

import java.util.Iterator;
import java.util.Map;

/**
 * author: misha
 * date: 11/21/16
 * time: 10:11 PM
 */
interface ColumnIterator {

    public Iterator<Map.Entry<String, TableColumn>> columnIterator();
}
