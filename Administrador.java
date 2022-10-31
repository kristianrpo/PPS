import java.util.*;
import java.io.*;

public class Administrador {

    private Scanner entrada = new Scanner(System.in);
    private String representanteLegal;
    private int cedulaRepresentante;
    private long telefono;
    private long nit;
    private String correoElectronico;
    private String nombreTienda;
    private int numeroLocal;
    private String contrasenia;

    public void setRepresentanteLegal(String representante){
        this.representanteLegal = representante;
    }

    public String getRepresentanteLegal(){
        return this.representanteLegal;
    }

    public void setCedula(int cedula){
        this.cedulaRepresentante = cedula;
    }

    public int getCedula(){
        return this.cedulaRepresentante;
    }

    public void setTelefono(long telefono){
        this.telefono = telefono;
    }

    public long getTelefono(){
        return this.telefono;
    }

    public void setNit(long nit){
        this.nit = nit;
    }

    public long getNit(){
        return this.nit;
    }

    public void setCorreoElectronico(String correo){
        this.correoElectronico = correo;
    }

    public String getCorreoElectronico(){
        return this.correoElectronico;
    }

    public void setNombreTienda(String tienda){
        this.nombreTienda = tienda;
    }

    public String getNombreTienda(){
        return this.nombreTienda;
    }

    public void setLocal(int local){
        this.numeroLocal = local;
    }

    public int getLocal(){
        return this.numeroLocal;
    }

    public void setContrasenia(String contra){
        this.contrasenia = contra;
    }

    public String getContrasenia(){
        return this.contrasenia;
    }

