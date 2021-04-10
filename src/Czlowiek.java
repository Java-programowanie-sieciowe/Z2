import java.io.Serializable;

public class Czlowiek implements Serializable{

	private String imie, nazwisko;

	public Czlowiek(String imie, String nazwisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return imie+" "+nazwisko;
	}
}
