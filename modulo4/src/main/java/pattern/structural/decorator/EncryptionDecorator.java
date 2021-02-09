package pattern.structural.decorator;

import java.util.Base64;

/**
 * Clase decoradora
 */
public class EncryptionDecorator extends DataSourceDecorator {

    EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {//Encripta con AES
        //super.writeData(Base64.getEncoder().encodeToString(data.getBytes()));
        super.writeData(data.toUpperCase());
    }
    
    public void writeDataTripleDes(String data){
    }

    public void writeEncryptedData(String data) {
        super.writeData(Base64.getEncoder().encodeToString(data.getBytes()));
    }

    public void writeTolowerDate(String data) {
        super.writeData(data.toLowerCase());
    }

    @Override
    public String readData() {
        return new String(Base64.getDecoder().decode(super.readData()));
    }
}
