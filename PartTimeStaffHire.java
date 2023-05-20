// this is a sub-class & inherits StaffHire class.
public class PartTimeStaffHire extends StaffHire
{
    private float workingHour;
    private float wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;

    /*
    Initializing six attributes in the constructor. 
    and those attributes are vacancyNumber, designation, jobType, workingHour,
    wagesPerHour & shifts
     */
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, float workingHour, float wagesPerHour, String shifts){
        super(vacancyNumber, designation, jobType);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.staffName = "";
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined = false;
        this.terminated = true;
    }

    //getter method is being used and it returns corresponding attributes 
    public float getWorkingHour()
    {
        return workingHour;
    }

    public float getWagesPerHour()
    {
        return wagesPerHour;
    }

    public String getShifts()
    {
        return shifts;
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

    public Boolean getTerminated()
    {
        return terminated;
    }

    /*
    This method is used to update the shift or more specifically, 
    assigns a new value to the variable shifts.
    only if the joined condition is true.
     */
    public void shiftsChange(String shifts)
    {
        if(joined == true)
        {
            System.out.println("Sorry! Staff has already joined, Shift can't be Changed");
        }
        else
        {
            this.shifts = shifts;
            System.out.println("The shift is changed to: " +getShifts());
        }
    }

    /*
    /*
    The method has four parameters (i.e. staffName, qualification, joinigDate, appointedBy) 
    The corresponding value passed through each parameters get assigned to
    corresponding varaible, only if the joined condition is false.
     */
    public void partTime_Staff_Hire(String staffName, String joiningDate, String qualification, String appointedBy)
    {
        if(joined == true)
        {
            System.out.println(getStaffName()+ " " + "is already appointed on" + " " +getJoiningDate());
        }
        else
        {
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            joined = true;
            terminated =false;
            //System.out.println( this.staffName + " Staff is now added as part time staff");
        }
    }

    /*
    This method is used to terminate the staff or more specifically,
    assigns null value to attributes staffName, joiningDate, qualification etc.
    only if, the joined condition is false.
     */
    public void terminate_Staff()
    {
        if(terminated == true)
        {
            System.out.println("Sorry! No staff to be terminated");
        }
        else{
            staffName = ""; 
            joiningDate = "";
            qualification = "";
            joined=false;
            terminated=true;
            //System.out.println("The staff is successfully terminated");
        }
    }

    /*
    This method displays the detail information of part time staff, 
    only if the joined condition is true.
    this method also has super class method which calls display from StaffHire.
     */
    public void display()
    {
        //System.out.println("\t" + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        super.display();
        if(joined == true)
        {
            System.out.println("\t\t" + "---------------------------------");
            System.out.println("\t\t" + "Staff name      : "+getStaffName() );
            System.out.println("\t\t" + "Qualification   : "+getQualification());
            System.out.println("\t\t" + "Joining date    : "+getJoiningDate());
            System.out.println("\t\t" + "Working shift   : " +getShifts()); 
            System.out.println("\t\t" + "Appointed by    : "+getAppointedBy());
            System.out.println("\t\t" + "Working Hour    : "+getWorkingHour());
            System.out.println("\t\t" + "Wages per hour  : "+getWagesPerHour());
            System.out.println( "\t\t" +"Income/Day      : " + (getWagesPerHour() * getWorkingHour()));
            //System.out.println("\t" + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        }else{
            System.out.println("\t\t"+"The Staff hasn't joined yet!"); 
            //System.out.println("\t" + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        }
    }
}

        