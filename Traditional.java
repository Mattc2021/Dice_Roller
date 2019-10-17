
package project_1;

import java.time.LocalTime;


public class Traditional extends Course {
    private String days;
    private String location;
    private LocalTime startTime;
    private LocalTime endTime;
    
    Traditional(String courseName, int CRN, String courseNumber, String sectionNumber, int credits, LocalTime startTime, LocalTime endTime, String days, String location, String courseType, String instructors){
        super(courseName,CRN,courseNumber,sectionNumber,instructors,credits,courseType);
        this.days = days;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    @Override
    public String toString(){
        StringBuilder t = new StringBuilder();
        t.append("#").append(super.getCrn()).append(": ");
        t.append(super.getCourseNumber()).append(" ");
        t.append(super.getSectionNumber()).append(" (");
        t.append(super.getCourseName()).append("), ");
        t.append(super.getInstructor()).append(", ");
        t.append(super.getCredits()).append(", ");
        t.append(super.getCourseType()).append(", ");
        t.append(getStartTime()).append(" - ").append(getEndTime()).append(", ");
        t.append(getDays()).append(", ");
        t.append(getLocation());
        return t.toString();
    }

    @Override
   public boolean ConflictsWith(Course Test){
       boolean conflictsWith = false;
       String a = getDays();
       String b = ((Traditional) Test).getDays();
       LocalTime first = getStartTime();
       LocalTime second = getEndTime();
       LocalTime c = ((Traditional) Test).getStartTime();
       LocalTime d = ((Traditional) Test).getStartTime();
       if (Test instanceof Traditional){
           for (int t = 0; t < a.length(); t++){
               for (int m =0; m < b.length(); m++){
                   if (a.charAt(t) == b.charAt(m)){
                       if(first.isBefore(c) && second.isAfter(c)){
                           conflictsWith = true;
                       }
                       if(first.isBefore(d) && second.isAfter(d)){
                           conflictsWith = true;
                       }
                       if(second.isBefore(d) && first.isAfter(c)){
                           conflictsWith = true;
                       }
                       if(first.equals(c) && second.equals(d)){
                           conflictsWith = true;
                       }
                   }
                   
               
           }
           }
       }
       return conflictsWith;
   }
    

    
    
}
