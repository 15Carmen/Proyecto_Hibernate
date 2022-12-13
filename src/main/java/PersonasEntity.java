import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Jugadores")
public class PersonasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJugadores")
    private int idJugador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numAciertos")
    private String numAciertos;

    public PersonasEntity(){

    }

    public PersonasEntity(String nombre, String numAciertos) {
        this.nombre = nombre;
        this.numAciertos = numAciertos;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumAciertos() {
        return numAciertos;
    }

    public void setNumAciertos(String numAciertos) {
        this.numAciertos = numAciertos;
    }
}
