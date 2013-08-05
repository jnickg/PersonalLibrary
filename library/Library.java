package library;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Library {
/* Variable Members */
	// Search maps
	private	Map<String, Set<Item>>
				// Book search maps
				bTitleMap, bMakerMap,
				// Movie search maps
				moTitleMap, moMakerMap, moCastMap,
				// MusicAlbum search maps
				muTitleMap, muMakerMap, muMembMap,
				// Keyword map for all items
				kwMap;
	// Master list
	private	Set<Item>
				bookS, movieS, albumS;
	
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
		if (kwMap.containsKey(keyword)) return kwMap.get(keyword);
		else return null;
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item) {
		out.print(item.toString());
	}
	
	// general method for adding a new value to any number of keys, into a specific search map
	private void addToMap(Map<String, Set<Item>> disMap, Item disValue, String... disKey) {
		for(String k: disKey) {
			if(!(disMap.containsKey(k))) {
				Set<Item> temp = new TreeSet<>();
				temp.add(disValue);
				disMap.put(k, temp);
			}
			else {
				Set<Item> temp = disMap.get(k);
				temp.add(disValue);
				disMap.put(k, temp);
			}
		}
	}
	
//	private void rmvFromMap(Map<String, Set<Item>> disMap, Item disValue, String... disKey) {
//		for(String k: disKey) {
//			if(disMap.containsKey(k)) {
//				Set<Item> temp = disMap.get(k);
//			}
//		}
//	}
	
	
	
	
/* book-related methods */
	
	// adds a book to the library, its respective search maps, and returns it
	public Item addBook(String title, String author, int nPages, String... keywords) {
		Book disBook = new Book(title, author, nPages, keywords);
		
		bookS.add(disBook);
		
		addToMap(bTitleMap, disBook, title);
		addToMap(bMakerMap, disBook, author);
		addToMap(kwMap, disBook, keywords);
		
		return disBook;
	}
	
	// removes a book from the library (only needed for Premium version)
	public boolean removeBook(String title) {
		boolean success = false;
		if (bTitleMap.containsKey(title)) {
			// Get every book with that title and remove from title map
			Set<Item> temp = bTitleMap.remove(title);
			// Remove self from other mappings
			if (bookS.removeAll(temp)) {
				for (Item i: temp) {
					// Remove itself from maker map
					String author = i.getMaker();
					bMakerMap.get(author).remove(i);
					// Remove itself from each kw's value
					Set<String> kwords = i.getKWset();
					for(String kw: kwords) kwMap.get(kw).remove(i);
				}
				success = true;
			}
			else success = false;
		}
		return success;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author) {
		if (bMakerMap.containsKey(author)) return bMakerMap.get(author);
		else return null;
	}
	
	public Collection<Item> booksByTitle(String title) {
		if (bTitleMap.containsKey(title)) return bTitleMap.get(title);
		else return null;
	}
	// returns all of the books in the library
	public Collection<Item> books() {
		return bookS;
	}
	
	
	
	
	
/* music-related methods */
	
	// adds a music album to the library, its respective search maps, and returns it
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords) {
		MusicAlbum disAlbum = new MusicAlbum(title, band, nSongs, keywords);
		
		// Add it to master set
		albumS.add(disAlbum);
		
		// Add it to relevant mappings
		addToMap(muTitleMap, disAlbum, title);
		addToMap(muMakerMap, disAlbum, band);
		addToMap(kwMap, disAlbum, keywords);
		
		return disAlbum;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members) {
		album.addContributors(members);
		
		for(String m: members) {
			addToMap(muMembMap, album, m);
		}
	}
	
	// removes a music album from the library (only needed for Premium version)
	public boolean removeMusicAlbum(String title) {
		boolean success = false;
		if (muTitleMap.containsKey(title)) {
			//Get every book with that title
			Set<Item> temp = muTitleMap.remove(title);
			if (albumS.removeAll(temp)) {
				for (Item i: temp) {
					// Remove self from maker map
					String band = i.getMaker();
					muMakerMap.get(band).remove(i);
					// Remove self from member map
					Set<String> membr = i.getContribSet();
					for(String m: membr) {
						Set<Item> itemsForMember = muMembMap.get(m);
						itemsForMember.remove(i);
					}
					// Remove itself from each kw's value
					Set<String> kwords = i.getKWset();
					for(String kw: kwords) kwMap.get(kw).remove(i);
				}
				success = true;
			}
		}
		return success;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band) {
		if (muMakerMap.containsKey(band)) return muMakerMap.get(band);
		else return null;
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician) {
		if (muMembMap.containsKey(musician)) return muMembMap.get(musician);
		else return null;
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums() {
		return albumS;
	}
	
	
	
	
	
/* movie-related methods */
	
	// adds a movie to the library, its respective search maps, and returns it
	public Item addMovie(String title, String director, int nScenes, String... keywords) {
		Movie disMovie = new Movie(title, director, nScenes, keywords);
		
		movieS.add(disMovie);
		
		addToMap(moTitleMap, disMovie, title);
		addToMap(moMakerMap, disMovie, director);
		addToMap(kwMap, disMovie, keywords);
		
		return disMovie;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members) {
		movie.addContributors(members);
		
		for(String m: members) {
			addToMap(moCastMap, movie, m);
		}
	}

	// removes a movie from the library (only needed for Premium version)
	public boolean removeMovie(String title) {
		boolean success = false;
		if (moTitleMap.containsKey(title)) {
			//Get every book with that title
			Set<Item> temp = moTitleMap.remove(title);
			if (movieS.removeAll(temp)) {
				for (Item i: temp) {
					// Remove self from maker map
					String director = i.getMaker();
					moMakerMap.get(director).remove(i);
					// Remove self from member map
					Set<String> membr = ((Movie)i).getContribSet();
					for(String m: membr) moCastMap.get(m).remove(i);
					// Remove itself from each kw's value
					Set<String> kwords = i.getKWset();
					for(String kw: kwords) kwMap.get(kw).remove(i);
				}
				success = true;
			}
			else success = false;
		}
		return success;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director) {
		if (moMakerMap.containsKey(director)) return moMakerMap.get(director);
		else return null;
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor) {
		if (moCastMap.containsKey(actor)) return moCastMap.get(actor);
		else return null;
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies() {
		return movieS;
	}	
}
