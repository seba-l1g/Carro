package cl.bitss.Carro.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuarioId es obligatorio")
    @Positive(message = "El usuarioId debe ser mayor que 0")
    private Long usuarioId;

    @NotNull(message = "El videojuegoId es obligatorio")
    @Positive(message = "El videojuegoId debe ser mayor que 0")
    private Long videojuegoId;

    @NotBlank(message = "El nombre del videojuego es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombreVideojuego;

    @NotNull(message = "El precio es obligatorio")
    @PositiveOrZero(message = "El precio no puede ser negativo")
    private Double precio;

    public Carrito() {
    }

    public Carrito(Long usuarioId, Long videojuegoId, String nombreVideojuego, Double precio) {
        this.usuarioId = usuarioId;
        this.videojuegoId = videojuegoId;
        this.nombreVideojuego = nombreVideojuego;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getVideojuegoId() {
        return videojuegoId;
    }

    public void setVideojuegoId(Long videojuegoId) {
        this.videojuegoId = videojuegoId;
    }

    public String getNombreVideojuego() {
        return nombreVideojuego;
    }

    public void setNombreVideojuego(String nombreVideojuego) {
        this.nombreVideojuego = nombreVideojuego;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}