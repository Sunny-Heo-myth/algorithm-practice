//package programmers;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class August_7th {
//
//	public static void main(String[] args) {
//
//		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//		int[] playCount = {500, 600, 150, 800, 2500};
//
//		int[] result = solution(genres, playCount);
//
//	}
//
//
//    public static int[] solution(String[] genres, int[] plays) {
//
//    	Map<String, Integer> genrePlayMap = new HashMap<>();
//    	for(int i = 0; i < genres.length; i++) {
//
//    		if(!genrePlayMap.containsKey(genres[i])) {
//    			genrePlayMap.put(genres[i], plays[i]);
//    		}else {
//    			int count = genrePlayMap.get(genres[i]);
//    			count += plays[i];
//    			genrePlayMap.put(genres[i], count);
//    		}
//    	}
//
//    	List<Genre> genreList = new ArrayList<>();
//    	for(String i : genrePlayMap.keySet()) {
//    		Genre a = new Genre(i, genrePlayMap.get(i));
//    		genreList.add(a);
//    	}
//
//        List<Genre> sortedGenres = genreList.stream()
//        		.sorted(Comparator.comparing(Genre::getPlayCount).reversed())
//                .collect(Collectors.toList());
//
//        Map<String, List<Song>> genreSongMap = songs.stream()
//                        .sorted(Comparator.comparing(Song::getCount)
//                                          .reversed()
//                                          .thenComparing(Song::getIndex))
//                        .collect(Collectors.groupingBy(Song::getGenre));
//
//List<Integer> answer = new ArrayList<>();
//
//for (Genre genre : sortedGenres) {
//List<Song> genreSongs = genreSongMap.get(genre.getName());
//
//int length = genreSongs.size() > 1 ? 2 : genreSongs.size();
//for (int i = 0; i < length; i++) {
//answer.add(genreSongs.get(i).getIndex());
//}
//}
//return answer.stream()
//.mapToInt(Integer::intValue)
//.toArray();
//}
//
//    	return null;
//    }
//}
//
//class Song {
//	String genre;
//	int playCount;
//	int index;
//
//	public Song(String genre, int playCount, int index) {
//		super();
//		this.genre = genre;
//		this.playCount = playCount;
//		this.index = index;
//	}
//
//}
//
//class Genre{
//	String name;
//	int count;
//
//	public Genre(String name, int count) {
//		super();
//		this.name = name;
//		this.count = count;
//	}
//
//}