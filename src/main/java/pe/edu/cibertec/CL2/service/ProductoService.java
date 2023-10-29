package pe.edu.cibertec.CL2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.CL2.model.bd.Producto;
import pe.edu.cibertec.CL2.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }

    /*
    public Optional<Producto> eliminarProductoPorId(Integer id){
        Optional<Producto> producto = productoRepository.delete(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }else
            return producto;
    }*/



    public Optional<Producto> obtenerProductoPorNombre(String categoryName){
        Optional<Producto> producto = productoRepository.findByProductoname(categoryName);
        if(producto.isEmpty())
            return  Optional.empty();
        else
            return producto;
    }

    public List<Producto> obtenerProductosPorFiltro(String filtro){
        return productoRepository.filtrarProductosPorNombreSQL(filtro);
    }

    public List<Producto> obtenerProductosPorFiltroAnio(String filtro){
        return productoRepository.filtrarProductosAnio2024SQL(filtro);
    }




}
