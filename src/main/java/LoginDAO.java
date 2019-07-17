import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO {

    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select uname, password from Users where uname = ? and password = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DataConnect.close(con);
        }
        return false;
    }

    ArrayList<HomeController.Employee> fb = new ArrayList<HomeController.Employee>();
    public ArrayList<HomeController.Employee> getEmployee() {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select * from Employee");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String workSchedule = rs.getString("workSchedule");
                String leaveRecord = rs.getString("leaveRecord");
                HomeController.Employee employee = new HomeController.Employee(workSchedule, leaveRecord);
                fb.add(employee);
            }
            ps.close();
            con.close();

            return fb;
        } catch (SQLException ex) {
            System.out.println("error -->" + ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DataConnect.close(con);
        }
        return fb;
    }
}
