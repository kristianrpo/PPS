import java.util.*;

public class TxtEnJava implements Comparable <TxtEnJava> {
  private      int    id;
  private      String descripcion;
  private      double precio;
  private      String    nombre;
  private      String    empresa;
  File   FicheroProducto= new File("productos.txt");

  ArrayList<TxtEnJava> cositas =new ArrayList<TxtEnJava>();
  TxtEnJava             objeto = null;
    
  public TxtEnJava(int id,String descripcion,double precio,String nombre, String empresa) {
    this.id=id;
    this.descripcion=descripcion;
    this.precio=precio; 
    this.nombre=nombre; 
    this.empresa = empresa;
  }             
  public TxtEnJava(){} 
   
   
  public  int getId()
   {
      return this.id;
       
    }
   public  String getDescripcion()
   {
      return this.descripcion;
       
    }
   public  double getPrecio()
   {
      return this.precio;
       
    }
   public  String getNombre()
   {
      return this.nombre;
       
    }
    public  String getEmpresa()
   {
      return this.empresa;
       
    }
    
   
    
    public  int setId(int n)
   {
      return id=n;
       
    }
   public  String setDescripcion(String n)
   {
      return descripcion=n;
       
    }
   public  double setPrecio(double n)
   {
      return precio=n;
       
    }
   public  String setNombre(String n )
   {
      return nombre=n ;
       
    }
    public  String setEmpresa(String n )
   {
      return empresa=n ;
       
    }
    
   
   
