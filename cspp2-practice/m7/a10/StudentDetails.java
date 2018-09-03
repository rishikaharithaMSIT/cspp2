/**
 * Class for student.
 */
class Student {
    /**
     * { var_description }.
     */
    private String studentName;
    /**
     * { var_description }.
     */
    private String rollNumber;
    /**
     * { var_description }.
     */
    private final int thre = 3;
    /**
     * { var_description }.
     */
    private float[] marks = new float[thre];

    /**
     * Constructs the object.
     */
    Student() {

    }
    /**
     * Sets the student name.
     *
     * @param      studentName  The student name
     */
    void setStudentName(final String studentName) {
        this.studentName = studentName;
    }
    /**
     * Gets the student name.
     *
     * @return     The student name.
     */
    String getStudentName() {
        return this.studentName;
    }
    /**
     * Sets the roll number.
     *
     * @param      rollNumber  The roll number
     */
    void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    /**
     * Gets the roll number.
     *
     * @return     The roll number.
     */
    String getRollNumber() {
        return this.rollNumber;
    }
    /**
     * Constructs the object.
     *
     * @param      studentName  The student name
     * @param      rollNumber   The roll number
     * @param      marks1       The marks 1
     * @param      marks2       The marks 2
     * @param      marks3       The marks 3
     */
    Student(final String studentName, final String rollNumber,
            final float marks1,
            final float marks2, final float marks3 ) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        marks[0] = marks1;
        marks[1] = marks2;
        marks[2] = marks3;
    }

    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public float gpa() {
        final float three = 3.0f;
        float avg = (marks[0] + marks[1] + marks[2]) / three;
        return avg;
    }

}

/**
 * Class for student details.
 */
public class StudentDetails {
    /**
     * Constructs the object.
     */
    private StudentDetails() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final float sevenPointfive = 7.5f;
        final float sevenPointZero = 7.0f;
        final float eightPointZero = 8.0f;
        final float eightPointfive = 8.5f;
        final float sixPointZero = 6.0f;
        final float ninePointZero = 9.0f;
        Student student1 = new Student("Sangay", "IT201985001",
                                       sevenPointfive,
                                       sevenPointZero, eightPointZero);
        Student student2 = new Student("Bidhya", "IT201985003",
                                       eightPointfive,
                                       sixPointZero, sevenPointfive);
        Student student3 = new Student("Kelzang", "IT201985065",
                                       sevenPointfive,
                                       eightPointZero, ninePointZero);
        System.out.println(student1.getStudentName() + " - "
                           + student1.getRollNumber() + " - "
                           + student1.gpa());
        System.out.println(student2.getStudentName()  + " - "
                           + student2.getRollNumber() + " - "
                           + student2.gpa());
        System.out.println(student3.getStudentName()  + " - "
                           + student3.getRollNumber() + " - "
                           + student3.gpa());
    }
}
