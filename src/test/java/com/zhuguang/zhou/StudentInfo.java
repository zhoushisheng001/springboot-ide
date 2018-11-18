package com.zhuguang.zhou;

public class StudentInfo {

    private String id;

    private String sex;

    private String name;

    public static class StudentBuild {
        StudentInfo student = new StudentInfo();

        private Integer age;

        public StudentBuild buildId(String id) {
            student.id = id;
            return this;
        }

        public StudentBuild buildSex(String sex) {
            student.sex = sex;
            return this;
        }

        public StudentBuild buildName(String name) {
            student.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "StudentBuild{" +
                    "student=" + student +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id='" + id + '\'' +
                ", age='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
