package Collections;

import java.util.*;

    class Student
    {
        String name;
        Double score;
        Double age;

        public Student(String name, Double score, Double age) {
            this.name = name;
            this.score = score;
            this.age = age;
        }
        public String toString()
        {
            return "{ Name: "+name+", Score: "+score+", Age: "+age+"}";
        }
    }
    class ScoreComparator implements Comparator<Student>
    {

        @Override
        public int compare(Student student, Student t1) {
            if(Double.compare(student.score,t1.score)<0) //student < d1
            {
                return 1;
            }
            else if(Double.compare(student.score,t1.score)==0) //student==0
            {
                System.out.println("same");
                return student.name.compareTo(t1.name);
            }
            else { //student >d1
                return -1;
            }
        }
    }
    public class Q6 {
        public static void main(String[] args) {
            List<Student> list=new ArrayList<>();
            list.add(new Student("ankit",60.0,23.0));
            list.add(new Student("manna",70.0,22.0));
            list.add(new Student("sagar",60.9,21.0));
            list.add(new Student("shivam",60.9,20.0));
            list.add(new Student("azeem",68.0,28.0));

            Collections.sort(list,new ScoreComparator());

            for(Student s:list)
                System.out.println(s);
        }
    }

