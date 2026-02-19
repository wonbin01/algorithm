import java.util.*;
public class P42840 {
    class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[] {1,2,3,4,5};
        int[] second = new int[] {2,1,2,3,2,4,2,5};
        int[] third = new int[] {3,3,1,1,2,2,4,4,5,5};
        int firstAnswer=0; int secondAnswer=0; int thirdAnswer=0;
        ArrayList<Student> al = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<answers.length;i++) {
            int firstIndex = i%first.length;
            int secondIndex = i%second.length;
            int thirdIndex = i%third.length;
            if(answers[i]==first[firstIndex]) {
                firstAnswer++;
            }
            if(answers[i]==second[secondIndex]) {
                secondAnswer++;
            }
            if(answers[i]==third[thirdIndex]) {
                thirdAnswer++;
            }
        }
        al.add(new Student(1, firstAnswer));
        al.add(new Student(2, secondAnswer));
        al.add(new Student(3, thirdAnswer));
        Collections.sort(al, (a,b) -> {
            if(a.answer == b.answer) {
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(b.answer, a.answer);
        });
        int maxValue = al.get(0).answer;
        for(Student s : al) {
            if(s.answer == maxValue) {
                result.add(s.index);
            }
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    class Student {
        int index;
        int answer;
        Student(int index, int answer) {
            this.index = index;
            this.answer = answer;
        }
    }
}
}