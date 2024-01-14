package com.company.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {
    public Connection connect_to_db(String dbname,String user,String pass) {

        Connection connection=null;

        try {
            Class.forName("org.postgresql.Driver");
            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);

            if (connection!=null){
                System.out.println("Connection is good");
            }
            else {
                System.out.println("connection failed :(");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return connection;
    }
    public void CreateTable(Connection conn, String Table_name)
    {
        Statement statement;
        try {
            String query="create Table "+ Table_name +" (empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void insert_row(Connection conn,String Table_name,String name,String address)
    {
        Statement statement;
        try {
            String query=String.format("insert into %s(name,address) values('%s','%s');",Table_name,name,address);
            statement =conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Created");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void read_row(Connection conn,String Table_name)
    {
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("Select * from %s",Table_name);
            statement= conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next())
            {
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void update_name(Connection conn,String Table_name,String old_name,String new_name)
    {
        Statement statement;
        try {
            String query=String.format("update %s set name='%s' where name='%s'", Table_name,new_name,old_name);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Upadted");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void search_by_name(Connection conn,String Table_name,String name)
    {
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("Select * from %s where name='%s'",Table_name,name);
            statement= conn.createStatement();;
            rs=statement.executeQuery(query);
            while (rs.next())
            {
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void search_by_id(Connection conn,String Table_name,int id)
    {
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("Select * from %s where empid=%s",Table_name,id);
            statement= conn.createStatement();;
            rs=statement.executeQuery(query);
            while (rs.next())
            {
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address")+" ");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void delete_by_name(Connection conn,String Table_name,String name)
    {
        Statement statement;
        try {
            String query=String.format("delete from %s where name='%s'",Table_name,name);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void delete_by_id(Connection conn,String Table_name,int id)
    {
        Statement statement;
        try {
            String query=String.format("delete from %s where name=%s",Table_name,id);
            statement= conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
