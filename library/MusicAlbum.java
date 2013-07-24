package library;

import java.util.Set;
import java.util.TreeSet;

class MusicAlbum extends Item {
/* Variable Members */
	public		Set<String>		members;

/* Constructors */
	public MusicAlbum() {
		super();
		
		members = new TreeSet<>();
		members.add("nobody");
	}

	public MusicAlbum(String tit, String mkr, Integer len, String... kw) {
		super(tit, mkr, len, kw);
		
		members = new TreeSet<>();
		members.add("nobody");
	}
	
/* Members Methods */
	public String getMembers() {
		StringBuilder mem = new StringBuilder();
		for(String s: members) mem.append(s + " ");
		return mem.toString();
	}
	
	public void setMembers(String... musicians) {
		members.clear();
		for(String s: musicians) members.add(s + " ");
	}
	
	public void addMembers(String... musicians) {
		if(members.contains("nobody")) members.clear();
		for(String s: musicians) members.add(s + " ");
	}
}
