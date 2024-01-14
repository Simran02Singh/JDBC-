package com.company.com;

import java.sql.Connection;

public class main {
    public static void main(String[] args){

        DbFunctions  db = new DbFunctions();
        Connection conn=db.connect_to_db("test01","postgres","1530");
        //db.CreateTable(conn,"employee");
        //db.insert_row(conn,"employee","Vivek","Mumbai" );
        //db.update_name(conn,"employee","Simran","Akshita");
        db.read_row(conn,"employee");
        //db.search_by_name(conn,"employee","Albert");
        //db.search_by_id(conn,"employee",2);
         //db.delete_by_name(conn,"employee","Albert");
        //db.delete_by_id(conn,"employee",2);
    }
}
