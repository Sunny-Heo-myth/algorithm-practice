package org.alan.algorithm.first;

import java.util.*;
import java.util.stream.Collectors;

public class August_7th {

    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] playCount = {500, 600, 150, 800, 2500};

        int[] result = solution(genres, playCount);

    }


    public static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {

            if (!genrePlayMap.containsKey(genres[i])) {
                genrePlayMap.put(genres[i], plays[i]);
            } else {
                int count = genrePlayMap.get(genres[i]);
                count += plays[i];
                genrePlayMap.put(genres[i], count);
            }
        }

        List<Genre> genreList = new ArrayList<>();
        for (String i : genrePlayMap.keySet()) {
            Genre a = new Genre(i, genrePlayMap.get(i));
            genreList.add(a);
        }

        List<Genre> sortedGenres = genreList.stream()
                .sorted(Comparator.comparing(Genre::getPlayCount).reversed())
                .collect(Collectors.toList());

		// todo:
		List<Song> songs = new ArrayList<>();
        Map<String, List<Song>> genreSongMap = songs.stream()
                .sorted(Comparator.comparing(Song::getCount)
                        .reversed()
                        .thenComparing(Song::getIndex))
                .collect(Collectors.groupingBy(Song::getGenre));

        List<Integer> answer = new ArrayList<>();

        for (Genre genre : sortedGenres) {
            List<Song> genreSongs = genreSongMap.get(genre.getName());

            int length = genreSongs.size() > 1 ? 2 : genreSongs.size();
            for (int i = 0; i < length; i++) {
                answer.add(genreSongs.get(i).getIndex());
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}


class Song {
    String genre;
    int playCount;
    int index;
	int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Song(String genre, int playCount, int index) {
        super();
        this.genre = genre;
        this.playCount = playCount;
        this.index = index;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

class Genre {
    String name;
    int playCount;

    public Genre(String name, int playCount) {
        super();
        this.name = name;
        this.playCount = playCount;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
}