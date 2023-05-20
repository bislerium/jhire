import java.awt.*;
import java.awt.event.*;            
import javax.swing.*;
import java.util.*;
public class MainGUI  implements  ActionListener{
    private JPanel jp1;
    private JToggleButton changeTo;
    private JLabel title, vacancyNumberL, designationL, jobTypeL, salaryL, workingHourL, staffNameL, qualificationL, joiningDateL, appointedByL, workingShiftL, wagesPerHourL, totalVacancy, totalPVacancyL, totalFVacancyL, totalPAppointedL, totalFAppointedL, slogan;
    private JTextField vacancyNumberT, designationT, salaryT, workingHourT, staffNameT, qualificationT, joiningDateT, appointedByT, wagesPerHourT;
    private JButton addFVacancy, appointFStaff, addPVacancy, appointPStaff, terminatePStaff, displayB, clearB;
    private JComboBox workingShiftC, jobTypeC;                                                      //Declaring Instatnce Varaible.
    private JFrame jf;
    ArrayList<StaffHire> alist = new ArrayList<StaffHire>();                                        //Arralist of StaffHire class Data type.
    private PartTimeStaffHire pObject;
    private FullTimeStaffHire fObject;
    private int totalPVacancy, totalFVacancy, totalPAppointed, totalFAppointed;

