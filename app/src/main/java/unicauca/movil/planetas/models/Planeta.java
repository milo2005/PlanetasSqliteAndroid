package unicauca.movil.planetas.models;

/**
 * Created by Dario Chamorro on 4/12/2016.
 */

public class Planeta {

    long id;
    String nombre;
    float gravedad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getGravedad() {
        return gravedad;
    }

    public void setGravedad(float gravedad) {
        this.gravedad = gravedad;
    }
}
