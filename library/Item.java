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
	public		Set<String>	contributors;
	public		Set<String> keywords;
	
/* Constructors */
	Item() {
		title = "";
		maker = "";
		
		contributors = new TreeSet<>();
		contributors.add("nobody");
		
		keywords = new TreeSet<>();
		keywords.add("none");
	}
	
	Item(String tit, String mkr, String ... kw) {
		title = tit;
		maker = mkr;
		
		contributors = new TreeSet<>();
		contributors.add("nobody");
		
		keywords = new TreeSet<>();
		for(String s: kw) keywords.add(s);
	}
	
/* General Methods */
	
	@Override
	public int compareTo(Item other) {
		int title  = this.title.compareTo(other.getTitle());
		return title==0 ? this.maker.compareTo(other.getMaker()) : title;
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
	
/* Contributors Methods */
	public Set<String> getContribSet() {
		return contributors;
	}
	public void setContributors(String... actors) {
		contributors.clear();
		for(String s: actors) contributors.add(s + " ");
	}
	public void addContributors(String... actors) {
		if(contributors.contains("nobody")) contributors.clear();
		for(String s: actors) contributors.add(s);
	}

/* Keywords Methods */
	public String getContributors() {
		// Add commas
		StringBuilder contrib = new StringBuilder();
		for(String s: contributors) contrib.append(s + ", ");
		String rtn = contrib.toString();
		// Trim extra commas
		if(rtn.endsWith(", "));
		rtn = rtn.substring(0, rtn.lastIndexOf(", "));
		return rtn;
	}
	
	public String getKeywords() {
		StringBuilder kw = new StringBuilder();
		// Add all keywords
		for(String s: keywords)	kw.append(s + ", ");
		String rtn = kw.toString();
		// Trim extra commas
		if(rtn.endsWith(", "));
		rtn = rtn.substring(0, rtn.lastIndexOf(", "));
		return rtn;
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
