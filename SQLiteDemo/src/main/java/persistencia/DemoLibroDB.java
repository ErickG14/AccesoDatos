package persistencia;

import Modelo.Libro;

import java.sql.*;
import java.util.ArrayList;

public class DemoLibroDB {
    public DemoLibroDB() {
    }

    public void insertarStatement(){
        String eltitulo = "Arrancame la vida";
        String elautor = "Angeles Metreta";

        try {
            Statement stm = ConexionSingleton.getInstance("LibrosDB2.db").getConnection().createStatement();
            String sqlInset = "INSET INTO Libros(titulo,autor) VALUES('"+eltitulo+"','"+elautor+"')";
           int rowCount =  stm.executeUpdate(sqlInset);
            System.out.println("se insertaron" + rowCount + "registros");

        }catch (SQLException sqle){
            System.out.println("Error al conectar" + sqle.getMessage());
        }


    }

    public void insertaPreparedStatement(){

        String eltitulo = "El principito";
        String elautor = "Antonie de saint-exupery";
        String sqlInset = "INSERT INTO Libros(titulo,autor) VALUES(?,?)";

         try {
             PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB2.db").getConnection().prepareStatement(sqlInset);
             pstm.setString(1,eltitulo);
             pstm.setString(2,elautor);
             int rowCount = pstm.executeUpdate();
             System.out.println("se insertaron" + rowCount + "registros");

         }catch (SQLException sqle){
             System.out.println("Erros perpared statement" + sqle.getMessage());
         }

    }

    public boolean insertarLibro(Libro Libro){

        String sqlInset = "INSERT INTO Libros(titulo,autor) VALUES(?,?)";
        int rowCount = 0;


        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB2.db").getConnection().prepareStatement(sqlInset);
            pstm.setString(1, Libro.getTitulo());
            pstm.setString(2, Libro.getAutor());
             rowCount = pstm.executeUpdate();
            System.out.println("se insertaron" + rowCount + "registros");

        }catch (SQLException sqle){
            System.out.println("Erros perpared statement" + sqle.getMessage());
        }
        return rowCount > 0;


    }


    public Libro buscarlibroporid(int id){
        String sql = "SELECT * FROM Libro WHERE id = ?;";
        Libro libro = null;

        try {
            PreparedStatement pstm = ConexionSingleton.getInstance("LibrosDB2.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                libro = new Libro(rst.getInt(1),rst.getString(2),rst.getString(3));
            }

        }catch (SQLException sqle){
            System.out.println("Error al buscar");
        }
        return libro;

    }

    public ArrayList<Libro> obtenerTodos(){
        String sql = "SELECT  * FROM Libros ";
        ArrayList<Libro> resultado = new ArrayList<>();

        try {
            Statement snt = ConexionSingleton.getInstance("LibrosDB2.db").getConnection().prepareStatement();
            ResultSet rst = snt.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Libro(rst.getInt(1),rst.getString(2),rst.getString(3)));


            }

        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;

    }

}
