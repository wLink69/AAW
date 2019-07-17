import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class HomeController implements Serializable {
    private static final long serialVersionUID = 1L;

    public Employee[] em = new Employee[] {
            new Employee(new LoginDAO().getEmployee())
    };

    public Employee[] getOrderList() {
        return em;
    }

    public static class Employee{

        String leaveRecord;
        String workSchedule;
        int no;

        public Employee(String leaveRecord, String workSchedule, int no) {
            this.leaveRecord = leaveRecord;
            this.workSchedule = workSchedule;
            this.no = no;
        }

        public Employee(String workSchedule, String leaveRecord) {
        }

        public Employee(ArrayList<Employee> employee) {

        }

        public String getLeaveRecord() {
            return leaveRecord;
        }

        public void setLeaveRecord(String leaveRecord) {
            this.leaveRecord = leaveRecord;
        }

        public String getWorkSchedule() {
            return workSchedule;
        }

        public void setWorkSchedule(String workSchedule) {
            this.workSchedule = workSchedule;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }
    }
}