
public class Studente {
	private String nome;
	private String cognome;
	private String classe;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public Studente(String nome, String cognome, String classe) {
		this.nome=nome;
		this.cognome=cognome;
		this.classe=classe;
	}
	
}