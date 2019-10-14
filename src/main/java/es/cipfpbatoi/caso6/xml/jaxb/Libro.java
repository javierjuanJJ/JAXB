package es.cipfpbatoi.caso6.xml.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

// Definición del orden en el que queremos que se escriban los elementos
@XmlType(propOrder = {"titulo", "editor", "autor", "isbn", "paginas"})
public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String editor;
    private String isbn;
    private short paginas;

    // Define que el campo id es un atributo xml de libro.
    @XmlAttribute(name="id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    // Define el resto de elementos. 
    // Si no definimos el nombre explicitamente se quedará con el nombre del atributo de la clase
    @XmlElement(name = "title")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement(name = "author")
    public String getAutor() {
        return autor;
    }

    
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement(name = "editor")
    public String getEditor() {
        return editor;
    }
    public void setEditor(String editor) {
        this.editor = editor;
    }

    @XmlElement(name = "isbn")
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @XmlElement(name = "paginas")
    public short getPaginas() {
        return paginas;
    }
    public void setPaginas(short paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + titulo + ", autor=" + autor + ", editor=" + editor + ", isbn=" + isbn + ", paginas=" + paginas + '}';
    }   

}
