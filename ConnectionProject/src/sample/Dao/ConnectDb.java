package sample.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.Types;

import oracle.jdbc.internal.OracleTypes;

import java.sql.Date;

public class ConnectDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder error = new StringBuilder();
		StringBuilder accrualSerial = new StringBuilder();
		StringBuilder currAccRef = new StringBuilder();
		/*StringBuilder error ;
		StringBuilder accrualSerial;
		StringBuilder currAccRef;*/
		Connection conn = null;
		try {
            String driver = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driver);
            conn = DriverManager.getConnection("jdbc:oracle:thin:@whf00gjk.in.oracle.com:1521/DEV1900_FC145OSDC","FC144OSDCTEST","FC144OSDCTEST");
            Boolean status=true; 
            CallableStatement callableStatement = null;      
                String sql = "{  ? = call  Trpks.FN_GET_PRODUCT_REFNO_BATCH(?,?,?,?,?,?) }";
                callableStatement = conn.prepareCall(sql);
                
                callableStatement.registerOutParameter(1, Types.VARCHAR);               
                //callableStatement.registerOutParameter(5, Types.LONGVARCHAR);
                callableStatement.registerOutParameter(5,JDBCType.OTHER.CHAR);
                callableStatement.registerOutParameter(6, Types.VARCHAR);
                callableStatement.registerOutParameter(7, Types.VARCHAR);
                callableStatement.setString(2, "000");
                callableStatement.setString(3, "LDAC");
                Date date = new Date(2020,9,15);
                callableStatement.setDate(4, date);	
                callableStatement.execute();
                
                /*String error = callableStatement.getString(7);
                String accrualSerial = callableStatement.getString(5);
                String currAccRef = callableStatement.getString(6); 
                String retVal = callableStatement.getString(1);*/
                error.append(callableStatement.getString(7));
                accrualSerial.append(callableStatement.getString(5));
                currAccRef.append(callableStatement.getString(6));
                String retVal = callableStatement.getString(1);
                
                System.out.println(" currAccRef -->>> "+currAccRef);
                System.out.println(" retVal -->>> "+retVal);
                System.out.println(" accrualSerial -->>> "+accrualSerial);
                if("F".equalsIgnoreCase(retVal)){
                	System.out.println("Trpks.FN_GET_PRODUCT_REFNO_BATCH ==> Trpks.FN_GET_PRODUCT_REFNO_BATCH returned false..");
                    status = false;
                    System.out.println(" error -->>> "+error);
                }else{
                	System.out.println("Success");
                }
            
            
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

	}

}
