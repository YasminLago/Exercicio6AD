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
        int cadenaUTF = tex.size();
        System.out.println("WriteUTF escribiu: "+ texto);
        System.out.println("WriteUTF escribiu "+cadenaUTF+" bytes");
        
        
        tex.writeChars(texto);
        int cadeaUTF = tex.size();
        System.out.println("WriteChars escribiu: "+ texto);
        System.out.println("WriteChar escribiu: "+(cadeaUTF-cadenaUTF)+" bytes"); 
        
        tex.writeUTF(texto);
        int cadeUTF = tex.size();
        System.out.println("WriteUTF escribiu: "+ texto);
        System.out.println("WriteUTF escribiu "+(cadeUTF-cadeaUTF)+" bytes");
        
        tex.close();
        
        System.out.println("Bytes totais escritos: "+tex.size());
        System.out.println("Lemos a primeira cadea en UTF: "+text.readUTF());
        System.out.println("Número de bytes lidos: "+cadenaUTF+" bytes");
        System.out.println("Bytes restantes por ler: "+text.available());
        
        String cadea = "";
        for(int i = 0;i<texto.length();i++){
            cadea +=text.readChar();
        }
        System.out.println("Lemos a segunda cadea Chars: "+cadea);
        
        System.out.println("O número de bytes lidos e: "+(cadeaUTF-cadenaUTF));
        System.out.println("Bytes restantes por ler: "+text.available());
        System.out.println("Lemos a terceira cadea mediante readUTF: "+text.readUTF());
        
        text.close();
        
    }
}
