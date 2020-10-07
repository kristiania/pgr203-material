package no.kristiania.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceOutput {

    public static void main(String[] args) throws IOException {
        new ResourceOutput().outputFile(args[0]);
    }

    private void outputFile(String filename) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (InputStream resourceStream = getClass().getResourceAsStream(filename)) {
            if (resourceStream == null) {
                throw new IOException("File not found: " + filename);
            }
            resourceStream.transferTo(buffer);
        }

        System.out.println("Content-Length: " + buffer.toByteArray().length);
        System.out.write(buffer.toByteArray());
    }
}