package library;

import java.io.PrintStream;
import java.util.Collection;

public class Library {
/* Variable Members */
	//One for books
	//One for movies
	//One for music albums
	
	//HashMap of TreeSets?
	
	
/* general methods */
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword) {
		return null;
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item) {
		
	}
	
	
	
	
	
/* book-related methods */
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords) {
		return null;
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
		return null;
	}
	
	
	
	
	
/* music-related methods */
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords) {
		return null;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members) {
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
		return null;
	}
	
	
	
	
	
/* movie-related methods */
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords) {
		return null;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members) {
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
		return null;
	}	
}
