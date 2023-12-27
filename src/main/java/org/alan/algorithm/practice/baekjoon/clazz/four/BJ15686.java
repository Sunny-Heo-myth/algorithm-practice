package org.alan.algorithm.practice.baekjoon.clazz.four;

import java.util.*;
import java.util.regex.Pattern;

public class BJ15686 {
    private int numberOfSurvivedShop;
    private final Map<String, Map<String, Integer>> shopHousesMap = new HashMap<>();
    private final List<String> shops = new ArrayList<>();
    private final List<String> houses = new ArrayList<>();
    private final List<String> chosenShop = new ArrayList<>();
    private int answer = Integer.MAX_VALUE;

    public String solve(String input) {
        String[] lines = input.split("\n");
        numberOfSurvivedShop = Integer.parseInt(lines[0].split(" ")[1]);
        int[][] map = Arrays.stream(lines).skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        for (int i = 0; i < map.length; i++) for (int j = 0; j < map.length; j++) {
            String id = i + " " + j;
            if (map[i][j] == 1) houses.add(id);
            if (map[i][j] == 2) shops.add(id);
        }

        shops.forEach(shopId -> {
            shopHousesMap.put(shopId, new HashMap<>());
            houses.forEach(houseId -> shopHousesMap.get(shopId).put(houseId, calculateDistance(shopId, houseId)));
        });

        shopCombination(0);
        return String.valueOf(answer);
    }

    private int calculateDistance(String shopId, String houseId) {
        String[] shop = shopId.split(" ");
        String[] house = houseId.split(" ");
        return Math.abs(Integer.parseInt(shop[0]) - Integer.parseInt(house[0])) + Math.abs(Integer.parseInt(shop[1]) - Integer.parseInt(house[1]));
    }

    private void shopCombination(int index) {
        if (chosenShop.size() == numberOfSurvivedShop) {
            answer = Math.min(answer, calculateSumOfChickenDistance(chosenShop));
            return;
        }

        for (int i = index; i < shops.size(); i++) {
            chosenShop.add(shops.get(i));
            shopCombination(i + 1);
            chosenShop.remove(chosenShop.size() - 1);
        }
    }

    private int calculateSumOfChickenDistance(List<String> chosenShops) {
        return houses.stream()
                .mapToInt(houseId -> chosenShops.stream()
                        .map(shopId -> shopHousesMap.get(shopId).get(houseId))
                        .min(Integer::compareTo).orElse(0))
                .sum();
    }
}
