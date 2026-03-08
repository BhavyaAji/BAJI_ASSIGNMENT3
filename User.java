/**
 * user class
 */
public class User {
	private String name;
	private String password;
	private GenericLinkedList<Playlist> playlists;

	/**
	 * default constructor
	 */
	public User() {
		name = null;
		password = null;
		playlists = new GenericLinkedList<Playlist>();
	}

	/**
	 * parameterized constructor
	 * 
	 * @param name
	 * @param password
	 */
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
		playlists = new GenericLinkedList<Playlist>();
	}

	/**
	 * adds to playlist
	 * 
	 * @param playlist
	 */
	public void addPlaylist(Playlist playlist) {
		playlists.addLast(playlist);
	}

	/**
	 * returns username
	 * 
	 * @return
	 */
	public String getUsername() {
		return name;
	}

	/**
	 * returns password
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets username
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * setes password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * returns playlist size
	 * 
	 * @return
	 */
	public int getPlaylistCount() {
		return playlists.size();
	}

	/**
	 * returns linked lists of multiple playlists
	 * 
	 * @return
	 */
	public GenericLinkedList<Playlist> getPlaylists() {
		return playlists;
	}
}
