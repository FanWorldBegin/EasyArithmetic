package org.example.sort;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student){

        if(this == student)
            return true;

        if(student == null)
            return false;

        if(this.getClass() != student.getClass())
            return false;

        Student another = (Student)student;
        return this.name.equals(another.name);
    }

    @Override
    //需要实现Comparable 接口的 compareTo 方法
    public int compareTo(Student anotherStudent) {
//        if(this.score < anotherStudent.score)
//            return -1;
//        else if(this.score > anotherStudent.score)
//            return 1;
//        return 1;
        return this.score - anotherStudent.score;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
