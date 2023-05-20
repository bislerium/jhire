// this is a sub-class & inherits StaffHire class.
public class FullTimeStaffHire extends StaffHire
{
    //Declaring private variable with data type
    private float salary;
    private float workingHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    /*
     Initializing five attributes in the constructor.
     Those five attributes are vacancyNumber, designation, jobType, salary
     & workingHour.
     */
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, float salary, float workingHour)
    {
        super(vacancyNumber, designation, jobType);
        this.salary = salary;
        this.workingHour = workingHour;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
    }

    //getter method is being used and it returns corresponding attributes 
    public float getSalary()
    {
        return salary;
    }

     public float getWorkingHour()
    {
        return workingHour;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public String getJoiningDate()
    {
        return joiningDate;
    }

    public String getQualification()
    {
        return qualification;
    }

    public String getAppointedBy()
    {
        return appointedBy;
    }

    public Boolean getJoined()
    {
        return joined;
    }

     /*
      setter method is used to update the value as new salary or 
      more specifically, assigns a new integer value in variable salary, 
      only if the staff hasn't joined
      */
    public void salaryChanges(int salary)
    {
        if(joined == true)
        {
            System.out.println("Sorry! Not possible to Change Salary");
        }
        else
        {
            this.salary=salary;
            System.out.println("The salary is updated");
        }
    }

    /*
     Setter method is used to update to new working hour. or 
     more specifically, assigns a new integer value to workingHour.    
     */
    public void new_WorkingHours(int workingHour)
    {
        this.workingHour=workingHour;
        System.out.println("The Working hour is successfully updated");
    }

    /*
     The method has four parameters (i.e. staffName, qualification, joinigDate, appointedBy) 
     The corresponding value passed through each parameters get assigned to
     corresponding varaible, only if the joined condition is false.
     */
    public void fullTime_Staff_Hire(String staffName, String qualification, String joiningDate, String appointedBy)
    {
        if (joined == true)
        {
            System.out.println(this.getStaffName() + " "+ "has already Joined on" + " " + this.getJoiningDate());
        }
        else
        {
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = true;
        //System.out.println("The staff is successfully added");
        }
    }

    /*
     This method displays the detail information of Full time staff, 
     only if the joined condition is true.
     this method also has super class method which calls display from StaffHire.
     */
    public void display()
    {
        //System.out.println("\t" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        super.display();
        if (joined == true)
        {
            System.out.println("\t\t" + "---------------------------------");
            System.out.println("\t\t" + "Staff name      : "+getStaffName() );
            System.out.println("\t\t" + "Salary          : "+getSalary());
            System.out.println("\t\t" + "working hour    : "+getWorkingHour());
            System.out.println("\t\t" + "Joining date    : "+getJoiningDate());
            System.out.println("\t\t" + "Qualification   : "+getQualification());
            System.out.println("\t\t" + "Appointed by    : "+getAppointedBy());
            //System.out.println("\t" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        }else{
            System.out.println("\t\t" + "The Staff hasn't joined yet"); 
            //System.out.println("\t" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        }
    }
}
 