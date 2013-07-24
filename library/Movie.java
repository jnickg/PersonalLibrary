package library;

import java.util.Set;
import java.util.TreeSet;

class Movie extends Item {
/* Variable Members */
	public		Set<String>		cast;

/* Constructors */
	public Movie() {
		super();
		
		cast = new TreeSet<>();
		cast.add("nobody");
	}

	public Movie(String tit, String mkr, Integer len, String... kw) {
		super(tit, mkr, len, kw);

		cast = new TreeSet<>();
		cast.add("nobody");
	}
	
/* Cast Methods */
	public String getCast() {
		StringBuilder cst = new StringBuilder();
		for(String s: cast) cst.append(s + " ");
		return cst.toString();
	}
	
	public void setCast(String... actors) {
		cast.clear();
		for(String s: actors) cast.add(s + " ");
	}
	
	public void addtoCast(String... actors) {
		if(cast.contains("nobody")) cast.clear();
		for(String s: actors) cast.add(s);
	}
	
}
