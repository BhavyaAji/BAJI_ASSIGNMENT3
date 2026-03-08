import java.util.*;

import org.junit.validator.PublicClassValidator;

/**
 * playlist class
 */
public class Playlist {
	private String name;
	private Song currentSong;
	private ListIterator<Song> iterator;
	private GenericLinkedList<Song> playlist;

	/**
	 * default constructor
	 */
	public Playlist() {
		name = null;
		currentSong = null;
		playlist = new GenericLinkedList<Song>();
		iterator = playlist.iterator();
	}

	/**
	 * parameterized constructor
	 * 
	 * @param name
	 */
	public Playlist(String name) {
		this.name = name;
		currentSong = null;
		playlist = new GenericLinkedList<Song>();
		iterator = playlist.iterator();
	}

	/**
	 * adds song to play list. adds to last
	 * 
	 * @param song
	 * @return
	 */
	public Boolean addSong(Song song) {
		playlist.addLast(song);
		if (playlist.size() == 1) {
			currentSong = playlist.getFirst();
			iterator = playlist.iterator();
		}
		return true;
	}

	/**
	 * returns name of playlist
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns current song
	 * 
	 * @return
	 */
	public Song getCurrentSong() {
		return currentSong;
	}

	/**
	 * returns size
	 * 
	 * @return
	 */
	public int getSize() {
		return playlist.size();
	}

	/**
	 * returns reference to play list
	 * 
	 * @return
	 */
	public GenericLinkedList<Song> getSongs() {
		return playlist;
	}

	/**
	 * returns boolean if playlist is empty or not by calling method from
	 * GenericLinkedList
	 * 
	 * @return
	 */
	boolean isEmpty() {
		return playlist.isEmpty();
	}

	/**
	 * uses iterator to traverse play list
	 * 
	 * @return
	 */
	public Song nextSong() {
		if (iterator.hasNext()) {
			currentSong = iterator.next();
			return currentSong;
		} else {
			currentSong = null;
			return null;
		}
	}

	/**
	 * uses iterator to traverse play list
	 * 
	 * @return
	 */
	public Song previousSong() {
		if (iterator.hasPrevious()) {
			currentSong = iterator.previous();
			return currentSong;
		} else {
			currentSong = null;
			return null;
		}
	}

	/**
	 * remove song based on data, uses generic linked list method
	 * 
	 * @param song
	 * @return
	 */
	public Boolean removeSong(Song song) {
		return playlist.remove(song);
	}
}
