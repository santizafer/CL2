package pe.edu.cibertec.CL2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.CL2.model.bd.Producto;
import pe.edu.cibertec.CL2.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProducto(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .obtenerProductoPorId(id).get();
                //.orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                //        id + " no existe."));

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id).get();
        oldProducto.setNombre(producto.getNombre());
        oldProducto.setDescripcion(producto.getDescripcion());
        oldProducto.setCantidad(producto.getCantidad());
        oldProducto.setFechavencimiento(producto.getFechavencimiento());
        return new ResponseEntity<>(
                productoService.guardar(oldProducto), HttpStatus.OK
        );
    }


    /*

    FUNCIONA ->

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> eliminarProducto(
            @PathVariable("id") Integer id){
        Producto producto = productoService
                .eliminarProductoPorId(id).get();
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
     */


    @GetMapping("/productoname/{productoname}")
    public ResponseEntity<Producto> obtenerProductoPorNombre(
            @PathVariable("categoryname") String productoName){
        Producto producto = productoService
                .obtenerProductoPorNombre(productoName).get();
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }


    @GetMapping("/productoname/{filtro}")
    public ResponseEntity<List<Producto>> filtrarProductosPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/productoanio/{filtro}")
    public ResponseEntity<List<Producto>> filtrarProductosPorAnio(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltroAnio(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }





}
