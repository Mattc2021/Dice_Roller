
package project_1;

public abstract class Course {
    private String courseName;
    private int crn;
    private String courseNumber;
    private String sectionNumber;
    private String instructor;
    private int credits;
    private String courseType;

    public Course(String courseName, int crn, String courseNumber, String sectionNumber, String instructor, int credits, String courseType) {
        this.courseName = courseName;
        this.crn = crn;
        this.courseNumber = courseNumber;
        this.sectionNumber = sectionNumber;
        this.instructor = instructor;
        this.credits = credits;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    
    @Override
    public abstract String toString();
    
    public abstract boolean ConflictsWith(Course Test);
    
    
    
    
    
    
    
}
