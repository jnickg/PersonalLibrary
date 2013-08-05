package library;

class Movie extends Item {
/* Variable Members */
	public		int				scenes;

/* Constructors */
	public Movie() {
		super();
		
		scenes = 0;
	}
	public Movie(String tit, String mkr, Integer scn, String... kw) {
		super(tit, mkr, kw);
		
		scenes = scn;
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
				this.getContributors(),
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
	
}