   public void comprobarBd(){
        try
      {
          
        if(!FicheroProducto.exists())
        {
            FicheroProducto.createNewFile();
            System.out.println("Base de datos de productos creada se insertara el producto");
        }else{System.out.println("La base de datos de productos existe");}
       }catch (Exception ex) 
       {  
            
          System.out.println(ex.getMessage());  
       }
     }
   public void InsertarProductos(int id,String descripcion,double precio,String nombre, String empresa)
      {
         try
      {  
         this.id=id;
         this.descripcion=descripcion;
         this.precio=precio; 
         this.nombre=nombre;
         this.empresa = empresa;
           
        
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FicheroProducto,true), "utf-8"));  
          
          Fescribe.write(getId()+"\t"+getDescripcion()+"\t"+getPrecio()+"\t"+getNombre()+"\t"+getEmpresa()+"\r\n");  
           System.out.println("El producto a sido insertado en la base de datos");           //Cierra el flujo de escritura  
          Fescribe.close();
          
        }
        catch (Exception ex) 
       {  
           
          System.out.println(ex.getMessage());  
       }
      } 
   public void DetxtAObjeto()
     {
        try
        {
         String linea = null;
         BufferedReader leerFichero = new BufferedReader (new FileReader(FicheroProducto));    
         while( (linea = leerFichero.readLine()) != null)
         {
            
            StringTokenizer mistokens = new StringTokenizer(linea, "\t");
            String           id =  mistokens.nextToken().trim();
            String  descripcion =  mistokens.nextToken().trim();
            String       precio =  mistokens.nextToken().trim();
            String       nombre =  mistokens.nextToken().trim();
            String       empresa = mistokens.nextToken().trim();
           

            int    idOperar=Integer.parseInt(id);
            double preciOperar=Double.parseDouble(precio);
        
            
            
            
            objeto= new TxtEnJava(idOperar,descripcion,preciOperar,nombre,empresa);
             
            cositas.add(objeto);
            
            }
         leerFichero.close();
       
       }catch (Exception ex) 
       {  
             
          System.out.println(ex.getMessage());  
       }
      }     
   public void ActualizarArraList()
   {
    
      cositas.clear();
      DetxtAObjeto(); 
   }
      public void MostrarObjetos()
      {
     if( cositas.size()==0){DetxtAObjeto();}
     System.out.println("=========================== Articulo=========================================================================================================================================================================================");     
     for(TxtEnJava n:cositas)
     {
      System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:" +n.getEmpresa());
     }  
     System.out.println("============================FIN==============================================================================================================================================================================================");
   }
   
   
   public void modificarFichero()
  {
    try{
           
       if( cositas.size()==0){DetxtAObjeto();}
          
        Scanner en =new Scanner(System.in).useDelimiter("\n");
             
             
        int opc=10;
             
        while(opc!=8)
             {
               menu();
               opc=en.nextInt();
               switch(opc)
               {
                    case 1: System.out.println("Introducir el id del producto y la nueva id");
                             
                   int    idNumero=en.nextInt(); 
                   int    numero=en.nextInt();
                    for(TxtEnJava n:cositas)
                    {
                       
                      if(n.getId()==idNumero){
                          
                        n.id =numero;     
                        System.out.println("=========================== Articulo=========================================================================================================================================================================================");
                        System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:"+n.getEmpresa());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                      }else{
                          System.out.println("el producto no ha sido encontrado");
                                         }  
                    }
                    break;
                    
                    
                    
                    
                    case 2: System.out.println("Inserte la descripcion del producto y la  nueva descripcion del mismo");
                    String  cadena=en.next();        
                    String cadenaNueva=en.next();        
                    for(TxtEnJava n:cositas)
                    {
                       
                      if(n.getDescripcion().equals(cadena)){
                          
                        n.descripcion=cadenaNueva;     
                        System.out.println("=========================== Articulo=========================================================================================================================================================================================");
                        System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:"+n.getEmpresa());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                      }else{
                          System.out.println("el producto no ha sido encontrado");
                       }  
                    }
                    
                    
                    
                    
                    
                    break;
                    case 3: System.out.println("Inserte la descripcion del producto y el precio nuevo");
                    
                           cadena=en.next();        
                    double precioNuevo=en.nextDouble();        
                    for(TxtEnJava n:cositas)
                    {
                       
                      if(n.getDescripcion().equals(cadena)){
                          
                        n.precio=precioNuevo;     
                        System.out.println("=========================== Articulo=========================================================================================================================================================================================");
                        System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:"+n.getEmpresa());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                      }else{
                          System.out.println("el producto no ha sido encontrado");
                      }  
                    }
                    break;
                    
                   case 4: System.out.println("Inserte el nombre del producto y su nuevo nombre");
                    String  cadenas=en.next();        
                    String cadenaNuevas=en.next();        
                    for(TxtEnJava n:cositas)
                    {
                       
                      if(n.getNombre().equals(cadenas)){
                          
                        n.nombre=cadenaNuevas;     
                        System.out.println("=========================== Articulo=========================================================================================================================================================================================");
                        System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:"+n.getEmpresa());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                      }else{
                          System.out.println("el producto no ha sido encontrado");
                       }  
                    }
                    break;
                    
                    case 5: System.out.println("Inserte el nombre de la empresa y su nuevo nombre de empresa");
                    String  cadenass=en.next();        
                    String cadenaNuevass=en.next();        
                    for(TxtEnJava n:cositas)
                    {
                       
                      if(n.getEmpresa().equals(cadenass)){
                          
                        n.empresa=cadenaNuevass;     
                        System.out.println("=========================== Articulo=========================================================================================================================================================================================");
                        System.out.println("El id es:"+n.getId()+"\t"+"La descripcion es:"+n.getDescripcion()+"\t"+"El precio es:"+n.getPrecio()+"\t"+ "El nombre es:"+ n.getNombre()+"\t"+"La empresa es:"+n.getEmpresa());
                        System.out.println("============================FIN==============================================================================================================================================================================================");
                        break;
                      }else{
                          System.out.println("el producto no ha sido encontrado");
                       }  
                    }
                    break;
                    case 6: System.out.println("Guardar");
                    try{
                      BufferedWriter bw = new BufferedWriter(new FileWriter(FicheroProducto));
                      for(TxtEnJava n:cositas)
                      {
                          bw.write(n.id+"\t"+n.descripcion+"\t"+ n.precio+"\t"+ n.nombre+"\t"+n.empresa+"\r\n");   
                      }
                      bw.close();
                     }catch (Exception ex) 
                    {  
                      System.out.println(ex.getMessage());  
                    }
                    
                    break;  
                    
                    
                    case 7: System.out.println("inserte el ID del producto que va borrar de la bd");
                            int v=en.nextInt();
                            
                    try{
                      BufferedWriter bw = new BufferedWriter(new FileWriter(FicheroProducto));
                      for(TxtEnJava n:cositas)
                      {  
                          if(n.getId()!=v){
                           bw.write(n.id+ "\t"+n.descripcion+ "\t"+ n.precio+ "\t"+ n.nombre+"\t"+n.empresa+"\r\n");
                        }else{
                          System.out.println("el producto ha sido eliminado");
                                         }
                      }
                      bw.close();
                      cositas.clear();
                      DetxtAObjeto();
                      
                     }catch (Exception ex) 
                    {  
                       
                      System.out.println(ex.getMessage());  
                    }
                    
                    break;  
                }
            } 
        } catch (Exception ex) 
       {  
          
          System.out.println(ex.getMessage());  
       }     
     }  
  
  private void menu()
   {
     System.out.println("--------Menu de modificaciones de productos -------");
     System.out.println("1. Modificar id");
     System.out.println("2. Modificar descripcion ");
     System.out.println("3. Modificar precio");
     System.out.println("4. Modificar Nombre");
     System.out.println("5. Modificar Empresa");
     System.out.println("6. Guardar");
     System.out.println("7. Dar de baja un producto existente");
     System.out.println("8. Salir");
   }
    
  public  void main() 
   {
  boolean trueOrFalse = true;
   Scanner enter= new Scanner(System.in);
  while (trueOrFalse)
  {
  System.out.println("Este es el menú, ingrese que acción desea realizar");
  System.out.println("ingrese 0 para crear base de datos o verificar si ya existe");
  System.out.println("Ingrese 1 para crear algún producto");
  System.out.println("Ingrese 2 para actualizar la base de datos (necesario en caso de haber creado algún producto");
  System.out.println("Ingrese 3 para ver tabla de productos creados hasta el momento");
  System.out.println("Ingrese 4 para ir al menu del producto, allá podra modificar y eliminar productos");
  System.out.println("Ingrese 5 para cerrar sesión");
    System.out.println("");
    System.out.println("ingrese el numero que desea:");
    int num = enter.nextInt();

    switch(num)
    {
      case 0: comprobarBd();
      break;
      case 1: System.out.println("ingrese la referencia (ID)");
      int referencia= enter.nextInt();
       enter.skip("\n");
      System.out.println("ingrese el nombre");
      String nombre= enter.nextLine();
        System.out.println("ingrese el precio");
      double precio= enter.nextDouble();
       enter.skip("\n");
      System.out.println("ingrese la descripcion");
      String descripcion= enter.nextLine();
      System.out.println("ingrese el nombre de la empresa");
      String empresa= enter.nextLine();
      InsertarProductos(referencia, descripcion, precio, nombre, empresa);
        break;
      case 2:ActualizarArraList();
        break;
      case 3:MostrarObjetos();
        break;
      case 4:modificarFichero();
       break;
      case 5: trueOrFalse = false;
        break;
      default: break;
  }
    }
    }
    
  @Override
    public int compareTo(TxtEnJava t) {
        if (this.precio<t.getPrecio()) {
            return -1;
        }
        else if (this.precio>t.getPrecio()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
