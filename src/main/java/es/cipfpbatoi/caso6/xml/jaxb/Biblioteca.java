package es.cipfpbatoi.caso6.xml.jaxb;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Definición del elemento raíz de nuestro documento
@XmlRootElement(name = "biblioteca", namespace = "biblio")
@XmlType(propOrder = {"nombre", "ubicacion", "listaLibros"})
public class Biblioteca {
  
  private String nombre;
  private String ubicacion;    
  private ArrayList<Libro> listaLibros;    

  public Biblioteca() {
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
}
