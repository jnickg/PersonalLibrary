// Each book, music album, or movie will be an instance of a subclass of this class.
// Instances of this class should not be created. Specifying it as 'abstract' ensures
// that they cannot.

package library;

import java.util.Set;
import java.util.TreeSet;

public abstract class Item
		implements Comparable<Item>{
/* Variable Members */
	public		String		title;
	public		String		maker;
	public		Set<String> keywords;
	
/* Constructors */
	Item() {
		title = "";
		maker = "";
		
		keywords = new TreeSet<>();
		keywords.add("none");
	}
	
	Item(String tit, String mkr, String ... kw) {
		title = tit;
		maker = mkr;
		
		keywords = new TreeSet<>();
		for(String s: kw) keywords.add(s);
	}
	
/* General Methods */
	
	@Override
	public int compareTo(Item other) {
		int title  = this.title.compareTo(other.getTitle());
		return title==0 ? this.maker.compareTo(other.getTitle()) : title;
	}
	
	@Override
	public abstract String toString();

/* Search Methods */
	public boolean matchTit(String tit) {
		if(title.equals(tit)) return true;
		return false;
	}
	
	public boolean matchMkr(String mkr) {
		if(maker.equals(mkr)) return true;
		return false;
	}
	
	public boolean matchKw(String ... kw) {
		for(String s: kw)	if(keywords.contains(s.toLowerCase()))	return true;
		return false;
	}

/* Title Methods */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

/* Maker Methods */
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

/* Keywords Methods */
	public String getKeywords() {
		StringBuilder kw = new StringBuilder();
		for(String s: keywords)	kw.append(s + " ");
		return kw.toString();
	}
	
	// Returns a set of Kanye Wests. As if one weren't too many.
	public Set<String>getKWset() {
		return keywords;
	}

	public void setKeywords(String ... kw) {
		keywords.clear();
		for(String s: kw) keywords.add(s);
	}
	
	public void addKeywords(String ... kw) {
		if(keywords.contains("none")) keywords.clear();
		for(String s: kw) keywords.add(s);
	}

}
