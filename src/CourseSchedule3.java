import java.util.*;

public class CourseSchedule3 {

    static class Course {
        int dur;
        int last;

        public Course (int dur, int last) {
            this.dur = dur;
            this.last = last;
        }
    }

    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        List<Course> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            int dur = courses[i][0];
            int last = courses[i][1];
            list.add(new Course (dur, last));
        }
        Collections.sort(list, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if (o1.last == o2.last){
                    return o1.dur - o2.dur;
                }
                return o1.last - o2.last;
            }
        });
        PriorityQueue<Course> pq = new PriorityQueue<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o2.dur - o1.dur;
            }
        });
        int sum = 0;
        for (Course i : list){
            pq.add(i);
            sum += i.dur;
            while (sum > i.last){
                sum -= pq.poll().dur;
            }
        }
        return pq.size();
    }
}
