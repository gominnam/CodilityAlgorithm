package Programmers.Level3;

import java.util.*;

public class BestAlbum {
    public class Album implements Comparable<Album>{
        int index;
        int plays;
        public Album(int i, int p){
            this.index = i;
            this.plays = p;
        }

        @Override
        public int compareTo(Album A){
            return A.plays - this.plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        HashMap<String, Integer> genreTotalPlays = new HashMap<>();
        HashMap<String, ArrayList<Album>> genreAlbums = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genreTotalPlays.put(genres[i], genreTotalPlays.getOrDefault(genres[i], 0)+plays[i]);
            if(!genreAlbums.containsKey(genres[i])){
                genreAlbums.put(genres[i], new ArrayList<>());
            }
            genreAlbums.get(genres[i]).add(new Album(i, plays[i]));
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(genreTotalPlays.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            ArrayList<Album> albums = genreAlbums.get(list.get(i).getKey());
            Collections.sort(albums);
            int count = 0;
            for(Album a : albums){
                if(++count > 2) break;
                result.add(a.index);
            }
        }

        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        BestAlbum ba = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        for(int i : ba.solution(genres, plays)){
            System.out.print(i + " ");
        }
    }
}
/*
feed back:

HashMap 정렬하는 방법

1. 오름차순

List<Map.Entry<String, Integer>> list = new ArrayList<>(genreTotalPlays.entrySet());
Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));


2. 내림차순

List<Map.Entry<String, Integer>> list = new ArrayList<>(genreTotalPlays.entrySet());
Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

 */