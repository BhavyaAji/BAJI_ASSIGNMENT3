/**
 * song class
 */
public class Song {
	private String title;
	private String artistName;

	/**
	 * parameterized constructor
	 * 
	 * @param title
	 * @param artistName
	 */
	public Song(String title, String artistName) {
		this.title = title;
		this.artistName = artistName;
	}

	/**
	 * default constructor
	 */
	public Song() {
		title = "";
		artistName = "";
	}

	/**
	 * returns title
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * returns artist
	 * 
	 * @return
	 */
	public String getArtist() {
		return artistName;
	}

	/**
	 * sets title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * sets artistName
	 * 
	 * @param artistName
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * string conversion of object
	 */
	@Override
	public String toString() {
		return title + " by " + artistName;
	}
}
