package database;

import java.sql.*;

public class queryLibrary {
    static String url;
    static String user;
    static String password;
    static String driver;

    public queryLibrary(String iUrl, String iUser, String iPassword, String iDriver) {
        this.url = iUrl;
        this.user = iUser;
        this.password = iPassword;
        this.driver = iDriver;
    }

    public void insertCMAC(int cmac_message_number, String cmac_sender, Date cmac_sent_time, String cmac_message_type, String cmac_cap_id){
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String insert = "insert into CMAC_DB Message (CMACMessageNumber, CMACCapIdentifier, CMACSender, CMACDateTime, CMACMessageType) values (?, ?, ?, ?, ?)";
        try {
            //connection = Ser322DBUtils.getConnection(url, user, password, driver);
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, cmac_message_number);
            preparedStatement.setString(2, cmac_sender);
            preparedStatement.setDate(3, cmac_sent_time);
            preparedStatement.setString(4, cmac_message_type);
            preparedStatement.setString(5, cmac_cap_id);
            preparedStatement.executeUpdate();
            System.out.println("SUCCESS");
        } catch (SQLException sqlException) {
            System.out.println("Insert CMAC failed");
            sqlException.printStackTrace();
        } catch (Exception e) {
            System.out.println("Non-SQL error occurred");
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (Throwable t) {
                //Don't terminate
            }
            //Ser322DBUtils.closeConnection(connection);
        }
    }

    public void insertCMACAlert(int cmac_message_number, String cmac_sender_name, String cmac_alert_area, Date cmac_expires_time){
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        String insert = "insert into cmac_alert (CMACMessageNumber, CMACCapIdentifier, CMACSender, CMACAlertArea, CMACExpiresDate) values (?, ?, ?, ?, ?)";
        try {
            //connection = Ser322DBUtils.getConnection(url, user, password, driver);
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, cmac_message_number);
            preparedStatement.setString(2, cmac_sender_name);
            preparedStatement.setString(3, cmac_alert_area);
            preparedStatement.setDate(4, cmac_expires_time);
            preparedStatement.executeUpdate();
            System.out.println("SUCCESS");
        } catch (SQLException sqlException) {
            System.out.println("Insert CMAC Alert failed");
            sqlException.printStackTrace();
        } catch (Exception e) {
            System.out.println("Non-SQL error occurred");
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (Throwable t) {
                //Don't terminate
            }
            //Ser322DBUtils.closeConnection(connection);
        }
    }

    public void insertCMACAlertGeography(int cmac_message_number, String[] cmac_area_description, int[][] cmac_polygon, int[]cmac_circle, int cmac_cmas_geo){

    }

    public void deleteCMAC(int cmac_message_number){

    }

    public void deleteCMACAlert(int cmac_message_number){

    }

    public void deleteCMACAlertGeography(int cmac_message_number){

    }
}
