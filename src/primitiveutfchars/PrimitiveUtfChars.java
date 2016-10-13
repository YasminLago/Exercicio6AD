package primitiveutfchars;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author oracle
 */
public class PrimitiveUtfChars {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String texto = "Esta e unha cadea\n";

        DataInputStream text = new DataInputStream(new BufferedInputStream(new FileInputStream("/home/oracle/NetBeansProjects/PrimitiveUtfChars/text3.txt")));
        DataOutputStream tex = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/oracle/NetBeansProjects/PrimitiveUtfChars/text3.txt")));
        
        
        tex.writeUTF(texto);
        tex.writeChars(texto);
        tex.writeUTF(texto);
        
        String cadena = text.readUTF();
        
        System.out.println("WriteUTF escribiu: "+ cadena);
        System.out.println("WriteUTF escribiu"+tex.size()+" bytes");
        
        String cadea = "";
        for(int i = 0;i<texto.length();i++){
        cadea += text.readChar();              
        }
        
        System.out.println("WriteChars escribiu: "+ cadea);
        System.out.println("WriteChar escribiu: "+tex.size()+" bytes"); 
        
        System.out.println("WriteUTF escribiu: "+ cadena);
        System.out.println("WriteUTF escribiu"+tex.size()+" bytes");
        
        System.out.println("Bytes totais escritos: "+tex.size());
        System.out.println("Lemos a primeira cadea en UTF: "+cadena);
        int lido = cadea.length() + 2;
        System.out.println("Número de bytes lidos: "+lido+" bytes");
        System.out.println("Bytes restantes por ler: ");
        System.out.println("Lemos a segunda cadea Chars: ");
        System.out.println("O número de bytes lidos e: ");
        System.out.println("Bytes restantes por ler: ");
        System.out.println("Lemos a terceira cadea mediante readUTF: ");
    }
}
