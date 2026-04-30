package ServiceLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import EntityLayer.doctor;
import EntityLayer.item;
import EntityLayer.patient;
import EntityLayer.user;

public class HDao {
	static Connection con=null;
      public static Connection Connect()
      {
    	        try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					try {
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","rahul@2004");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}return con;
      }
      static int z=0;
      public static int UAdd(String uname,String email,String password,String utype)
      {
    	  
    	       
    	         try {
    	        	        Connection con=HDao.Connect();
					PreparedStatement ps=con.prepareStatement("insert into user(uname,email,password,utype)values(?,?,?,?)");
					ps.setString(1, uname);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.setString(4, utype);
					z=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}return z;
      }
      public static int PAdd(String patientno,String pname,int phone,String address)
      {
    	  try {
			Connection con=HDao.Connect();
			PreparedStatement ps=con.prepareStatement("insert into patient(patientno,patientname,phone,address)values(?,?,?,?)");
			
			ps.setString(1, patientno);
			ps.setString(2, pname);
			ps.setInt(3, phone);
			ps.setString(4, address);
			z=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}return z;
      }
      public static int DAdd(doctor d)
      {
    	  
    	  Connection c = null;
    	  PreparedStatement p = null;

    	  try {
    	      c = HDao.Connect();
    	      p = c.prepareStatement("insert into doctor(doctorid,name,specialization,qualification,channelfee,phone,room,logid) values(?,?,?,?,?,?,?,?)");

    	      p.setString(1, d.getDoctorid());
    	      p.setString(2, d.getName());
    	      p.setString(3, d.getSpecialization());
    	      p.setString(4, d.getQualification());
    	      p.setString(5, d.getChannelfee());
    	      p.setString(6, d.getPhone());
    	      p.setString(7, d.getRoom());
    	      p.setInt(8, d.getLogid());

    	      z = p.executeUpdate();

    	  } catch (Exception e) {
    	      e.printStackTrace();
    	  } finally {
    	      try {
    	          if (p != null) p.close();
    	          if (c != null) c.close();
    	      } catch (Exception ex) {
    	          ex.printStackTrace();
    	      }
    	  }return z;
      }
      public static int DUpdate(doctor d)
      {
    	  try {
			con=HDao.Connect();
			PreparedStatement p=con.prepareStatement("update doctor set name=?,specialization=?,qualification=?,channelfee=?,phone=?,room=? where logid=?");
		  p.setString(1, d.getName());
   	      p.setString(2, d.getSpecialization());
   	      p.setString(3, d.getQualification());
   	      p.setString(4, d.getChannelfee());
   	      p.setString(5, d.getPhone());
   	      p.setString(6, d.getRoom());
   	      p.setInt(7, d.getLogid());
   	      z=p.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}return z;
    	    
    	  
    	  
      }
      public static ResultSet getDoctors() {
    	    ResultSet rs = null;
    	    try {
    	        Connection c = Connect();
    	        PreparedStatement p = c.prepareStatement("SELECT name FROM doctor");
    	        rs = p.executeQuery();
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return rs;
    	}
      
      public static ResultSet getPatient()
      {
    	     ResultSet rs=null;
    	      try {
				Connection c=Connect();
				PreparedStatement ps=c.prepareStatement("select patientname from patient");
				 rs=ps.executeQuery();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
    	      return rs; 
      }
      
      public static int additem(item i)
      {
    	  try {
			Connection c=Connect();
			PreparedStatement ps=c.prepareStatement("insert into item(itemid,itemname,description,sellprice,buyprice,qty)values(?,?,?,?,?,?)");
			
			ps.setString(1, i.getId());
			ps.setString(2, i.getIname());
			ps.setString(3, i.getDes());
			ps.setInt(4, i.getSellp());
			ps.setInt(5, i.getBuyp());
			ps.setInt(6, i.getQty());
			
			z=ps.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}return z;
      }
      
      public static int updateitem(item i)
      {
    	  try {
			Connection c=Connect();
			PreparedStatement ps=c.prepareStatement("update item set itemname=?,description=?,sellprice=?,buyprice=?,qty=? where itemid=?");
			ps.setString(1, i.getIname());
			ps.setString(2, i.getDes());
			ps.setInt(3, i.getSellp());
			ps.setInt(4, i.getBuyp());
			ps.setInt(5, i.getQty());
			ps.setString(6, i.getId());
			z=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}return z;
      }
      
      public static ResultSet getitem()
      {
    	     ResultSet rs=null;
    	      try {
				Connection c=Connect();
				PreparedStatement ps=c.prepareStatement("select itemname from item");
				 rs=ps.executeQuery();
				 
				 
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
    	      return rs; 
      }
      
      public static int PUpdate(patient pt)
      {
    	  try {
			con=HDao.Connect();
			PreparedStatement p=con.prepareStatement("update patient set patientname=?,phone=?,address=? where patientno=?");
		  p.setString(1, pt.getPatientName());
		  p.setInt(2, pt.getPhone());
		  p.setString(3, pt.getAddress());
		  p.setString(4,pt.getPatientNo()) ;
   	      z=p.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}return z;
    	    
    	  
    	  
      }
      
     
}
