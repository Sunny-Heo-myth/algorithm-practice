package org.alan.algorithm.practice.programmers.bestalbum;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
    private int[] plays;
    public int[] solution(String[] genres, int[] plays) {
        this.plays = plays;
        Map<String, Album> albumList = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            if (!albumList.containsKey(genre)) {
                albumList.put(genre, new Album(new ArrayList<>(), 0));
            }
            albumList.get(genre).addSong(i);
        }

        List<Album> albums = albumList.keySet().stream()
                .map(albumList::get)
                .sorted(Comparator.comparingInt(album -> -album.totalPlayCount))
                .collect(Collectors.toList());

        List<Integer> answer = new LinkedList<>();
        albums.forEach(album -> {
                    List<Integer> candidates = album.songList;
                    answer.addAll(candidates.size() >= 2 ? candidates.subList(0, 2) : candidates.subList(0, 1));
                });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Album {
        private List<Integer> songList;
        private int totalPlayCount;

        private Album(List<Integer> songList, int totalPlayCount) {
            this.songList = songList;
            this.totalPlayCount = totalPlayCount;
        }

        private void addSong(int idx) {
            songList.add(idx);
            totalPlayCount += plays[idx];
            songList = songList.stream()
                    .sorted(Comparator.comparingInt(i -> -plays[i]))
                    .collect(Collectors.toList());
        }
    }

}
