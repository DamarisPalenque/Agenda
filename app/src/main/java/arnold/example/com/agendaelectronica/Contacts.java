package arnold.example.com.agendaelectronica;

/**
 * Created by ARNOLD on 30/06/2015.
 */
public class Contacts {

    int id;
    String nombre;
    String apellido;
    String tel;
    String email;
    String descripcion;

    public Contacts(){

    }

    public Contacts ( String name, String lastName, String phone, String email, String descripcion){

        this.tel = phone;
        this.nombre = name;
        this.apellido = lastName;
        this.email = email;
        this.descripcion = descripcion;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getTel(){
        return tel;
    }
    public void setTel(String phone){
        this.tel = phone;
    }


    public String getNombre(){
        return nombre;
    }
    public void setNombre(String name){
        this.nombre = name;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String lastName){
        this.apellido = lastName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
