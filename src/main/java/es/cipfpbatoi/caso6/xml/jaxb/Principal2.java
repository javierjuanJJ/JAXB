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

public class Principal2 {
	private static final String BIBLIOTECA_XML = "biblio-jaxb.xml";
	private static final String BIBLIOTECA_XML2 = "biblio-jaxb1.xml";

	public static void main(String[] args) {

		ArrayList<Libro> listaLibros = new ArrayList<>();
		ArrayList<Biblioteca2> listaBiblioteca = new ArrayList<>();
		Catalogo catalogo = new Catalogo(listaBiblioteca);

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
		Biblioteca2 biblioteca = new Biblioteca2();
		Biblioteca2 biblioteca2 = new Biblioteca2();
		biblioteca.setNombre("Fraport Bookstore");
		biblioteca.setUbicacion("Frankfurt Airport");
		biblioteca2.setNombre("Batoi");
		biblioteca2.setUbicacion("Alcoi");
		biblioteca.setListaLibros(listaLibros);
		biblioteca2.setListaLibros(listaLibros);
		listaBiblioteca.add(biblioteca);
		listaBiblioteca.add(biblioteca2);
		
		listaBiblioteca.get(1).setNombre("Batoi");
		listaBiblioteca.get(1).setUbicacion("Alcoi");

		try {
			// Creamos el contexto JAXB e instanciamos un marshaller (serializador)
			JAXBContext context = JAXBContext.newInstance(Catalogo.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(catalogo, System.out);

			// escritura del fichero XML
			try (FileWriter fw = new FileWriter(BIBLIOTECA_XML2)) {
				m.marshal(catalogo, fw);
			} catch (IOException ex) {
				System.out.println("Problemas durante la escritura del fichero..." + ex.getMessage());
			}
		} catch (JAXBException ex) {
			System.out.println(
					"Problemas durante la lectura/escritura del archivo xml " + BIBLIOTECA_XML + " " + ex.getMessage());
		}

		// lectura del fichero XML
		try {
			JAXBContext context = JAXBContext.newInstance(Catalogo.class);

			Unmarshaller um = context.createUnmarshaller();
			Catalogo catalogo2 = null;
			try {
				catalogo2 = (Catalogo) um.unmarshal(new FileReader(BIBLIOTECA_XML2));
				System.out.println(catalogo);
			} catch (FileNotFoundException ex) {
				System.out.println("Parece que el fichero no existe..." + ex.getMessage());
			}

			

		} catch (JAXBException e) {
			System.out.println(
					"Problemas durante la lectura/escritura del archivo xml " + BIBLIOTECA_XML + " " + e.getMessage());
		}

	}

}
