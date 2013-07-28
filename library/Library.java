package library;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Library {
/* Variable Members */
	private	Map<String, Set<Book>>
				bTitleMap, bMakerMap;
	private	Map<String, Set<Movie>>
				moTitleMap, moMakerMap, moCastMap;
	private	Map<String, Set<MusicAlbum>>
				muTitleMap, muMakerMap, muMembMap;
	private Map<String, Set<Item>>
				kwMap;
	private	Set<Item>			bookS;
	private	Set<Item>			movieS;
	private	Set<Item>			albumS;
	
/* Constructors */
	public Library() {
		bTitleMap = new HashMap<>();
		moTitleMap = new HashMap<>();
		muTitleMap = new HashMap<>();
		
		bMakerMap = new HashMap<>();
		moMakerMap = new HashMap<>();
		muMakerMap = new HashMap<>();
		
		moCastMap = new HashMap<>();
		muMembMap = new HashMap<>();
		
		kwMap = new HashMap<>();
		
		bookS = new TreeSet<>();
		movieS = new TreeSet<>();
		albumS = new TreeSet<>();
	}
	
/* general methods */
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword) {
		return null;
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item) {
		out.print(item.toString());
	}
	
//	private void addToMap(String disKey, Item disValue, Map<String, Set<Item>> disMap) {
//		if(!(disMap.containsKey(disKey))) {
//			Set<Item> temp = new TreeSet<>();
//			temp.add(disValue);
//			disMap.put(disKey, temp);
//		}
//		else {
//			Set<Item> temp = disMap.get(disKey);
//			temp.add(disValue);
//			disMap.put(disKey, temp);
//		}
//	}
	
	
	
	
/* book-related methods */
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords) {
		Book disBook = new Book(title, author, nPages, keywords);
		
		bookS.add(disBook);
		
//		addToMap(disBook, title, bTitleMap);
		
		if(!(bTitleMap.containsKey(title))) {
			Set<Book> temp = new TreeSet<>();
			temp.add(disBook);
			bTitleMap.put(title, temp);
		}
		else {
			Set<Book> temp = bTitleMap.get(title);
			temp.add(disBook);
			bTitleMap.put(title, temp);
		}
		
		// Add it to the all the stuff..... 
		
		return disBook;
	}
	
	// removes a book from the library (only needed for Premium version)
	public boolean removeBook(String title) {
		return false;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author) {
		return null;
	}
	
	// returns all of the books in the library
	public Collection<Item> books() {
		return bookS;
	}
	
	
	
	
	
/* music-related methods */
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords) {
		MusicAlbum disAlbum = new MusicAlbum(title, band, nSongs, keywords);
		
		albumS.add(disAlbum);
		
//		addToMap(disBook, title, bTitleMap);
		
		if(!(muTitleMap.containsKey(title))) {
			Set<MusicAlbum> temp = new TreeSet<>();
			temp.add(disAlbum);
			muTitleMap.put(title, temp);
		}
		else {
			Set<MusicAlbum> temp = muTitleMap.get(title);
			temp.add(disAlbum);
			muTitleMap.put(title, temp);
		}
		
		// Add it to the all the stuff..... 
		
		return disAlbum;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members) {
		album.addMembers(members);
	}
	
	// removes a music album from the library (only needed for Premium version)
	public boolean removeMusicAlbum(String title) {
		return false;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band) {
		return null;
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician) {
		return null;
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums() {
		return albumS;
	}
	
	
	
	
	
/* movie-related methods */
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords) {
		Movie disMovie = new Movie(title, director, nScenes, keywords);
		
		movieS.add(disMovie);
		
//		addToMap(disBook, title, bTitleMap);
		
		if(!(moTitleMap.containsKey(title))) {
			Set<Movie> temp = new TreeSet<>();
			temp.add(disMovie);
			moTitleMap.put(title, temp);
		}
		else {
			Set<Movie> temp = moTitleMap.get(title);
			temp.add(disMovie);
			moTitleMap.put(title, temp);
		}
		
		// Add it to the all the stuff..... 
		
		return disMovie;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members) {
		movie.addtoCast(members);
	}

	// removes a movie from the library (only needed for Premium version)
	public boolean removeMovie(String title) {
		return false;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director) {
		return null;
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor) {
		return null;
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies() {
		return movieS;
	}	
}
