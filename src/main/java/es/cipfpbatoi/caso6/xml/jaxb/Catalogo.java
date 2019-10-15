package es.cipfpbatoi.caso6.xml.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "bibliotecas", namespace = "biblios")
@XmlType(propOrder = {"bibliotecas"})
public class Catalogo {
	private ArrayList<Biblioteca> bibiliotecas;
	
	public Catalogo(ArrayList<Biblioteca> pbibiliotecas) {
		bibiliotecas=pbibiliotecas;
	}
	public Catalogo() {
		bibiliotecas=null;
	}
	public Catalogo(Catalogo catalogo) {
		bibiliotecas=catalogo.getbibliotecas();
	}
	
	@XmlElementWrapper(name = "catalogo")
    @XmlElement(name = "biblioteca")
	public ArrayList<Biblioteca> getbibliotecas() {

		return bibiliotecas;
	}
	
	public void setbibliotecas(ArrayList<Biblioteca> pbibiliotecas) {
		bibiliotecas=pbibiliotecas;
	}
	
	public String toString() {
		String Texto_del_objeto="";
		int contador=0;
		
		for (contador=0;contador<getbibliotecas().size();contador++) {
			Texto_del_objeto=Texto_del_objeto+getbibliotecas().get(contador);
		}
		
		
		return Texto_del_objeto;
	}
	
}
