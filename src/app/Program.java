package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
    
    public static void main(String[] args) {       

        //********* O código abaixo está buscando os dados no banco postgresSQL. **********
        
        // Connection conn = null;
        // Statement st = null;
        // ResultSet rs = null;

        // try{
        //     conn = DB.getConnection();
        //     st = conn.createStatement();
        //     rs = st.executeQuery("select * from department");

        //     while(rs.next()){
        //         System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
        //     }
        // }
        // catch(SQLException e){
        //     e.printStackTrace();
        // }
        // finally{
        //     DB.closeStatement(st);
        //     DB.closeResutSet(rs);
        //     DB.closeConnection();

        // }

        //******** O código abaixo ira realizar uma inserção de dados do banco postgresSQL. ********

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO seller(Name, Email, BirthDate, BaseSalary, DepartmentId)"
            + "values(?, ?, ?, ?, ?)");

            //******** Vamos inserir os valores nesse momento. ********** 

            st.setString(1, "Thaynara Souza");
            st.setString(2, "thaynara@gmail.com");
            st.setDate(3, new Date(sdf.parse("28/08/1994").getTime()));
            st.setDouble(4, 7500);
            st.setInt(5, 1);

            int line = st.executeUpdate();
            System.out.println("Linhas afetadas: " + line);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
