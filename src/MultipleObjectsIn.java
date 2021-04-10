import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MultipleObjectsIn {
	
	public static void main(String ...strings) {
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("ludzie.ser"))){
			Object obj =null;
			while((obj=ois.readObject())!=null) {
				Czlowiek c=(Czlowiek)obj;
				System.out.println(c);
			}
		}
			catch(EOFException e) {
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
