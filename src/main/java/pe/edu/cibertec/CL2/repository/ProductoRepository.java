package pe.edu.cibertec.CL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.CL2.model.bd.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByProductoname(String productoName);

    @Query(value = "SELECT * FROM categories WHERE categoryname LIKE %:filtro%", nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);

    @Query(value = "select nombre, fechavencimiento from producto where Year(fechavencimiento) = 2024", nativeQuery = true)
    List<Producto> filtrarProductosAnio2024SQL(@Param("filtro") String filtro);


}
