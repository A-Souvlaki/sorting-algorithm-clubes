package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream {

   

    //Constructores
    public MyObjectOutputStream() throws IOException {
        super(); 
    }

    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    //Sobrescribimos el método que crea la cabecera
    protected void writeStreamHeader() throws IOException {
        // No hacer nada.
    }
}