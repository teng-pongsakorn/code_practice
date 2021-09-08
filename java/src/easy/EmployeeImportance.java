package easy;

import java.util.*;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int totalImportance = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.poll();
            totalImportance += employee.importance;
            for (int subId: employee.subordinates) {
                queue.add(map.get(subId));
            }
        }
        return totalImportance;
    }

    public int getImportance_v1(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        return helper(map, id);

    }

    private int helper(Map<Integer, Employee> map, int id) {
        int totalImportnace = map.get(id).importance;
        for (int subId: map.get(id).subordinates) {
            totalImportnace += helper(map, subId);
        }
        return totalImportnace;
    }
}
