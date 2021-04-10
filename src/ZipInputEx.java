import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputEx {

	public static void main(String[] args) {
		try(ZipInputStream zis=new ZipInputStream(new FileInputStream("pliki.zip"))){
			ZipEntry ze=null;
			while((ze=zis.getNextEntry())!=null) {
				System.out.println("extracting..."+ze.getName());
				try(FileOutputStream fos=new FileOutputStream(ze.getName())){
					int c;
					int buffsize=1000;
					byte[] bufor=new byte[buffsize];
					while((c=zis.read(bufor, 0, buffsize))>-1) {
						fos.write(bufor, 0, c);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
