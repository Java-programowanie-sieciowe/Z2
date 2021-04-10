import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZippedObjectsIn {

	public static void main(String[] args) {
		try(ZipInputStream zis=new ZipInputStream(new FileInputStream("ludzie.zip"))){
			ZipEntry ze=null;
			while((ze=zis.getNextEntry())!=null) {
				System.out.println("unzipping..."+ze.getName());
				ObjectInputStream ois=new ObjectInputStream(zis); 
				Czlowiek c=(Czlowiek)ois.readObject();
				System.out.println(c);				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
