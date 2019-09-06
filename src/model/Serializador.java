package model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
 
public class Serializador{
	// Escribe un objecto en un archivo
	private ObjectOutputStream oos = null;
 
	// Lee un objecto que este guardado en un archivo
	private ObjectInputStream ois = null;
 
	private Map<String, Integer> hashmap = new HashMap<String, Integer>();
 
	private static int counter = 0;
 
	// Al metodo le pasamos el objeto que queremos serializar y lo guardará en el archivo que se le especifique al FileOutputStream (en este caso "objeto.mio")
	public void escribirArchivo(Object objeto){
		try{
			if(oos == null)
				oos = new ObjectOutputStream(new FileOutputStream("objeto.mio"));
			
			oos.writeObject(objeto);
			hashmap.put(((Club)objeto).getId(),counter++);
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
 
	public Club leerArchivo(String rutaArchivo) {
		Club o = null;
		try{
			if(ois == null)
				ois = new ObjectInputStream(new FileInputStream(rutaArchivo));
			while(true){
				o = (Club)ois.readObject();
				System.out.println(o.toString());
			}
		}catch(EOFException ex)
		{
			System.out.println("\nFinal de archivo");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();		
		}		
		return o;
	}
 
	public Object leerArchivo(String rutaArchivo, String nombre) {
		Owner owner = null;
		int contador = 0;
		try{	
			ois = new ObjectInputStream(new FileInputStream(rutaArchivo));
			if(hashmap.get(nombre)!= null){
				int numero = hashmap.get(nombre).intValue();
				while(contador <= numero){
					owner = (Owner)ois.readObject();	
					contador++;
				}
				System.out.println(owner.getName());
			}
			else{
				System.out.println("El nombre no se encuentra en el archivo");
			}
			ois.close();
		}catch(EOFException ex)
		{
			System.out.println("\nFinal de archivo");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();		
		}
 
		return owner;
	}
}