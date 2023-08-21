package ejemplo_libro.persistencia;

public class ProductoDAO {
    private int id;
    private String nombre;
    private int cantidad;
    private long precio;

    public ProductoDAO(int id, String nombre, int cantidad, long precio) {
    this.id = id;
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precio = precio;
    }

    public ProductoDAO(int id) {
        this.id=id;
    }

    public ProductoDAO() {

    }

    public String insertar(){
        return "insert into producto (id,nombre,cantidad,precio) values ('"+this.id+"','"+this.nombre+"','"+ this.cantidad+"','"+this.precio+"')";
    }
    public String consultar(){
        return "select * from producto where id='"+this.id+"'";
    }
    public String actualizar(){
        return "update producto set nombre='"+this.nombre +"', cantidad='"+this.cantidad+"', precio='"+this.precio +"' where id='"+this.id+"'";
    }
    public String buscar(String filtro) {
        return "select * from producto where nombre like '" + this.nombre + "', cantidad='" + this.cantidad + "', precio='" + this.precio + "' where id='" + this.id + "'";
    }
    public String eliminar(){
        return "delete from producto where id='"+this.id+"'";
    }
}

