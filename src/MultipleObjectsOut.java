import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MultipleObjectsOut {

	public static void main(String[] args) {
		ArrayList<Czlowiek> ludzie=new ArrayList<Czlowiek>();
		ludzie.add(new Czlowiek("Zenon", "Xenon"));
		ludzie.add(new Czlowiek("Marian", "Kania"));
		ludzie.add(new Czlowiek("Piotr", "Zięba"));
		
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("ludzie.ser"))){
			for(Czlowiek c: ludzie)
				oos.writeObject(c);
			
			System.out.println("Koniec");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
