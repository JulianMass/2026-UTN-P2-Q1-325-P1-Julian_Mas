package empresadeturismo;

public class VanEjecutiva extends Vehiculo {
    
    private boolean aireAcondicionado;

    public VanEjecutiva(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTiene aire acondicionado?: " + aireAcondicionado + "\n---------------";
    }

    @Override
    public void realizarServiciosTuristicos() {
        System.out.println("Van ejecutiva en servicio");
    }
}
