package easy;

public class NumberofStudentsUnabletoEatLunch {
    public int countStudents_v2(int[] students, int[] sandwiches) {
        int[] studentCount = {0, 0};
        for (int i: students) {
            studentCount[i]++;
        }
        int i;
        for (i = 0; i < sandwiches.length; i++) {
            if (studentCount[sandwiches[i]] > 0) {
                studentCount[sandwiches[i]]--;
            } else {
                break;
            }
        }
        return sandwiches.length - i;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int remainStudents = students.length;
        int numTry = 0;
        int i=0, j=0;
        while (j < sandwiches.length) {
            if (students[i] == sandwiches[j]) {
                students[i] = -1;
                remainStudents--;
                j++;
                numTry = 0;
            } else if (students[i] != -1){
                numTry++;
                if (numTry == remainStudents) {
                    return remainStudents;
                }
            }
            i = (i + 1) % students.length;
        }
        return 0;
    }
}
