package org.example;

import Modelo.Libro;
import persistencia.DemoLibroDB;
import persistencia.LibroDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
      //  DemoLibroDB demo = new DemoLibroDB();
       // demo.insertarStatement();
       // System.out.println("Con prepared");
        // demo.insertaPreparedStatement();

       // Libro libro = new Libro(0 ,"Eljuego" , "DESCONOCIDO");

     //   if (demo.insertarLibro(libro)){
       //     System.out.println("Se inserto correctamente");
        //}else {
          //  System.out.println("No se inserto correctamente");
        //}

       // System.out.println(demo.buscarlibroporid(6));

       // System.out.println("--------------------------------------------------------------");

        //for (Libro tmp: demo.obtenerTodos()){
          //  System.out.println("Libro" + tmp);
        //}

     //   LibroDAO ldao = new LibroDAO();
       // Libro libro = new Libro(0, "Piensa en java", "Bruce Eckel");

       // try {
         //  if (ldao.insertar(libro)){
         //      System.out.println("Se inserto correctamente ");

         //  }else {
         //      System.out.println("No se pudo insertar");
         //  }
       // }catch (SQLException sqle){
         //   System.out.println("Error al insertar");
       // }


        LibroDAO ldao = new LibroDAO();
        try {
            Libro res = (Libro) ldao.buscarPorId("1");
            System.out.println(res);
            System.out.println("---------------------");
            for (Object lib: ldao.obtenerTodo()){
                System.out.println((Libro)lib);
            }

        }catch (SQLException sqle){
            System.out.println("error");
            System.out.println(sqle.getMessage());
        }


    }
}