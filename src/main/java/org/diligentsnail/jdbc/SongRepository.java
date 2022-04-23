package org.diligentsnail.jdbc;

import java.util.List;
import java.util.Optional;

public interface SongRepository {
	Optional<Song> findById(long id);

	List<Song> findAll();

	List<Song> findByArtist(String artist);

	void saveOne(Song song);

	void deleteById(long id);
}
