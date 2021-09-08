package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> result = new LinkedList<>();
//        getCombination(result, 1, n, new LinkedList<>(), k);
//        return result;
//    }
//
//    private void getCombination(List<List<Integer>> result, int from, int to, List<Integer> currentList, int k) {
//        if (from > to || currentList.size() > k) return;
//        for (int i=from; i<=to; i++) {
//            List<Integer> list = new LinkedList<>(currentList);
//            list.add(i);
//            if (list.size() == k) {
//                result.add(list);
//            }
//            getCombination(result, i+1, to, list, k);
//        }
//    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        getCombination(result, 1, n, new ArrayList<Integer>(), k);
        return result;
    }

    private void getCombination(List<List<Integer>> result, int from, int to, List<Integer> list, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=from; i<=to - list.size() + k - 1; i++) {
            list.add(i);
            getCombination(result, i+1, to, list, k);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations sol = new Combinations();
        System.out.println(sol.combine(4, 2));
        System.out.println(sol.combine(5,3));
    }
}
