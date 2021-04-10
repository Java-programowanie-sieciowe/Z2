import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.filechooser.FileNameExtensionFilter;

public class ZipOutputEx {

	public static void main(String[] args) {
		File f=new File("/Users/lukaszbibrzycki/Dysk Google/UP/java_network/StreamCompression");
		String[] files=f.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.contains("pdf");
			}
		});
		
		System.out.println(Arrays.toString(files));
		
		try(ZipOutputStream zos=new ZipOutputStream(new FileOutputStream("pliki.zip"))){
			for(String s: files) {
				try(FileInputStream fis=new FileInputStream(s)){
					ZipEntry ze=new ZipEntry(s);
					zos.putNextEntry(ze);
					int c;
					int buffsize=1000;
					byte[] bufor=new byte[buffsize];
					while((c=fis.read(bufor, 0, buffsize))>-1) {
						zos.write(bufor,0,c);
					}
					System.out.println("zipping..."+s);
					zos.closeEntry();
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
