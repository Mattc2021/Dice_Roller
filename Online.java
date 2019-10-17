
package project_1;


public class Online extends Course {
    
    public Online(String courseName, int CRN, String courseNumber, String sectionNumber,int credits, String courseType, String instructor){
        super(courseName, CRN, courseNumber, sectionNumber, instructor, credits, courseType);
    }
   
    
    @Override
    public boolean ConflictsWith(Course Test){
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder o = new StringBuilder();
        o.append("#").append(super.getCrn()).append(": ");
        o.append(super.getCourseNumber()).append(" ");
        o.append(super.getSectionNumber()).append(" (");
        o.append(super.getCourseName()).append(") ");
        o.append(super.getInstructor()).append(" ");
        o.append(super.getCredits()).append(" ");
        o.append(super.getCourseType()).append(" ");
        return o.toString();
    }
    
    
}
