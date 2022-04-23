CREATE TABLE songs
(
	id           BIGINT       NOT NULL GENERATED
		ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
	title        VARCHAR(512) NOT NULL,
	artist       VARCHAR(512) NOT NULL,
	genre        VARCHAR(255) NOT NULL,
	release_year INTEGER CHECK (release_year > 0),
	UNIQUE (title, artist) -- A B
);


INSERT INTO songs (title, artist, genre, release_year)
VALUES ('Blinding Lights', 'The Weeknd', 'canadian contemporary r&b', 2020),
	   ('Watermelon Sugar', 'Harry Styles', 'pop', 2019),
	   ('Mood (feat. iann dior)', '24kGoldn', 'cali rap', 2021),
	   ('Someone You Loved', 'Lewis Capaldi', 'pop', 2019),
	   ('Perfect', 'Ed Sheeran', 'pop', 2017),
	   ('Believer', 'Imagine Dragons', 'modern rock', 2017),
	   ('lovely (with Khalid)', 'Billie Eilish', 'electropop', 2018),
	   ('Circles', 'Post Malone', 'dfw rap', 2019),
	   ('Shape of You', 'Ed Sheeran', 'pop', 2017),
	   ('Memories', 'Maroon 5', 'pop', 2021),
	   ('Closer', 'The Chainsmokers', 'dance pop', 2016),
	   ('bad guy', 'Billie Eilish', 'electropop', 2019),
	   ('Say You Won''t Let Go', 'James Arthur', 'pop', 2016),
	   ('Lucid Dreams', 'Juice WRLD', 'chicago rap', 2018),
	   ('All of Me', 'John Legend', 'neo soul', 2013),
	   ('7 rings', 'Ariana Grande', 'dance pop', 2019),
	   ('Jocelyn Flores', 'XXXTENTACION', 'emo rap', 2017),
	   ('goosebumps', 'Travis Scott', 'rap', 2016),
	   ('Wake Me Up', 'Avicii', 'dance pop', 2013),
	   ('ROCKSTAR (feat. Roddy Ricch)', 'DaBaby', 'north carolina hip hop', 2020),
	   ('rockstar (feat. 21 Savage)', 'Post Malone', 'dfw rap', 2018),
	   ('Photograph', 'Ed Sheeran', 'pop', 2014),
	   ('SAD!', 'XXXTENTACION', 'emo rap', 2018),
	   ('SICKO MODE', 'Travis Scott', 'rap', 2018),
	   ('Stressed Out', 'Twenty One Pilots', 'modern rock', 2015),
	   ('Roses - Imanbek Remix', 'SAINt JHN', 'melodic rap', 2019),
	   ('The Box', 'Roddy Ricch', 'melodic rap', 2019),
	   ('The Hills', 'The Weeknd', 'canadian contemporary r&b', 2015),
	   ('Sunflower - Spider-Man: Into the Spider-Verse', 'Post Malone', 'dfw rap', 2018),
	   ('Thinking out Loud', 'Ed Sheeran', 'pop', 2014),
	   ('Starboy', 'The Weeknd', 'canadian contemporary r&b', 2016),
	   ('Love Yourself', 'Justin Bieber', 'canadian pop', 2015),
	   ('Something Just Like This', 'The Chainsmokers', 'dance pop', 2017),
	   ('Shallow', 'Lady Gaga', 'dance pop', 2018),
	   ('Thunder', 'Imagine Dragons', 'modern rock', 2017),
	   ('XO Tour Llif3', 'Lil Uzi Vert', 'melodic rap', 2017),
	   ('Take Me To Church', 'Hozier', 'irish singer-songwriter', 2014),
	   ('Happier', 'Marshmello', 'brostep', 2018),
	   ('"thank u, next"', 'Ariana Grande', 'dance pop', 2019),
	   ('Counting Stars', 'OneRepublic', 'dance pop', 2013),
	   ('Can''t Hold Us - feat. Ray Dalton', 'Macklemore & Ryan Lewis', 'pop rap', 2012),
	   ('Señorita', 'Shawn Mendes', 'canadian pop', 2019),
	   ('God''s Plan', 'Drake', 'canadian hip hop', 2018),
	   ('Don''t Start Now', 'Dua Lipa', 'dance pop', 2020),
	   ('Bohemian Rhapsody - Remastered 2011', 'Queen', 'classic rock', 1975),
	   ('HUMBLE.', 'Kendrick Lamar', 'conscious hip hop', 2017),
	   ('Let Me Love You', 'DJ Snake', 'dance pop', 2016),
	   ('Congratulations', 'Post Malone', 'dfw rap', 2016),
	   ('Stay With Me', 'Sam Smith', 'dance pop', 2014),
	   ('Treat You Better', 'Shawn Mendes', 'canadian pop', 2017),
	   ('Uptown Funk (feat. Bruno Mars)', 'Mark Ronson', 'dance pop', 2015),
	   ('I Like Me Better', 'Lauv', 'dance pop', 2018),
	   ('when the party''s over', 'Billie Eilish', 'electropop', 2019),
	   ('Mr. Brightside', 'The Killers', 'alternative rock', 2004),
	   ('Dance Monkey', 'Tones And I', 'australian pop', 2019),
	   ('Havana (feat. Young Thug)', 'Camila Cabello', 'dance pop', 2018),
	   ('Better Now', 'Post Malone', 'dfw rap', 2018),
	   ('I Don''t Care (with Justin Bieber)', 'Ed Sheeran', 'pop', 2019),
	   ('Unforgettable', 'French Montana', 'gangster rap', 2017),
	   ('Too Good At Goodbyes', 'Sam Smith', 'dance pop', 2017),
	   ('Riptide', 'Vance Joy', 'folk-pop', 2014),
	   ('That''s What I Like', 'Bruno Mars', 'dance pop', 2016),
	   ('See You Again (feat. Charlie Puth)', 'Wiz Khalifa', 'dance pop', 2015),
	   ('One Kiss (with Dua Lipa)', 'Calvin Harris', 'dance pop', 2018),
	   ('Heathens', 'Twenty One Pilots', 'modern rock', 2016),
	   ('Demons', 'Imagine Dragons', 'modern rock', 2012),
	   ('Youngblood', '5 Seconds of Summer', 'boy band', 2018),
	   ('Old Town Road - Remix', 'Lil Nas X', 'lgbtq+ hip hop', 2019),
	   ('I''m Yours', 'Jason Mraz', 'acoustic pop', 2008),
	   ('Attention', 'Charlie Puth', 'dance pop', 2018),
	   ('New Rules', 'Dua Lipa', 'dance pop', 2017),
	   ('Sorry', 'Justin Bieber', 'canadian pop', 2015),
	   ('Don''t Let Me Down', 'The Chainsmokers', 'dance pop', 2016),
	   ('7 Years', 'Lukas Graham', 'danish pop', 2016),
	   ('I Like It', 'Cardi B', 'dance pop', 2018),
	   ('I Fall Apart', 'Post Malone', 'dfw rap', 2016),
	   ('We Don''t Talk Anymore (feat. Selena Gomez)', 'Charlie Puth', 'dance pop', 2016),
	   ('Can''t Feel My Face', 'The Weeknd', 'canadian contemporary r&b', 2015),
	   ('Despacito', 'Luis Fonsi', 'latin', 2019),
	   ('Psycho (feat. Ty Dolla $ign)', 'Post Malone', 'dfw rap', 2018),
	   ('Stitches', 'Shawn Mendes', 'canadian pop', 2015),
	   ('What Do You Mean?', 'Justin Bieber', 'canadian pop', 2015),
	   ('Wonderwall - Remastered', 'Oasis', 'beatlesque', 1995),
	   ('Radioactive', 'Imagine Dragons', 'modern rock', 2012),
	   ('Eastside (with Halsey & Khalid)', 'benny blanco', 'electropop', 2018),
	   ('Cheerleader - Felix Jaehn Remix Radio Edit', 'OMI', 'dance pop', 2015),
	   ('Cheap Thrills', 'Sia', 'australian dance', 2016),
	   ('Girls Like You (feat. Cardi B) - Cardi B Version', 'Maroon 5', 'pop', 2018),
	   ('Faded', 'Alan Walker', 'electro house', 2015),
	   ('Let Her Go', 'Passenger', 'folk-pop', 2013),
	   ('"CAN''T STOP THE FEELING! (from DreamWorks Animation''s ""TROLLS"")"', 'Justin Timberlake', 'dance pop', 2016),
	   ('Lean On', 'Major Lazer', 'dance pop', 2015),
	   ('Despacito - Remix', 'Luis Fonsi', 'latin', 2019),
	   ('Lose Yourself', 'Eminem', 'detroit hip hop', 2014),
	   ('Without Me (with Juice WRLD)', 'Halsey', 'dance pop', 2019),
	   ('One Dance', 'Drake', 'canadian hip hop', 2016),
	   ('Sugar', 'Maroon 5', 'pop', 2015),
	   ('Emotions', 'Mark Mendy', 'pop dance', 2021),
	   ('Cold Water', 'Major Lazer', 'dance pop', 2018),
	   ('I Took A Pill In Ibiza - Seeb Remix', 'Mike Posner', 'dance pop', 2016);


