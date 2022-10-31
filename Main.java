import java.util.Scanner;



public class Main {
public static void main(String[] args){
int x;
String y;
Scanner sc= new Scanner(System.in);
TxtEnJava txt= new TxtEnJava();
Administrador administrar= new Administrador();
Cliente cliente= new Cliente();

while(true){
System.out.println("-------------------------------------------");
System.out.println("| MENÚ PRINCIPAL |");
System.out.println("-------------------------------------------\n");
System.out.println("Ingrese 0 para salir del programa");
System.out.println("Ingrese 1 para iniciar sesión como administrador");
System.out.println("Ingrese 2 para iniciar búsqueda como cliente");
x=sc.nextInt();

if(x==0){
System.out.println("Programa finalizado");
break;
}
else if(x==1){
System.out.println("¿Tiene una cuenta registrada?");
y=sc.next();
if("si".equalsIgnoreCase(y)){
administrar.inicioSesion();
}
else if("no".equalsIgnoreCase(y)){
administrar.registroAdministrador();
}
else{
break;
}
}
else if(x==2){
cliente.buscarProducto();
while (true) {
System.out.println("¿Desea buscar otro producto?");
String otroProducto=sc.next();
if (otroProducto.equalsIgnoreCase("si")) {
cliente.buscarProducto();
}
else {
System.out.println("Búsqueda finalizada");
System.out.println("");
break;
}
}
}
}
}
}
