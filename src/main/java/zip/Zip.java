package zip;

import java.io.*;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Zip {

    private static final int BUFFER_SIZE = 4096;

    private byte[] unzipBase64(String base64Str) throws FileNotFoundException, IOException {
        byte[] bfile = Base64.getDecoder().decode((base64Str));
        return bfile;

    }

    public void unzipFile(String base64Str, String DestFilePath) throws IOException {

        File destDirectory = new File(DestFilePath);
        File file = new File("File.zip");
        FileOutputStream fos = null;
        if (!destDirectory.exists()) {
            destDirectory.mkdir();
        }
        try {
            fos = new FileOutputStream(file);
            fos.write(unzipBase64(base64Str));
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
        ZipEntry zipEntry = zipInputStream.getNextEntry();

        while (zipEntry != null) {
            String filePath = DestFilePath + File.separator + zipEntry.getName();
            if (!zipEntry.isDirectory()) {

                extractFile(zipInputStream, filePath);
            } else {

                File directory = new File(filePath);
                directory.mkdirs();
            }
            zipInputStream.closeEntry();
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        if (file.delete()) {
            System.out.println("File gelöscht");
        } else {
            System.out.println("File nicht gelöscht");
        }

    }

    private static void extractFile(ZipInputStream Zip_Input_Stream, String File_Path) throws IOException {
        BufferedOutputStream Buffered_Output_Stream = new BufferedOutputStream(new FileOutputStream(File_Path));
        byte[] Bytes = new byte[BUFFER_SIZE];
        int Read_Byte = 0;
        while ((Read_Byte = Zip_Input_Stream.read(Bytes)) != -1) {
            Buffered_Output_Stream.write(Bytes, 0, Read_Byte);
        }
        Buffered_Output_Stream.close();
    }
}