SELECT *
FROM songs;

SELECT title
FROM songs;

SELECT *
FROM songs
ORDER BY id DESC;

SELECT *
FROM songs
WHERE artist = 'Dua Lipa';

SELECT *
FROM songs
WHERE genre like '%rap%';

SELECT *
FROM songs
WHERE release_year = 2020;

SELECT title, UPPER(title)
FROM songs;

SELECT COUNT(*)
FROM songs;

SELECT artist, COUNT(*) AS c, MIN(release_year)
FROM songs
GROUP BY artist;

INSERT INTO songs(artist, title, release_year, genre)
VALUES ('Billie Eilish', 'everything i wanted', 2020, 'pop');

SELECT *
FROM songs
where artist = 'Billie Eilish';

UPDATE songs
SET genre = 'electropop'
WHERE id = 101;

SELECT *
FROM songs
where id = 101;

DELETE
FROM songs
WHERE id = 101;

SELECT *
FROM songs
where id = 101;

-- DELETE FROM songs;


select *
from songs
where artist = 'Ed Sheeran';


-- null == null
select cast(null as int) = cast(null as int)
FROM SYSIBM.SYSDUMMY1;
select cast(null as int) <> cast(null as int)
FROM SYSIBM.SYSDUMMY1;

select 'abc' || cast(null as varchar(255)) || 'def'
FROM SYSIBM.SYSDUMMY1;

-- FROM DUAL
select 1
FROM SYSIBM.SYSDUMMY1;

select cast(null as int) is not null
FROM SYSIBM.SYSDUMMY1;
select coalesce(cast(null as int), 1)
FROM SYSIBM.SYSDUMMY1;


SELECT s.artist, c, title
FROM SONGS as s
		 INNER JOIN (SELECT COUNT(*), artist FROM songs GROUP BY artist) as t(c, artist) ON s.artist = t.artist
order by c desc, s.artist, title;
;

-- cte = Common Table Expression
-- WITH t() as select
-- select
-- Спасибо Мише
SELECT title, t1.artist, release_year
FROM songs AS t1
		 INNER JOIN (SELECT artist, MAX(release_year) AS publish_year FROM songs GROUP BY artist)
	AS t2 ON t1.artist = t2.artist AND t1.release_year = t2.publish_year
