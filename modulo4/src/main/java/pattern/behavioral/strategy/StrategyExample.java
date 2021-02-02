package pattern.behavioral.strategy;

import java.io.File;

import static java.util.Arrays.asList;

public class StrategyExample {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        compressor.setCompressionFormat(new ZipCompression());
        //compressor.setCompressionFormat(new RarCompression());

        compressor.compress(asList(new File("README.md"))); // Salida: Compressing [README.md] with zip format
    }
}
