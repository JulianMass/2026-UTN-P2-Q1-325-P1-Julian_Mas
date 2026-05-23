package empresadeturismo;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
    }

    public String getPatente() {
        return patente;
    }
    
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }
    
    public abstract void realizarServiciosTuristicos();
    
    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehiculo)) return false;
        
        Vehiculo otra = (Vehiculo) obj;
        return this.patente.equalsIgnoreCase(otra.patente);
    }
    
    @Override
    public int compareTo(Vehiculo v) {
        if (this.anioFabricacion != v.anioFabricacion) {
            return v.anioFabricacion - this.anioFabricacion; // DESC
        }
        return v.capacidadPasajeros - this.capacidadPasajeros; // DESC
    }
    
    @Override 
    public String toString() {
        return "Patente: " + patente + "\nMarca: " + marca + "\nCapacidad de pasajeros: " + capacidadPasajeros + "\nAnio de fabricacion: " + anioFabricacion;
    }
}
