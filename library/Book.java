package library;

class Book extends Item {
	public		int		pages;

/* Constructors */
	public Book() {
		super();
		pages = 0;
	}
	public Book(String tit, String mkr, Integer pgs, String... kw) {
		super(tit, mkr, kw);
		pages = pgs;
	}
	
/* General Methods */
	public String toString() {
		StringBuilder toStr = new StringBuilder();
		toStr.append(String.format(
				"-Book-\n"
				+ "author:   %s\n"
				+ "# pages:  %d\n"
				+ "title:    %s\n"
				+ "keywords: %s\n\n",
				this.getMaker(),
				this.getPages(),
				this.getTitle(),
				this.getKeywords()));
		return toStr.toString();
	}
	
/* Pages Methods */
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
