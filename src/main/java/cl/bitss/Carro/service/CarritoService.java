package cl.bitss.Carro.service;
import cl.bitss.Carro.model.Carrito;
import cl.bitss.Carro.repository.CarritoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    private final CarritoRepository repository;
    public CarritoService(CarritoRepository repository) {
        this.repository = repository;
    }

    public List<Carrito> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Carrito> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Carrito crear(Carrito carrito) {
        return repository.save(carrito);
    }

    public Optional<Carrito> actualizar(Long id, Carrito datos) {
        Optional<Carrito> carritoEncontrado = repository.findById(id);
        if (carritoEncontrado.isPresent()) {
            Carrito carrito = carritoEncontrado.get();
            carrito.setUsuarioId(datos.getUsuarioId());
            carrito.setVideojuegoId(datos.getVideojuegoId());
            carrito.setNombreVideojuego(datos.getNombreVideojuego());
            carrito.setPrecio(datos.getPrecio());
            return Optional.of(repository.save(carrito));
        }
        return Optional.empty();
    }

    public boolean eliminar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Carrito> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
