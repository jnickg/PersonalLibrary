package library;

import java.util.Set;
import java.util.TreeSet;

class Movie extends Item {
/* Variable Members */
	public		int				scenes;
	public		Set<String>		cast;

/* Constructors */
	public Movie() {
		super();
		
		scenes = 0;
		
		cast = new TreeSet<>();
		cast.add("nobody");
	}
	public Movie(String tit, String mkr, Integer scn, String... kw) {
		super(tit, mkr, kw);
		
		scenes = scn;
		
		cast = new TreeSet<>();
		cast.add("nobody");
	}

/* General Methods */
	public String toString() {
		StringBuilder toStr = new StringBuilder();
		toStr.append(String.format(
				"-Movie-\n"
				+ "director: %s\n"
				+ "# scenes: %d\n"
				+ "cast:     %s\n"
				+ "title:    %s\n"
				+ "keywords: %s\n\n",
				this.getMaker(),
				this.getScenes(),
				this.getCast(),
				this.getTitle(),
				this.getKeywords()));
		return toStr.toString();
	}
	
/* Length Methods */
	public int getScenes() {
		return scenes;
	}
	public void setScenes(int scenes) {
		this.scenes = scenes;
	}

/* Cast Methods */
	public String getCast() {
		// Add commas
		StringBuilder cst = new StringBuilder();
		for(String s: cast) cst.append(s + " ");
		return cst.toString();
	}	
	
	public Set<String> getCastSet() {
		return cast;
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
