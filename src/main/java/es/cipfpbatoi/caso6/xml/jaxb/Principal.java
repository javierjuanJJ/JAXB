package es.cipfpbatoi.caso6.xml.jaxb;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Principal {

    private static final String BIBLIOTECA_XML = "biblio-jaxb.xml";

    public static void main(String[] args) {

        ArrayList<Libro> listaLibros = new ArrayList<>();

        // Creamos los libros
        Libro libro1 = new Libro();
        libro1.setId(1);
        libro1.setIsbn("978-0060554736");
        libro1.setTitulo("The Game");
        libro1.setAutor("Neil Strauss");
        libro1.setEditor("Harpercollins");
        libro1.setPaginas((short) 200);
        listaLibros.add(libro1);

        Libro libro2 = new Libro();
        libro2.setId(2);
        libro2.setIsbn("978-3832180577");
        libro2.setTitulo("Feuchtgebiete");
        libro2.setAutor("Charlotte Roche");
        libro2.setEditor("Dumont Buchverlag");
        libro2.setPaginas((short) 100);
        listaLibros.add(libro2);

        // Creamos la biblioteca y le asignamos los libros
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNombre("Fraport Bookstore");
        biblioteca.setUbicacion("Frankfurt Airport");
        biblioteca.setListaLibros(listaLibros);

        try {
            // Creamos el contexto JAXB e instanciamos un marshaller (serializador)
            JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(biblioteca, System.out);

            // escritura del fichero XML 
            try (FileWriter fw = new FileWriter(BIBLIOTECA_XML)) {
                m.marshal(biblioteca, fw);
            } catch (IOException ex) {
                System.out.println("Problemas durante la escritura del fichero..." + ex.getMessage());
            }

            // lectura del fichero XML            
            Unmarshaller um = context.createUnmarshaller();
            Biblioteca biblioteca2 = null;
            try {
                biblioteca2 = (Biblioteca) um.unmarshal(new FileReader(BIBLIOTECA_XML));
            } catch (FileNotFoundException ex) {
                System.out.println("Parece que el fichero no existe..." + ex.getMessage());
            }

            if (biblioteca2 != null) {
                ArrayList<Libro> listadoLibros = biblioteca2.getListaLibros();
                System.out.println("Nombre: " + biblioteca2.getNombre());
                System.out.println("Ubicacion: " + biblioteca2.getUbicacion());
                for (Libro libro : listadoLibros) {
                    System.out.println(libro);
                }
            }

        } catch (JAXBException ex) {
            System.out.println("Problemas durante la lectura/escritura del archivo xml " + BIBLIOTECA_XML + " " + ex.getMessage());
        }

    }
}


