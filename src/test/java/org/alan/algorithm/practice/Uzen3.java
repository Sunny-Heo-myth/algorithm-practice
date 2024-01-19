package org.alan.algorithm.practice;

import java.util.List;
import java.util.Stack;

public class Uzen3 {
    // categories 에서 categoryCode 에 해당하는 카테고리의 카테고리명을 리턴한다.
    // categoryCode 에 해당하는 카테고리가 존재하지 않으면, null 을 리턴한다.
    private static String findCategoryName(List<Category> categories, String categoryCode) {
        Stack<Category> stack = new Stack<>();
        categories.forEach(stack::push);

        while (!stack.isEmpty()) {
            Category popped = stack.pop();
            if (popped.getCategoryCode().equals(categoryCode)) {
                return popped.getCategoryName();
            }

            if (popped.getChildren() != null) {
                popped.getChildren().forEach(stack::push);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        // 카테고리는 아래처럼 트리 구조입니다.
        //
        // - 001 의류
        //   - 001001 상의
        //     - 001001001 긴팔
        //     - 001001002 반팔
        //   - 001002 하의
        //     - 001002001 긴바지
        //     - 001002002 반바지
        // - 002 슈즈
        //   - 002001 캠핑
        //   - 002002 트레킹
        //   - 002003 시즌
        // - 003 악세사리
        //   - 003001 모자
        //     - 003001001 쉐이드
        //     - 003001002 캡
        //     - 003001003 버킷/사파리
        //   - 003002 양말
        //
        List<Category> categories = List.of(
                new Category("001", "의류", List.of(
                        new Category("001001", "상의", List.of(
                                new Category("001001001", "긴팔", null),
                                new Category("001001002", "반팔", null))),
                        new Category("001002", "하의", List.of(
                                new Category("001002001", "긴바지", null),
                                new Category("001002002", "반바지", null))))),
                new Category("002", "슈즈", List.of(
                        new Category("002001", "캠핑", null),
                        new Category("002002", "트레킹", null),
                        new Category("002003", "시즌", null))),
                new Category("003", "악세사리", List.of(
                        new Category("003001", "모자", List.of(
                                new Category("003001001", "쉐이드", null),
                                new Category("003001002", "캡", null),
                                new Category("003001003", "버킷/사파리", null))),
                        new Category("003002", "양말", null))));

        String name001 = findCategoryName(categories, "001");
        System.out.println("001 : " + name001);

        String name003001002 = findCategoryName(categories, "003001002");
        System.out.println("003001002 : " + name003001002);

        String name004 = findCategoryName(categories, "004");
        System.out.println("004 : " + name004);
    }

    public static class Category {

        // 카테고리 코드
        private String categoryCode;

        // 카테고리명
        private String categoryName;

        // 하위 카테고리
        private List<Category> children;

        public Category(String categoryCode, String categoryName, List<Category> children) {
            this.categoryCode = categoryCode;
            this.categoryName = categoryName;
            this.children = children;
        }

        public String getCategoryCode() {
            return categoryCode;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public List<Category> getChildren() {
            return children;
        }
    }

}
