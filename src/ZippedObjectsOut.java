import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZippedObjectsOut {

	public static void main(String[] args) {
		ArrayList<Czlowiek> ludzie=new ArrayList<Czlowiek>();
		ludzie.add(new Czlowiek("Zenon", "Xenon"));
		ludzie.add(new Czlowiek("Marian", "Kania"));
		ludzie.add(new Czlowiek("Piotr", "Zięba"));
		
		try(ZipOutputStream zos=new ZipOutputStream(new FileOutputStream("ludzie.zip"))){
			for(Czlowiek c: ludzie)
			{	
				ZipEntry ze=new ZipEntry(c.toString());
				zos.putNextEntry(ze);
				ObjectOutputStream oos=new ObjectOutputStream(zos);
				System.out.println("zipping..."+c);
				oos.writeObject(c);
				zos.closeEntry();
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
