package library;

class Book extends Item {
	
	public Book() {
		super();
	}

	public Book(String tit, String mkr, Integer len, String... kw) {
		super(tit, mkr, len, kw);
	}
	
}
