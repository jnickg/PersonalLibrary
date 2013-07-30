package library;

import java.util.Set;
import java.util.TreeSet;

class MusicAlbum extends Item {
/* Variable Members */
	public		int				songs;
	public		Set<String>		members;

/* Constructors */
	public MusicAlbum() {
		super();
		
		songs = 0;
		
		members = new TreeSet<>();
		members.add("nobody");
	}
	public MusicAlbum(String tit, String mkr, Integer sng, String... kw) {
		super(tit, mkr, kw);
		
		songs = sng;
		
		members = new TreeSet<>();
		members.add("nobody");
	}
	
/* General Methods */
	public String toString() {
		StringBuilder toStr = new StringBuilder();
		toStr.append(String.format(
				"-Music Album-\n"
				+ "band:     %s\n"
				+ "# songs:  %d\n"
				+ "members:  %s\n"
				+ "title:    %s\n"
				+ "keywords: %s\n\n",
				this.getMaker(),
				this.getSongs(),
				this.getMembers(),
				this.getTitle(),
				this.getKeywords()));
		return toStr.toString();
	}
	
/* Length Methods */	
	public int getSongs() {
		return songs;
	}
	public void setSongs(int songs) {
		this.songs = songs;
	}
	
/* Members Methods */
	public String getMembers() {
		// Insert proper commas
		StringBuilder mem = new StringBuilder();
		for(String s: members) mem.append(s + ", ");
		String rtn = mem.toString();
		// Trim extra commas
		if(rtn.endsWith(", "));
		rtn = rtn.substring(0, rtn.lastIndexOf(", "));
		return rtn;
	}
	
	public Set<String> getMemberSet() {
		return members;
	}
	
	public void setMembers(String... musicians) {
		members.clear();
		for(String s: musicians) members.add(s + " ");
	}
	
	public void addMembers(String... musicians) {
		if(members.contains("nobody")) members.clear();
		for(String s: musicians) members.add(s);
	}
}
