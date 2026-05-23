package empresadeturismo;

public class ColectivoTuristico extends Vehiculo {
    
    private int cantidadPisos;

    public ColectivoTuristico(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        
        if (cantidadPisos < 1 && cantidadPisos > 2) System.out.println("Solo se permiten 1 o 2 pisos");
        this.cantidadPisos = cantidadPisos;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nCantidad de pisos: " + cantidadPisos + "\n---------------";
    }

    @Override
    public void realizarServiciosTuristicos() {
        System.out.println("Colectivo turistico en servicio");
    }
}
