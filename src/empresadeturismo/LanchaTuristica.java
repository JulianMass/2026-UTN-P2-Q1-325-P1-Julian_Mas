package empresadeturismo;

public class LanchaTuristica extends Vehiculo {
    
    public enum TipoMotor {
        NAFTA, DIESEL, ELECTRICO
    }
    
    private TipoMotor tipoMotor;

    public LanchaTuristica(String patente, String marca, int capacidadPasajeros, int anioFabricacion, TipoMotor tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoMotor = tipoMotor;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nTipo de motor: " + tipoMotor + "\n---------------";
    }
    
    @Override
    public void realizarServiciosTuristicos() {
        System.out.println("Lancha turistica en servicio");
    }
}