    public void registroAdministrador() 
    {
        System.out.println("-------------------------------------------");
        System.out.println("|         REGISTRO DE ADMINISTRADOR       |");
        System.out.println("-------------------------------------------\n\n\n");
        System.out.println("--------------------------------------");
        System.out.print("    Primer nombre del representante legal del local: \n--->");
        this.representanteLegal = entrada.next();
        System.out.println("--------------------------------------");
        System.out.print("    Cédula del representante legal: \n--->");
        this.cedulaRepresentante = entrada.nextInt();
        System.out.println("--------------------------------------");
        System.out.print("  Teléfono fijo: \n--->");
        this.telefono = entrada.nextLong();
        System.out.println("--------------------------------------");
        System.out.print("  NIT: \n--->");
        this.nit = entrada.nextLong();
        System.out.println("--------------------------------------");
        System.out.print("  Correo electrónico: \n--->");
        this.correoElectronico = entrada.next();
        while(this.correoElectronico.contains("@") == false){
            System.out.print("¡Error! Ingrese un correo válido\n    Correo Electronico: \n--->");
            this.correoElectronico = entrada.next();
        }
        System.out.println("--------------------------------------");
        System.out.print("  Nombre del negocio: \n--->");
        this.nombreTienda = entrada.next();
        System.out.println("--------------------------------------");
        System.out.print("  Número del negocio(Local): \n--->");
        this.numeroLocal = entrada.nextInt();
        String contra1;
        String contra2;

        System.out.println("--------------------------------------");
        System.out.print("Cree una contraseña de mínimo 8 caracteres\n--->");
        contra1 = entrada.next();

        while(contra1.length()<8){
            System.out.println("¡Error!\nAsegúrese de utizar 8 caracteres");
            System.out.print("Cree una contraseña de mínimo 8 caracteres\n--->");
            contra1 = entrada.next();
        }

        while(true){
            System.out.println("--------------------------------------");
            System.out.println("Confirmar contraseña: \n--->");
            contra2 = entrada.next();

            if(!(contra1.equals(contra2))){
                System.out.println("Las contraseñas no coinciden");
            }else{
                break;
            }
        }
        this.contrasenia = contra1;

        File archivo;
        FileWriter escribir;
        PrintWriter linea;
        archivo = new File("users.text");
        if(!archivo.exists()){
            try
            {
                archivo.createNewFile();
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                linea.print("Representantee"+this.representanteLegal+"Cedulaa"+this.cedulaRepresentante+"Telefonoo"+this.telefono+"nitt"+this.nit+
                    "correoo"+this.correoElectronico+"negocioo"+this.nombreTienda+"Numeroo"+this.numeroLocal+"contraa"+this.contrasenia+"-----\n");
                linea.close();
                escribir.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }else{
            try
            {
                escribir = new FileWriter(archivo,true);
                linea = new PrintWriter(escribir);
                linea.print("Representantee"+this.representanteLegal+"Cedulaa"+this.cedulaRepresentante+"Telefonoo"+this.telefono+"nitt"+this.nit+
                    "correoo"+this.correoElectronico+"negocioo"+this.nombreTienda+"Numeroo"+this.numeroLocal+"contraa"+this.contrasenia+"-----\n");
                linea.close();
                escribir.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("|Se ha registrado el usuario correctamente|");
        System.out.println("-------------------------------------------\n");
        System.out.println("Redireccionando");
        try
        {for(int i=0; i<4; i++){
                Thread.sleep(1000);
                System.out.print(".");
            }
        }catch(InterruptedException e){}
        for(int i=0; i<10; i++){
            System.out.print("\n");
        }
        this.inicioSesion();
    }

    public void inicioSesion() {
        File archivoLeer;
        FileReader lector;
        String stringTotal = "";
        archivoLeer = new File("users.text");
        String cadena = "";

        ArrayList<Integer> cedulas = new ArrayList<Integer>();
        ArrayList<String> contrasenias = new ArrayList<String>();

        try
        {
            lector = new FileReader("users.text");
            BufferedReader almacenamiento = new BufferedReader(lector);
            stringTotal="";
            while(stringTotal!=null){
                try{
                    stringTotal = almacenamiento.readLine();
                    if(stringTotal!=null){
                        cadena = cadena + stringTotal;
                    }
                }
                catch(IOException ioe)
                {
                    ioe.printStackTrace();
                }

            }

            try{
                almacenamiento.close();
                lector.close();
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }

        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        int iniContra = 0;
        int finContra = 0;
        int iniCed = 0;
        int finCed = 0;

        for(int i = 0; i<cadena.length(); i++){
            iniCed = cadena.indexOf("Cedulaa", finCed);
            finCed = cadena.indexOf("Telefonoo", iniCed);

            iniContra = cadena.indexOf("contraa",iniCed);
            finContra = cadena.indexOf("-----",finCed);

            if(finCed == -1 || iniCed == -1 ){break;}
            if(iniContra == -1 || finContra == -1 ){break;}

            String verfCed = cadena.substring(iniCed+7, finCed);
            int intCedula = Integer.parseInt(verfCed);
            String verfContra = cadena.substring(iniContra+7, finContra);

            cedulas.add(intCedula);
            contrasenias.add(verfContra);
        }

        boolean verificacion = false;
        int intentos = 0;
        System.out.println("\n\n-------------------------------------------");
        System.out.println("|              INICIAR SESIÓN             |");
        System.out.println("-------------------------------------------\n");

        System.out.println("\n----------------------------");
        System.out.print("Ingrese cedula\n--->");
        int comproCed = entrada.nextInt();
        String comproContra="";
        int posicion = -1;

        while (verificacion != true && intentos<5) {
            for(int i = 0; i<cedulas.size();i++){
                if(cedulas.get(i) == comproCed){
                    posicion=i;
                }
            }
            if(posicion<0){
                System.out.println("¡Error!No se ha encontrado la cédula ingresada");
                this.inicioSesion();
                break;
            }
            System.out.println("----------------------------");
            System.out.print("Ingresa la contraseña\n--->");
            comproContra = entrada.next();

            if(contrasenias.get(posicion).equals(comproContra)){
                System.out.println("\n-------------------------------------------");
                System.out.println("|            HA INICIADO SESIÓN           |");
                System.out.println("-------------------------------------------\n");
                System.out.println("Redireccionando");
                try
                {for(int i=0; i<4; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                }catch(InterruptedException e){}
                verificacion = true;
                TxtEnJava txt= new TxtEnJava();
                txt.main();
            }
            else{
                System.out.println("La contraseña es incorrecta");
                intentos++;
                if(intentos==5){
                    System.out.println("----Número de intentos excedido----");
                    System.out.println("Redireccionando");
                    try
                    {for(int i=0; i<4; i++){
                            Thread.sleep(1000);
                            System.out.print(".");
                        }
                    }catch(InterruptedException e){}
                    this.inicioSesion();
                }
            }
        }
    }
}
