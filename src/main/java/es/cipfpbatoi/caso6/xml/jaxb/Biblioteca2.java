package es.cipfpbatoi.caso6.xml.jaxb;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Definición del elemento raíz de nuestro documento

@XmlType(propOrder = {"nombre", "ubicacion", "listaLibros"})
public class Biblioteca2 {
    
    private String nombre;
    private String ubicacion;    
    private ArrayList<Libro> listaLibros;    

    public Biblioteca2() {
    }
    
    @XmlElementWrapper(name = "libros")
    @XmlElement(name = "libro")
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    public void setListaLibros(ArrayList<Libro> bl) {
        this.listaLibros = bl;
    }    

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String toString() {
		String Texto_del_objeto="";
		int contador=0;
		Texto_del_objeto=Texto_del_objeto+"La ubicacion de esta biblioteca es "+getUbicacion() + "\n";
		Texto_del_objeto=Texto_del_objeto+"El nombre de esta biblioteca es "+getNombre() + " ";
		Texto_del_objeto=Texto_del_objeto + "\nLa lista de libros de esta biblioteca son:\n";
		for (contador=0;contador<getListaLibros().size();contador++) {
			Texto_del_objeto=Texto_del_objeto+getListaLibros().get(contador);
		}
		
		
		return Texto_del_objeto;
	}
}
