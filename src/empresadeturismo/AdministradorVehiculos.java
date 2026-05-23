package empresadeturismo;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class AdministradorVehiculos {
    
    private List<Vehiculo> vehiculos = new ArrayList<>();
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            System.out.println("ERROR. El vehiculo ya existe");
        } else {
            vehiculos.add(vehiculo);
            System.out.println("Vehiculo agregado con exito!");
        }
    }
    
    // Metodos para mostrar e iniciar servicio 
    
    public void realizarServiciosTuristicos() {
        for (Vehiculo v : vehiculos) {
            v.realizarServiciosTuristicos();
        }
    }
    
    public void mostrarVehiculos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }
    
    // Metodos de ordenamiento
    
    public void ordenarPorAnio() {
        vehiculos.sort(Comparator.comparing(Vehiculo::getAnioFabricacion).reversed());
        mostrarVehiculos();
    }
    
    public void ordenarPorCapacidad() {
        vehiculos.sort(Comparator.comparing(Vehiculo::getCapacidadPasajeros).reversed());
        mostrarVehiculos();
    }
}
