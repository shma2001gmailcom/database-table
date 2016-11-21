package org.misha;

import org.misha.domain.Table;
import org.misha.domain.TableRow;

/**
 * author: misha
 * date: 11/21/16
 * time: 9:29 PM
 */
public class Launcher {
    public static void main(String... args) {
        Table table = new Table("TABLE");
        table.createColumn("ID", Integer.class);
        table.createColumn("NAME", String.class);
        TableRow row1 = table.createRow();
        row1.set("ID", 0);
        row1.set("NAME", "Bob");
        row1 = table.createRow();
        row1.set("ID", 1);
        row1.set("NAME", "Liz");
        System.out.println(table);

    }
}
