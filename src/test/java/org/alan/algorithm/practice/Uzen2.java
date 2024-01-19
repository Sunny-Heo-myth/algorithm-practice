package org.alan.algorithm.practice;

import java.util.List;

public class Uzen2 {

    // 선택한 상품의 총 가격이 30000 원 이상인 경우에만 포인트를 사용할 수 있습니다.
    // 선택한 상품 목록을 입력받아, 포인트 사용 가능 여부를 리턴하는 함수를 작성하세요.
    // 포인트 사용이 가능하면 true, 그렇지 않으면 false 를 리턴해야 합니다.
    private static boolean isAbleToUsePoint(List<SelectedItem> items) {
        return items.stream().mapToInt(item -> item.price * item.count).sum() >= 30000;
    }

    public static void main(String[] args) {

        // 입력 예 1
        var items1 = List.of(
                new SelectedItem("U0001", 5000, 2),
                new SelectedItem("U0002", 2000, 3));
        var result1 = isAbleToUsePoint(items1);
        System.out.println("result1=" + result1); // false 가 출력되어야 함.

        // 입력 예 2
        var items2 = List.of(
                new SelectedItem("U0003", 5000, 2),
                new SelectedItem("U0004", 2000, 3),
                new SelectedItem("U0005", 7000, 3));
        var result2 = isAbleToUsePoint(items2);
        System.out.println("result2=" + result2); // true 가 출력되어야 함.
    }

    // SelectedItem 은 상품코드, 단가(1개의 가격), 선택한 개수를 갖고 있습니다.
    public static class SelectedItem {

        // 상품코드
        private String itemCode;

        // 단가(1개의 가격)
        private int price;

        // 선택한 개수
        private int count;

        public SelectedItem(String itemCode, int price, int count) {
            this.itemCode = itemCode;
            this.price = price;
            this.count = count;
        }

        public String getItemCode() {
            return itemCode;
        }

        public int getPrice() {
            return price;
        }

        public int getCount() {
            return count;
        }
    }
}
