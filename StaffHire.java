
public class StaffHire
{
    //Declaring private variable with data types
    private int vacancyNumber;
    private String designation;
    private String jobType;
    
    //Initializing three attributes in the constructor
        public StaffHire (int vacancyNumber, String designation, String jobType)
    {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
    }
    /*
     getter-setter method is being used.
     getter-method returns/pass value
     setter-method assigns/updates value
     */
    public int getVacancyNumber()
    {
        return vacancyNumber; 
    }

    public void setVacancyNumber(int vacancyNumber)
    {
        this.vacancyNumber = vacancyNumber;
    }

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public String getJobType()
    {
        return jobType;
    }

    public void setJobType(String jobType)
    {
        this.jobType = jobType;
    }
     //Desplay the detail information of staff
        public void display()
    {
        System.out.println("\t\t" + "Vacancy number  : " +getVacancyNumber());
        System.out.println("\t\t" + "Designation     : " +getDesignation());
        System.out.println("\t\t" + "JobType         : " +getJobType());
    }
}
 