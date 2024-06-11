
package DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DBconnector {
      private Connection connect;
   
    public DBconnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
    
    public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
    
     public boolean insertData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
    
    public void updateData(String sql){
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
                int rowsUpdated = pst.executeUpdate();
                    if(rowsUpdated > 0){
                        JOptionPane.showMessageDialog(null, "Updated Successfully!");
                    }else{
                        System.out.println("Data Update Failed!");
                    }
                    pst.close();
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
        }     
    } 
    
    public void delete(int id, String table){
        try {
            PreparedStatement pst = connect.prepareStatement("DELETE FROM staff_table WHERE Id = ?");
            pst.setInt(1, id);
            
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0){
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            } else{
                JOptionPane.showMessageDialog(null, "Deletion Failed!");
            }
            pst.close();
        } catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void deleteEvent(int id, String table){
        try {
            PreparedStatement pst = connect.prepareStatement("DELETE FROM event_list WHERE Id = ?");
            pst.setInt(1, id);
            
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0){
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            } else{
                JOptionPane.showMessageDialog(null, "Deletion Failed!");
            }
            pst.close();
        } catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
    
    public void deleteParticipants(int id, String table){
        try {
            PreparedStatement pst = connect.prepareStatement("DELETE FROM participants WHERE Id = ?");
            pst.setInt(1, id);
            
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0){
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            } else{
                JOptionPane.showMessageDialog(null, "Deletion Failed!");
            }
            pst.close();
        } catch (SQLException ex){
            System.out.println("Error: " + ex);
        }
    }
}
