package facebookcorso;

import java.util.ArrayList;
import java.util.List;

public class Facebook {
	
	private List<Utente> elencoContatti;
	
	public Facebook (){
		
	}

	public List<Utente> getElencoContatti() {
		return elencoContatti;
	}

	public void setElencoContatti(List<Utente> elencoContatti) {
		this.elencoContatti = elencoContatti;
	}

	public Facebook(List<Utente> elencoContatti) {
		this.elencoContatti = elencoContatti;
	}
	
	public void registraUtente(String nome, String cognome, int eta, char sesso, String email){
		if(email.contains("@")==true){
		Utente utente1 = new Utente(nome, cognome, eta, sesso, email);
		for(Utente u : elencoContatti){
			if(utente1.getEmail().equalsIgnoreCase(u.getEmail())){
				System.out.println("Utente già inserito");
				return;
			}
		}elencoContatti.add(utente1);
		}
	}

	public void aggiungiAmici(String nomeCognome1 , String nomeCognome2 ) {
		Utente u1=null;
		Utente u2=null;
		
		for(Utente u : elencoContatti){
			String strTemp = u.getNome() + " " + u.getCognome();
			if(nomeCognome1.equals(strTemp)==true){
				u1=u;
			}
			
		}
		for(Utente u : elencoContatti){
			String strTemp = u.getNome() + " " + u.getCognome();
			if(nomeCognome2.equals(strTemp)==true){
				u2=u;
			}
			
		}
		if(u1 != null && u2 != null){
		u1.aggiungiAmici(u2);
		u2.aggiungiAmici(u1);
		}
	}
		
	public String getAmiciDiUnUtente(String nome, String cognome) {
		Utente u1 = null;
		String strTemp= "";
		
		// qua scorro du lista di tutti profili di facebook 
		// se trovo lo prendo 
		for(Utente u : elencoContatti){
			String stringTemp =u.getNome() + " " + u.getCognome();
			if(stringTemp.equals(nome +" "+cognome)){
				u1=u;
				break;
				}
				
			}
		
		for(Utente u3 : u1.getElencoAmici()){
			strTemp+=(u3.getNome() + " " + u3.getCognome())+"\n";
		
		}
		
		return strTemp;
	}

	public String getAmiciDiAmici(String nome, String cognome) {
		String listaAmiciDiAmici = "";
		Utente utente = null;
		
		for(Utente u : elencoContatti){
			String strTemp = u.getNome() + " " + u.getCognome();
			if(strTemp.equals(nome+ " " + cognome)){
				utente=u;
				break;
				
				
			}
		}
		
		
		for(Utente u3 : utente.getElencoAmici()){
			for(Utente u2 : utente.getElencoAmici()){
				listaAmiciDiAmici+=u2.getNome() + " " + u2.getCognome() + "\n";
			}
		}
		
		return listaAmiciDiAmici;
	}

	public String getAmiciInComune(String nomeCognome1 , String nomeCognome2 ) {
		Utente u1=null;
		Utente u2=null;
		
		for(Utente u : elencoContatti){
			String strTemp = u.getNome() + " " + u.getCognome();
			if(nomeCognome1.equals(strTemp)==true){
				u1=u;
				break;
			}
			
		}
		for(Utente u : elencoContatti){
			String strTemp = u.getNome() + " " + u.getCognome();
			if(nomeCognome2.equals(strTemp)==true){
				u2=u;
				break;
			}
		}
		
		
		String amiciInComune = "";
		for(Utente u : u1.getElencoAmici()){
			for(Utente ut : u2.getElencoAmici()){
				if(u.getNome().equals(ut.getNome()) && u.getCognome().equals(ut.getCognome())){
					amiciInComune = amiciInComune + u.getNome() + " " + u.getCognome() + " ";				
				}
			}
		}
		return amiciInComune;
	}
}
