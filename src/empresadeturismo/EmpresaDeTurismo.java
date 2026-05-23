package empresadeturismo;

import java.util.Scanner;

public class EmpresaDeTurismo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        AdministradorVehiculos admin = new AdministradorVehiculos();
        
        int opcion;
        
        System.out.println("----------BIENVENIDO A LA AGENCIA UTN----------");
        
        do {
            System.out.println("\n1. Agregar vehiculo");
            System.out.println("2. Mostrar todos los vehiculos");
            System.out.println("3. Realizar servicios turisticos");
            System.out.println("4. Buscar vehiculo por patente");
            System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado");
            System.out.println("6. Mostrar vehiculos ordenados por anio de fabricacion descendente");
            System.out.println("7. Mostrar vehiculos ordenados por capacidad de pasajeros descendente");
            System.out.println("8. Salir");
            
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Patente: ");
                    String patente = sc.nextLine();
                    if (patente.isEmpty()) { 
                        System.out.println("ERROR. No se permiten patentes vacias");
                        break;
                    }                   
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    if (marca.isEmpty()) {
                        System.out.println("ERROR. Debe ingresar una marca");
                        break;
                    }
                    
                    System.out.print("Capacidad de pasajeros: ");
                    int cant = sc.nextInt();
                    if (cant <= 0) {
                        System.out.println("ERROR. No se permiten cantidades menores o iguales a 0");
                        break;
                    }
                    
                    System.out.print("Anio de fabricacion: ");
                    int anio = sc.nextInt();
                    if (anio > 2026) {
                        System.out.println("ERROR. Debe ingresar un anio menor al actual");
                        break;
                    } else if (anio < 1990) {
                        System.out.println("ERROR. Debe ingresar un anio mayor a 1990");
                        break;
                    }
                    
                    System.out.print("Tipo de vehiculo (1.Colectivo, 2.Van ejecutiva, 3.Lancha): ");
                    int tipo = sc.nextInt();
                    
                    if (tipo == 1) {
                        System.out.print("Cantidad de pisos (1 o 2): ");
                        int cantPisos = sc.nextInt();
                        if (cantPisos == 1 || cantPisos == 2) {
                        admin.agregarVehiculo(new ColectivoTuristico(patente, marca, cant, anio, cantPisos));
                        } else {
                            System.out.println("La cantidad de pisos debe ser 1 o 2. Intente de nuevo");
                        }
                    } else if (tipo == 2) {
                        System.out.println("Tiene aire acondicionado? (S o N): ");
                        String aire = sc.next();
                        if ("S".equals(aire) || "s".equals(aire)) {
                            admin.agregarVehiculo(new VanEjecutiva(patente, marca, cant, anio, true));
                        } else { // cualquier input que no sea S o s lo tomo como negativo
                            admin.agregarVehiculo(new VanEjecutiva(patente, marca, cant, anio, false));
                        } 
                    } else if (tipo == 3) {
                        System.out.println("Tipo de motor (1.NAFTA, 2.DIESEL, 3.ELECTRICO)");
                        int t = sc.nextInt();
                        
                        LanchaTuristica.TipoMotor tipoMotor = null; // le puse null para poder comprarlos con el numero entero pedido por consola, sino me tira error
                        
                    switch (t) {
                        case 1 -> tipoMotor = LanchaTuristica.TipoMotor.NAFTA;
                        case 2 -> tipoMotor = LanchaTuristica.TipoMotor.DIESEL;
                        case 3 -> tipoMotor = LanchaTuristica.TipoMotor.ELECTRICO;
                        default -> System.out.println("Tipo de motor invalido");
                    }
                    if (tipoMotor != null) {
                        admin.agregarVehiculo(new LanchaTuristica(patente, marca, cant, anio, tipoMotor));
                    }                  
                } else {
                        System.out.println("ERROR. Opcion ingresada fuera de rango, intente nuevamente");                       
                    }                    
                    break;
                case 2:
                    admin.mostrarVehiculos();
                    break;
                case 3:
                    admin.realizarServiciosTuristicos();
                    break;
                case 4:
                    System.out.println("Ingrese la patente del vehiculo que quiere buscar: ");
                    String pat = sc.nextLine();
                    break; // no supe como seguir la logica :(
                case 5:
                    // aca tampoco :(
                    break;
                case 6:
                    admin.ordenarPorAnio();
                    break;
                case 7:
                    admin.ordenarPorCapacidad();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente: ");
            }
            
        } while (opcion != 8); 
    }
    
}
