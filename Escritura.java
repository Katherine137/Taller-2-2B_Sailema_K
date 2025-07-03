package ficheros.clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Escritura {
    //metodos para escribir el archivo
     private FileWriter fichero=null;
     private PrintWriter pw=null;

     public void escribirfichero(String info, String ruta){
         try (FileWriter fichero = new FileWriter(ruta);
              PrintWriter pw = new PrintWriter(fichero)){
             pw.println(info);
             System.out.println("Archivo creado exitosamente");
         }
         catch (IOException e){
             System.err.println("Error al escribir en el archivo: "+e.getMessage());
         }
     }

    public void actualizarfichero(String info, String ruta){
        try (FileWriter fichero = new FileWriter(ruta, true);
             PrintWriter pw = new PrintWriter(fichero)){
            pw.println(info);
            System.out.println("Archivo actualizado exitosamente");
        }
        catch (IOException e){
            System.err.println("Error al escribir en el archivo: "+e.getMessage());
        }
    }
    public <T> void escribirLista(String ruta, ArrayList<T> lista) {
        try (FileWriter fw = new FileWriter(ruta, true);
             PrintWriter pw = new PrintWriter(fw)){

            for (T item: lista){
                pw.println(item); //se usa el metodo toString()
            }
            System.out.println("Lista escrita correctamente.");
        }
        catch (IOException e){
            System.err.println("Error al escribir en el archivo: "+e.getMessage());
        }
    }
}