    public void gUI(){
        jf = new JFrame();                                                                          //title can be set through the object too
        jf.setTitle("StaffHire");
        jf.setLayout(null);
        jf.setResizable(false);         
        jf.setBounds(200,100,810,660);

        jp1 = new JPanel();
        jp1.setLayout(null);
        Color c = new Color(255,255,153);//(59, 207, 207);                                          // Decimal color code 
        jp1.setBackground(c);
        jp1.setBounds(50,250,360,280);

        Font f1 = new Font("New Roman Times", Font.PLAIN, 17);                                      //use to change the font style, weight & size.
        Font f2 = new Font("Segoe UI", Font.PLAIN, 13);
        Font f3 = new Font("Arial", Font.BOLD,12);

        changeTo = new JToggleButton();                                                             //using Togglebutton which have only two states.
        changeTo.setText("Change for Part-Time Employee");
        changeTo.setBounds(450,220,290,30);
        changeTo.addActionListener(this);
        jf.add(changeTo);

        title = new JLabel();                               
        title.setText("Full-Time Staff");
        title.setBounds(255, 85, 300, 50);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        jf.add(title);

        vacancyNumberL = new JLabel();
        vacancyNumberL.setText("Vacancy Number:");
        vacancyNumberL.setFont(f1);
        vacancyNumberL.setBounds(20, 10, 150, 50);
        jp1.add(vacancyNumberL);

        designationL = new JLabel();
        designationL.setText("Designation:");
        designationL.setFont(f1);
        designationL.setBounds(20, 50, 150, 50);
        jp1.add(designationL);

        jobTypeL = new JLabel();
        jobTypeL.setText("Job Type:");
        jobTypeL.setFont(f1);
        jobTypeL.setBounds(20, 90, 150, 50);
        jp1.add(jobTypeL);

        workingHourL = new JLabel();
        workingHourL.setText("Working Hour:");
        workingHourL.setFont(f1);
        workingHourL.setBounds(20, 130, 150, 50);
        jp1.add(workingHourL);

        salaryL = new JLabel();
        salaryL.setText("Salary:");
        salaryL.setFont(f1);
        salaryL.setBounds(20, 170, 150, 50);
        jp1.add(salaryL);

        wagesPerHourL = new JLabel(); 
        wagesPerHourL.setText("Wages per hour:");
        wagesPerHourL.setFont(f1);
        wagesPerHourL.setBounds(20, 210, 150, 50);
        wagesPerHourL.setVisible(false);
        jp1.add(wagesPerHourL);

        workingShiftL = new JLabel();
        workingShiftL.setText("Working shift:");
        workingShiftL.setFont(f1);
        workingShiftL.setBounds(20, 170, 150, 50);
        workingShiftL.setVisible(false);
        jp1.add(workingShiftL);

        staffNameL = new JLabel();
        staffNameL.setText("Staff Name:");
        staffNameL.setFont(f1);
        staffNameL.setBounds(450, 255, 150, 50); 
        jf.add(staffNameL);

        qualificationL = new JLabel();
        qualificationL.setText("Qualification:");
        qualificationL.setFont(f1);
        qualificationL.setBounds(450, 295, 150, 50); 
        jf.add(qualificationL);

        joiningDateL = new JLabel();
        joiningDateL.setText("Joining Date:");
        joiningDateL.setFont(f1);
        joiningDateL.setBounds(450, 335, 150, 50); 
        jf.add(joiningDateL);

        appointedByL = new JLabel();
        appointedByL.setText("Appointed By:");
        appointedByL.setFont(f1);
        appointedByL.setBounds(450, 375, 150, 50); 
        jf.add(appointedByL);

        totalVacancy = new JLabel();
        totalVacancy.setText("Total Vacancy : " + alist.size());                                       //retrieves the size of the Arraylist.
        totalVacancy.setFont(new Font("New Roman Times", Font.BOLD,14));
        totalVacancy.setBounds(50, 180, 150, 50); 
        jf.add(totalVacancy);

        totalPVacancyL = new JLabel();
        totalPVacancyL.setText("Total Part-Time Vacancy : " + totalPVacancy);
        totalPVacancyL.setFont(f2);
        totalPVacancyL.setBounds(50, 205, 180, 50); 
        totalPVacancyL.setVisible(false);
        jf.add(totalPVacancyL);

        totalFVacancyL = new JLabel();
        totalFVacancyL.setText("Total Full-Time Vacancy : " + totalFVacancy);
        totalFVacancyL.setFont(f2);
        totalFVacancyL.setBounds(50, 205, 180, 50); 
        totalFVacancyL.setVisible(true);
        jf.add(totalFVacancyL);

        totalPAppointedL = new JLabel();
        totalPAppointedL.setText("Total Part-Time Staff : " + totalPAppointed);
        totalPAppointedL.setFont(f2);
        totalPAppointedL.setBounds(605, 175, 180, 50); 
        totalPAppointedL.setVisible(false);
        jf.add(totalPAppointedL);

        totalFAppointedL = new JLabel();
        totalFAppointedL.setText("Total Full-Time Staff : " + totalFAppointed);
        totalFAppointedL.setFont(f2);
        totalFAppointedL.setBounds(605, 175, 180, 50); 
        totalFAppointedL.setVisible(true);
        jf.add(totalFAppointedL);

        slogan = new JLabel();
        slogan.setText("(Employee Management)Software_Demo -2020 by @mr_walkan");
        slogan.setForeground(new Color(90,90,90));
        slogan.setFont(new Font("Verdana", Font.PLAIN, 10));
        slogan.setBounds(230, 565, 350, 50); 
        jf.add(slogan);

        vacancyNumberT = new JTextField();                                                          //Vacation number Textfield.
        vacancyNumberT.setBounds(180,20,150,30);
        vacancyNumberT.setBackground(new Color(230,230,230));
        jp1.add(vacancyNumberT);

        designationT = new JTextField();                                                            //Designation Textfield.
        designationT.setBounds(180,60,150,30);
        jp1.add(designationT);

        String ary1[] = {"            Full-Time", "            Part-Time"};
        jobTypeC = new JComboBox(ary1);                                                             //Jobtype Textfield
        jobTypeC.setBounds(180,100,150,30);
        jp1.add(jobTypeC);

        workingHourT = new JTextField();                                                            //Working Hour Textfield
        workingHourT.setBounds(180,140,150,30);
        jp1.add(workingHourT);

        salaryT = new JTextField();                                                                 //Salary TextField
        salaryT.setBounds(180,180,150,30);
        jp1.add(salaryT);

        //for Part time----------------------------
        wagesPerHourT = new JTextField();                                                           //Wages per Hour TextField
        wagesPerHourT.setBounds(180,220,150,30);
        wagesPerHourT.setVisible(false);
        jp1.add(wagesPerHourT);

        String ary[] = {"                 Day", "                Night"};                           //Shift ComboBox
        workingShiftC = new JComboBox(ary);
        workingShiftC.setBounds(180,180,150,30);
        workingShiftC.setVisible(false);
        jp1.add(workingShiftC);
        //----------------------------------------
        staffNameT = new JTextField();                                                              //StaffName Textfield 
        staffNameT.setBounds(590,270,150,30); 
        jf.add(staffNameT);

        qualificationT = new JTextField();                                                      //Qualification Textfield
        qualificationT.setBounds(590,310,150,30);
        jf.add(qualificationT);

        joiningDateT = new JTextField();                                                        //Joining Date Textfield
        joiningDateT.setBounds(590,350,150,30);
        jf.add(joiningDateT);

        appointedByT = new JTextField();                                                        //Appointedby Textfield
        appointedByT.setBounds(590,390,150,30);
        jf.add(appointedByT);

        addFVacancy = new JButton("Add Vacancy for Full-Time Staff");
        addFVacancy.setBounds(20,230,310,30);
        addFVacancy.setFont(f3);
        addFVacancy.addActionListener(this);
        jp1.add(addFVacancy);

        appointFStaff = new JButton("Appoint Full-Time Staff");
        appointFStaff.setBounds(450, 440, 290, 30);
        appointFStaff.setFont(f3);
        appointFStaff.addActionListener(this);
        jf.add(appointFStaff);

        addPVacancy = new JButton("Add Vacancy for Part-Time Staff");
        addPVacancy.setBounds(20,270,310,30);
        addPVacancy.setFont(f3);
        addPVacancy.addActionListener(this);
        addPVacancy.setVisible(false);
        jp1.add(addPVacancy);

        appointPStaff = new JButton("Appoint Part-Time Staff");
        appointPStaff.setBounds(450, 440, 290, 30);
        appointPStaff.setFont(f3);
        appointPStaff.addActionListener(this);
        appointPStaff.setVisible(false);
        jf.add(appointPStaff);

        terminatePStaff = new JButton("Terminate Part-Time Staff");
        terminatePStaff.setBounds(450, 480, 290, 30);
        terminatePStaff.setFont(f3);
        terminatePStaff.addActionListener(this);
        terminatePStaff.setVisible(false);
        jf.add(terminatePStaff);

        displayB = new JButton("Display");
        displayB.setBounds(450, 485, 140, 40);
        displayB.setFont(new Font("Arial", Font.BOLD,14));
        jf.add(displayB);
        displayB.addActionListener(this);

        clearB = new JButton("Clear");
        clearB.setBounds(600, 485, 140, 40);
        clearB.setBackground(new Color(255,70,70)); 
        clearB.setForeground(Color.WHITE); //to add color to text
        clearB.setFont(new Font("Arial", Font.BOLD,16));
        clearB.addActionListener(this);
        jf.add(clearB);

        jf.addWindowListener(new WindowAdapter(){                                                  //to create listener object since it is more conviniet than implementing to the class.
                public void windowClosing(WindowEvent we)
                {
                    int result = JOptionPane.showConfirmDialog(jf,"Do you want to Exit ?", "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION)
                    {
                        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
                    }   //closes the entire window or frame.
                    else if (result == JOptionPane.NO_OPTION)
                    {
                        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
                    }       //Does Nothing
                }
            });

        jf.add(jp1);
        jf.setVisible(true);
    }

    public void pAppoint(){                                                                         //for retrieving total part-time staff who has been appointed.
        int i = 0;
        for(StaffHire li: alist){
            if(li instanceof PartTimeStaffHire){
                PartTimeStaffHire ps1 = (PartTimeStaffHire)li;
                if(ps1.getJoined() == true){
                    i++;
                }
            }
        }
        totalPAppointed = i;
    }

    public void fAppoint(){                                                                         //for retrieving total full-time staff who has been appointed.
        int i = 0;
        for(StaffHire li: alist){
            if(li instanceof FullTimeStaffHire){
                FullTimeStaffHire fs1 = (FullTimeStaffHire)li;
                if(fs1.getJoined() == true){
                    i++;
                }
            }
        }
        totalFAppointed = i;  
    }

    public void totalPVacancy(){                                                                    //for retrieving total Part-time vacancy.
        int i = 0;
        for(StaffHire li: alist){
            if(li instanceof PartTimeStaffHire){
                i++;
            }
        }
        totalPVacancy = i;
    }

    public void totalFVacancy(){                                                                    //for retrieving total full-time vacancy.
        int i = 0;
        for(StaffHire li: alist){
            if(li instanceof FullTimeStaffHire){
                i++;
            }
        }
        totalFVacancy = i;
    }

    public static void main(String[] args){                                                         //main method.
        MainGUI sf = new MainGUI();
        sf.gUI();
    }

    public void actionPerformed(ActionEvent e){                                                     //an abstract method from Action listener interface.
        String ab = vacancyNumberT.getText().trim();
        String bc = designationT.getText().trim();                                                  //trim() method removes the space from front and back end of the text.
        String cd =  jobTypeC.getSelectedItem().toString().trim(); 
        //----integer----
        String de = workingHourT.getText().trim();                                                  //extracting the text entered in the textfield.
        String ef = wagesPerHourT.getText().trim();
        String lm = salaryT.getText().trim();
        //----------------
        String staffName = staffNameT.getText().trim();
        String qualification = qualificationT.getText().trim();
        String joiningDate = joiningDateT.getText().trim();
        String appointedBy = appointedByT.getText().trim();

        String mn = workingShiftC.getSelectedItem().toString().trim();                              //converts the selected text from array to string and trims it.
        boolean b;
        boolean f;

        if(e.getSource() == clearB){                                                                //For Clear Button
            vacancyNumberT.setText(" ");
            designationT.setText(" ");
            jobTypeC.setSelectedIndex(0);
            salaryT.setText(" ");
            workingHourT.setText(" ");
            staffNameT.setText(" "); 
            qualificationT.setText(" ");
            joiningDateT.setText(" ");
            appointedByT.setText(" ");
            wagesPerHourT.setText(" ");
            workingShiftC.setSelectedIndex(0);
        }

        if(e.getSource() == addFVacancy){                                                           //Add vacancy for full time staff
            if(ab.length() == 0 || bc.length() == 0 || cd.length() == 0 || de.length() == 0|| lm.length() == 0){
                JOptionPane.showMessageDialog(jf,"Don't Leave Empty!","Fill up",JOptionPane.WARNING_MESSAGE);
            }
            else{
                b = true;
                try{                                                                                //checks the block of code for any exception.
                    int ba = Integer.parseInt(ab);                                                  //for vacancy number
                    int ed = Integer.parseInt(de);                                                  //for Working Hour
                    int ml = Integer.parseInt(lm);                                                  //for Salary
                    boolean isDVno = false;
                    for(StaffHire var:alist){
                        if(var.getVacancyNumber() == ba){
                            isDVno = true;
                            break;
                        }
                    }
                    if(isDVno == false){
                        fObject = new FullTimeStaffHire(ba, bc, cd, ml, ed);
                        alist.add(fObject);                                                         //adds the object to the arraylist.
                        totalFVacancy();                                                            //calling method;
                        totalFVacancyL.setText("Total FullTime Vacancy : " + totalFVacancy);
                        totalVacancy.setText("Total Vacancy : " + alist.size());
                        JOptionPane.showMessageDialog(jf,"Vaccation no. "+ab + " is successfully added!");
                    } else{
                        JOptionPane.showMessageDialog(jf,"Vaccation no. "+ab + " does already exist!","error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException q){                                                     //only works if the try block throws any exception.
                    b = false;
                }
                if(b == false){
                    JOptionPane.showMessageDialog(jf,"Wrong Input!","Error",JOptionPane.WARNING_MESSAGE);
                }
            } 
        }

        if(e.getSource() == addPVacancy){                                                           //add Vacancy for part time staff
            if(ab.length() == 0 || bc.length() == 0 || cd.length() == 0 || de.length() == 0|| ef.length() == 0){
                JOptionPane.showMessageDialog(jf,"Don't Leave Empty!","Fill up",JOptionPane.WARNING_MESSAGE);
            }
            else{
                b = true;
                try{
                    int ba = Integer.parseInt(ab);                                                  //for vacancy number
                    float ed = Float.parseFloat(de);                                                //for Working Hour
                    float fe = Float.parseFloat(ef);                                                //for Wages per hour
                    boolean isDVno = false;
                    for(StaffHire var1:alist){
                        if(var1.getVacancyNumber() == ba){
                            isDVno = true;
                            break;
                        }
                    }
                    if(isDVno == false){
                        pObject = new PartTimeStaffHire(ba, bc, cd, ed, fe, mn);
                        alist.add(pObject);
                        totalPVacancy();
                        totalPVacancyL.setText("Total PartTime Vacancy : " + totalPVacancy);
                        totalVacancy.setText("Total Vacancy : " + alist.size());
                        JOptionPane.showMessageDialog(jf,"Vaccation no. "+ab + " is successfully added!");
                    }
                    else{
                        JOptionPane.showMessageDialog(jf,"Vaccation no. "+ab + " does already exist!","error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException q){
                    b = false;
                }
                if (b == false){
                    JOptionPane.showMessageDialog(jf,"Wrong Input!","Error",JOptionPane.WARNING_MESSAGE);
                }
            }  
        }

        if(e.getSource() == appointFStaff){                                                         //appoint Full time Staff
            if(staffName.length() == 0 || qualification.length() == 0 || joiningDate.length() == 0 || appointedBy.length() == 0 || ab.length() == 0){
                JOptionPane.showMessageDialog(jf,"Don't Leave Empty!","Fill up",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int ba = Integer.parseInt(ab);                                                  //converts valid String to integer.
                    boolean vnof = false;
                    for(StaffHire var2:alist){
                        if(var2.getVacancyNumber() == ba){
                            vnof = true;
                            if(var2 instanceof FullTimeStaffHire){                                 //checks whether the object is from given class or not.
                                FullTimeStaffHire fs = (FullTimeStaffHire)var2;
                                if(fs.getJoined() == false){
                                    fs.fullTime_Staff_Hire(staffName ,qualification, joiningDate, appointedBy);
                                    fAppoint();
                                    totalFAppointedL.setText("Total Full-Time Staff : " + totalFAppointed);
                                    JOptionPane.showMessageDialog(jf,staffName + " is appointed successfully as full-time " + var2.getDesignation() + "!");
                                    break;                                
                                }
                                else{
                                    JOptionPane.showMessageDialog(jf,"Sorry, the Vacancy no. " + ba + " is already occupied!", "Error", JOptionPane.WARNING_MESSAGE); 
                                    break;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(jf,"Sorry, the Vacancy no. " + ba + " is reserved for Part-Time staff!", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    if(vnof == false){
                        JOptionPane.showMessageDialog(jf,"Sorry, No such Vacancy no. " + ba + " found!", "Unavailable", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception q){
                    JOptionPane.showMessageDialog(jf,"Only integer number is allowed in vacancy no. field!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }  

        if(e.getSource() == appointPStaff){                                                          //Appoint part time staff
            if(qualification.length() == 0 || staffName.length() == 0 || joiningDate.length() == 0 || appointedBy.length() == 0 || ab.length() == 0){
                JOptionPane.showMessageDialog(jf,"Don't Leave Empty!","Fill up",JOptionPane.WARNING_MESSAGE);
            }
            else{
                try{
                    int ba = Integer.parseInt(ab);
                    boolean vnof = false;
                    for(StaffHire var3:alist){                                                      //enhanced for-loop for arraylist iteration. 
                        if(var3.getVacancyNumber() == ba){
                            vnof = true;
                            if(var3 instanceof PartTimeStaffHire){
                                PartTimeStaffHire ps = (PartTimeStaffHire)var3;                                
                                if(ps.getJoined() == false){                                    
                                    ps.partTime_Staff_Hire(staffName, joiningDate ,qualification, appointedBy);
                                    pAppoint();
                                    totalPAppointedL.setText("Total Part-Time Staff : " + totalPAppointed);
                                    JOptionPane.showMessageDialog(jf,staffName + " is appointed successfully as part-time " + var3.getDesignation() + "!");
                                    break;                                
                                }
                                else{
                                    JOptionPane.showMessageDialog(jf,"Sorry, the Vacancy no. " + ba + " is already occupied!", "Error", JOptionPane.WARNING_MESSAGE); 
                                    break;
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(jf,"Sorry, the Vacancy no. " + ba + " is reserved for Full-Time staff!", "Error", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                    if(vnof == false){
                        JOptionPane.showMessageDialog(jf,"Sorry, No such Vacancy no. " + ba + " found!", "Unavailable", JOptionPane.WARNING_MESSAGE);
                    }
                }catch(Exception q){
                    JOptionPane.showMessageDialog(jf,"Only integer number is allowed in vacancy no. field!", "No Alphanumeric String", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        if(e.getSource() == changeTo){                                                              //toggle Button clears the selective textfields on clicked
            vacancyNumberT.setText("");        
            designationT.setText("");
            jobTypeC.setSelectedIndex(0);                                                           //makes empty textfields
            workingHourT.setText("");
            salaryT.setText("");
            wagesPerHourT.setText("");
            workingShiftC.setSelectedIndex(0);
        }

        if(e.getSource() == terminatePStaff){                                                       //termiate staff
            if(ab.length() == 0){
                JOptionPane.showMessageDialog(jf,"Please enter Vacancy number!","Fillup",JOptionPane.WARNING_MESSAGE);  
            }
            else{
                try{
                    int vacno = Integer.parseInt(ab);
                    boolean ter = false;
                    for(StaffHire var4: alist){
                        if(var4.getVacancyNumber() == vacno){
                            ter = true;
                            if(var4 instanceof PartTimeStaffHire){
                                PartTimeStaffHire ps1 = (PartTimeStaffHire)var4;
                                if(ps1.getTerminated() == false){
                                    int confirm = JOptionPane.showConfirmDialog(jf, "Are you sure to Terminate?", "Confirm", JOptionPane.OK_CANCEL_OPTION);
                                    if(confirm == JOptionPane.YES_OPTION){
                                        ps1.terminate_Staff();
                                        pAppoint();
                                        totalPAppointedL.setText("Total Part-Time Staff : " + totalPAppointed);
                                        JOptionPane.showMessageDialog(jf,"Part-time staff has been terminated successfully!");
                                        break;
                                    }
                                    else{
                                        jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  //does nothing, more specifically to JFrame.
                                        break;
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(jf,"Sorry, The staff is either terminated already or hasn't appointed yet!", "Error", JOptionPane.WARNING_MESSAGE); 
                                    break;
                                }
                            }
                            JOptionPane.showMessageDialog(jf,"Sorry, the given Vacancy no. "+ vacno+" belongs to full-time staff!", "Can't Terminate", JOptionPane.WARNING_MESSAGE); 
                        }
                    }
                    if(ter == false){
                        JOptionPane.showMessageDialog(jf,"Sorry, No such Vacancy no. " + vacno + " found!", "Unavailable", JOptionPane.WARNING_MESSAGE);
                    }
                }
                catch(Exception q){
                    JOptionPane.showMessageDialog(jf,"Only integer number is allowed in vacancy no. field!", "No Alphanumeric String", JOptionPane.WARNING_MESSAGE); 
                }
            }
        }

        if(e.getSource() == displayB){                                                              //Display Button.
            if(alist.isEmpty()){
                JOptionPane.showMessageDialog(jf,"Sorry, Nothing to display!", "Empty ArrayList", JOptionPane.WARNING_MESSAGE);    
            }
            else{
                if(changeTo.isSelected()){
                    if(totalPVacancy == 0 ){
                        JOptionPane.showMessageDialog(jf,"Sorry, No Part-time vacancy data available!", "Empty", JOptionPane.WARNING_MESSAGE);    
                    }else{
                        System.out.println("\t" + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");     //Escape tab character to large space.
                        for(StaffHire list: alist){
                            if(list instanceof PartTimeStaffHire){
                                System.out.println("\n\n");                                         // "\n" escape sequence character to jump line.
                                pObject = (PartTimeStaffHire) list;
                                pObject.display();                                                  //calling display method from another class.
                            }
                        }                    
                        System.out.println("\n\n");
                        System.out.println("\t" + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    }
                }else{
                    if(totalFVacancy == 0 ){
                        JOptionPane.showMessageDialog(jf,"Sorry, No Full-Time vacancy data available!", "Empty", JOptionPane.WARNING_MESSAGE);    
                    }else{
                        System.out.println("\t" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        for(StaffHire list: alist){
                            if(list instanceof FullTimeStaffHire){
                                System.out.println("\n\n"); 
                                fObject = (FullTimeStaffHire) list;
                                fObject.display();
                            }
                        }
                        System.out.println("\n\n");
                        System.out.println("\t" + "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    }
                }
            }
        }

        if(changeTo.isSelected()){                                                                 //to know the state of the togglebutton whether selected or unselected.
            f = true;
            jp1.setBounds(50,250,360,310);
            title.setText("Part-Time Staff");
            changeTo.setText("Change for Full-Time Employee");
            salaryL.setVisible(false);
            salaryT.setVisible(false);
            wagesPerHourL.setVisible(true);
            workingShiftL.setVisible(true);
            wagesPerHourT.setVisible(true);
            workingShiftC.setVisible(true);
            appointPStaff.setVisible(true);
            appointFStaff.setVisible(false);
            addFVacancy.setVisible(false);
            addPVacancy.setVisible(true);
            terminatePStaff.setVisible(true);            
            totalPVacancyL.setVisible(true);
            totalFVacancyL.setVisible(false);
            totalPAppointedL.setVisible(true);
            totalFAppointedL.setVisible(false);
            displayB.setBounds(450, 520, 140, 40);
            clearB.setBounds(600, 520, 140, 40);

        }else{
            f = false;
            title.setText("Full-Time Staff");
            changeTo.setText("Change for Part-Time Employee");
            jp1.setBounds(50,250,360,280);
            salaryL.setVisible(true);
            salaryT.setVisible(true);
            wagesPerHourL.setVisible(false);
            workingShiftL.setVisible(false);
            wagesPerHourT.setVisible(false);
            workingShiftC.setVisible(false);
            workingShiftC.setSelectedIndex(0);
            appointPStaff.setVisible(false);
            appointFStaff.setVisible(true);
            addFVacancy.setVisible(true);
            addPVacancy.setVisible(false);
            terminatePStaff.setVisible(false);
            totalFVacancyL.setVisible(true);
            totalPVacancyL.setVisible(false);
            totalPAppointedL.setVisible(false);
            totalFAppointedL.setVisible(true);
            displayB.setBounds(450, 485, 140, 40);
            clearB.setBounds(600, 485, 140, 40);
        }
    }
}

