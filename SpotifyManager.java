import java.util.*;
import java.io.*;

/**
 * spotify manager class
 */
public class SpotifyManager {
	private GenericLinkedList<User> users;

	public SpotifyManager() {
		users = new GenericLinkedList<User>();
	}

	/**
	 * extracts information from an external .txt file and creates user objects,
	 * playlist objects, and song
	 * 
	 * @param filename
	 * @throws IOException
	 * @throws InvalidUserFormatException
	 */
	void loadUsersFromFile(String filename) throws IOException, InvalidUserFormatException {
		Scanner fileScanner = new Scanner(new File(filename));

		String line;
		User user = null;
		Playlist currentPl = null;

		while (fileScanner.hasNextLine()) {
			line = fileScanner.nextLine().trim();

			if (line.isEmpty()) {
				continue;
			}

			if (line.contains("# USER")) {
				user = null;
				currentPl = null;
			}

			else if (line.contains("username:")) {
				String username = line.substring(9).trim();
				user = new User(username, null);
				users.addLast(user);
			}

			else if (line.startsWith("password:")) {
				String password = line.substring(9).trim();
				user.setPassword(password);
			}

			else if (line.contains("playlist:")) {
				String playlistName = line.substring(9).trim();
				currentPl = new Playlist(playlistName);
				user.addPlaylist(currentPl);
			}

			else if (line.contains("song:")) {
				String songData = line.substring(5).trim();
				String title = songData.substring(0, songData.indexOf("-") - 1);
				String artist = songData.substring(songData.lastIndexOf("-") + 1).trim();
				Song song = new Song(title, artist);
				currentPl.addSong(song);
			}
		}

		fileScanner.close();
	}

	/**
	 * searches for user based on username and password
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 * @throws InvalidPasswordException
	 */
	public User findUser(String username, String password) throws UserNotFoundException, InvalidPasswordException {

		ListIterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = iterator.next();

			if (user.getUsername().equals(username)) {

				if (!user.getPassword().equals(password)) {
					throw new InvalidPasswordException("Invalid password for user: " + username);
				}

				return user;
			}
		}

		throw new UserNotFoundException("User not found: " + username);
	}

	public GenericLinkedList<User> getUsers() {
		return users;
	}
}
