import java.lang.String;
import java.io.*;
import java.util.*;

public class Cliente {
  public void buscarProducto () {
    Scanner scan=new Scanner(System.in);
    System.out.println("");
    System.out.println("-------------------------------------------");
    System.out.println("|             BUSCAR PRODUCTO             |");
    System.out.println("-------------------------------------------\n");
    System.out.print("Ingrese el nombre del producto: \n--->");
    String nombreProducto=scan.next();
    ArrayList<TxtEnJava> productosEncontrados = new ArrayList<TxtEnJava>(); 
      try{
        File file = new File("productos.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String [] arreglo;
        while ((st = br.readLine()) != null){
          arreglo = st.split("\t");
          if(arreglo[3].toLowerCase().contains(nombreProducto.toLowerCase())){
            int id= Integer.parseInt(arreglo[0]);
            String descripcion= arreglo[1];
            double precio= Double.parseDouble(arreglo[2]);
            String nombre= arreglo[3];
            String almacen= arreglo[4];
            TxtEnJava t=new TxtEnJava (id, descripcion, precio, nombre, almacen);
            productosEncontrados.add(t);
          }
        }
      } catch(Exception exception){ }
      
      if (productosEncontrados.size()>0){
        Collections.sort(productosEncontrados);
        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("|          PRODUCTOS ENCONTRADOS          |");
        System.out.println("-------------------------------------------\n");               
        for(TxtEnJava producto: productosEncontrados ){
          System.out.println("Referencia: "+producto.getId());
          System.out.println("Descripción: " + producto.getDescripcion());
          System.out.println("Precio:" + producto.getPrecio());
          System.out.println("Nombre: " + producto.getNombre());
          System.out.println("Empresa: " + producto.getEmpresa());
          System.out.println("");
        }
      }
        
      if (productosEncontrados.size()==0){
        System.out.println("El producto no se encuentra");
        System.out.println("");
      } 
  }
}
