package facebookcorso;

import java.util.ArrayList;

public class TestFacebook {

	public static void main(String[] args) {
		
                Facebook f= new Facebook(new ArrayList<Utente> ());
				
				Utente u1 = new Utente("aaaa","aaaa",18,'M',"aaaa@alfa.com");
				
				Utente u2 = new Utente("bbbb","bbbb",18,'M',"bbbb@alfa.com");
				
				Utente u3 = new Utente("cccc","cccc",28,'f',"cccc@alfa.com");
				
				Utente u4 = new Utente("dddd","dddd",28,'F',"dddd@alfa.com");
				
				Utente u5 = new Utente("eeee","eeee",28,'F',"eeee@alfa.com");
				
				
				f.registraUtente("aaaa","aaaa",18,'M',"aaaa@alfa.com");
				f.registraUtente("bbbb","bbbb",18,'M',"bbbb@alfa.com");
				f.registraUtente("cccc","cccc",28,'f',"cccc@alfa.com");
				f.registraUtente("dddd","dddd",28,'F',"dddd@alfa.com");
				f.registraUtente("eeee","eeee",28,'F',"eeee@alfa.com");
				
				
				f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u2.getNome() + " " + u2.getCognome());
				f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u3.getNome() + " " + u3.getCognome());
				f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u4.getNome() + " " + u4.getCognome());
				f.aggiungiAmici(u1.getNome() + " " + u1.getCognome(), u5.getNome() + " " + u5.getCognome());
				f.aggiungiAmici(u2.getNome() + " " + u2.getCognome(), u3.getNome() + " " + u3.getCognome());
				
				System.out.println(f.getAmiciDiUnUtente("aaaa","aaaa"));
				
				System.out.println(f.getAmiciDiAmici("eeee","eeee"));
			    
			    System.out.println(f.getAmiciInComune("cccc" + " " + "cccc" , "aaaa" + " " + "aaaa"));

	}

}
