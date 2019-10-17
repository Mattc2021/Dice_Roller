
package project_1;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project_1 {
    
    
    public static void main(String[] args) throws IOException {
        
        final int TRADITIONAL = 11;
        final int ONLINE = 7;
        ArrayList<Course> catalog = new ArrayList<>();
        ArrayList<Course> trialSchedule = new ArrayList<>();
        ArrayList<Online> oClass = new ArrayList<>();
        String line;       
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(Paths.get("project1input.csv"), "UTF-8");
            
            while (in.hasNextLine()){
                line = in.nextLine();
                data = new ArrayList(Arrays.asList(line.split("\t")));
                
                if (data.size() == TRADITIONAL){
                    String courseName = data.get(0);
                    int CRN = Integer.parseInt(data.get(1));
                    String courseNumber = data.get(2);
                    String sectionNumber = data.get(3);
                    int credits = Integer.parseInt(data.get(4));
                    String[] startTime = data.get(5).split(":");
                    int startHour = Integer.parseInt(startTime[0]);
                    int startMin = Integer.parseInt(startTime[1]);
                    LocalTime startTime_2 = LocalTime.of(startHour, startMin);
                    String[] endTime = data.get(6).split(":");
                    int endHour = Integer.parseInt(endTime[0]);
                    int endMin = Integer.parseInt(endTime[1]);
                    LocalTime endTime_2 = LocalTime.of(endHour, endMin);
                    String days = data.get(7);
                    String location = data.get(8);
                    String courseType = data.get(9);
                    String instructor = data.get(10);
                    Course newCourse = new Traditional(courseName, CRN, courseNumber, sectionNumber, credits, startTime_2, endTime_2, days, location, courseType, instructor);
                    
                    catalog.add(newCourse);                    
                }
                else if (data.size() == ONLINE){
                    String courseName = data.get(0);
                    int CRN = Integer.parseInt(data.get(1));          
                    String courseNumber = data.get(2);
                    String sectionNumber = data.get(3);
                    int credits = Integer.parseInt(data.get(4));
                    String courseType = data.get(5);
                    String instructor = data.get(6);
                    Course newOCourse = new Online(courseName, CRN, courseNumber, sectionNumber, credits, courseType, instructor);
                    catalog.add(newOCourse);
                }
            }
            in.close();
        }
        catch(IOException e){
            System.err.println(e.toString());
        }
        
        boolean exit = false;
        while(!exit){
            System.out.println();
            System.out.println("1) Search Courses");
            System.out.println("2) Register for Course");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");
            System.out.println("Your Choice");
            System.out.println();
            
            Scanner input1 = new Scanner(System.in);
            int choice = input1.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter course number in the format SS NNN (for example, CS 201:");
                    Scanner input = new Scanner(System.in);
                    String search = input.nextLine();
                    search = search.toUpperCase();
                    int trial = 1;
                    for (int i =0; i < catalog.size(); i++){
                        if (catalog.get(i).getCourseNumber().indexOf(search) >= 0){
                            System.out.println(catalog.get(i).toString());
                            trial = 0;
                        }
                        if(trial == 1){
                            System.out.println("Can't find course");          
                        }
                    }                    
                    break;
                case 2:
                    System.out.println("Enter CRN number: ");
                    Scanner inputCRN = new Scanner(System.in);
                    int gotCRN = inputCRN.nextInt();
                    int trial2 = 1;
                    boolean conflicts = false;
                    for(int n = 0; n < catalog.size(); n++){
                        if(catalog.get(n).getCrn() == (gotCRN)){
                            if(trialSchedule.size() >= 1){
                                for(Course c : trialSchedule){
                                    if(c.ConflictsWith(catalog.get(n))){
                                        conflicts = true;                                        
                                    }
                                }
                                if(conflicts = false){
                                    trialSchedule.add(catalog.get(n));
                                    System.out.println("Course added successfully!");
                                }
                                else{
                                    System.out.println("Course onflicts with a different class or course not found");
                                }
                                    
                                
                            }
                            else{
                                trialSchedule.add(catalog.get(n));
                                System.out.println("Course added Successfully!");
                            }                            
                        }                            
                    }
                    break;
                case 3:
                    for(Course c : trialSchedule){
                        System.out.println(c);
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("ERROR: wrong number try again");
                    break;
            }
            
        }

        
        
        
    }
    
}
