package org.diligentsnail.jdbc;

import java.util.List;
import java.util.Optional;

public class JdbcSongRepository implements SongRepository {
	@Override
	public Optional<Song> findById(long id) {
		// getConnection
		// prepareStatement
		// select * froms songs where id = id
		// executeQuery
		// Results -> Song
		return Optional.empty();
	}

	@Override
	public List<Song> findAll() {
		return null;
	}

	@Override
	public List<Song> findByArtist(String artist) {
		return null;
	}

	@Override
	public void saveOne(Song song) {

	}

	@Override
	public void deleteById(long id) {

	}
}
