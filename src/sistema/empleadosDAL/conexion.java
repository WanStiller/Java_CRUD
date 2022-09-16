/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.empleadosDAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Burro Malvado
 */
public class conexion {
 
        String strConexionDB="jdbc:sqlite:C:/Users/Burro Malvado/Documents/bd/sistema.s3db";
        Connection conn= null;
        
        public conexion (){
            try {
                Class.forName("org.sqlite.JDBC");
                conn= DriverManager.getConnection(strConexionDB);
                System.out.println("Conection successful");
            } catch (Exception e) {
                System.out.println("Conection failded"+e);
            }
        }
        
        public int ejecutarSentenciaSQL (String strSentenciaSQL){
            
            try {
                PreparedStatement pstm= conn.prepareStatement(strSentenciaSQL);
                pstm.execute();
                return 1;
            } catch (SQLException e) {
                System.out.println(e);
                return 0;
            }
        
        }
}
