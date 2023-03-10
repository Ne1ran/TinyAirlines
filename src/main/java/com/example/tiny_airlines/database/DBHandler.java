package com.example.tiny_airlines.database;

import com.example.tiny_airlines.AllConstants;
import com.example.tiny_airlines.models.Flight;
import com.example.tiny_airlines.models.Passenger;
import com.example.tiny_airlines.models.Plane;

import java.sql.*;
public class DBHandler extends Config{
    Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://"+ Host + ":" + Port + "/" + Name;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connStr, User, Password);
        return connection;
    }


    public ResultSet getAllPassengers() throws SQLException, ClassNotFoundException {
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.PassengerConsts.TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public void addNewPassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + AllConstants.PassengerConsts.TABLE + '(' + AllConstants.PassengerConsts.PASSPORT + ',' +
                AllConstants.PassengerConsts.PHONE + ',' + AllConstants.PassengerConsts.NAME + ',' +
                AllConstants.PassengerConsts.AGE + ',' +AllConstants.PassengerConsts.GENDER + ',' +
                AllConstants.PassengerConsts.DATE_OF_BIRTH + ',' +AllConstants.PassengerConsts.COUNTRY + ',' +
                AllConstants.PassengerConsts.FLIGHT_ID + ')' + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement prst = getConnection().prepareStatement(insert);
        prst.setString(1, passenger.getPassport_num());
        prst.setString(2, passenger.getPhone_num());
        prst.setString(3, passenger.getName());
        prst.setString(4, passenger.getAge());
        prst.setString(5, passenger.getGender());
        prst.setString(6, passenger.getDate_of_birth());
        prst.setString(7, passenger.getCountry());
        prst.setString(8, passenger.getFlight_id());
        prst.executeUpdate();
    }

    public void deletePassenger(String id) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM " + AllConstants.PassengerConsts.TABLE + " WHERE " +
                AllConstants.PassengerConsts.ID + "=" + id;
        PreparedStatement prst = getConnection().prepareStatement(delete);
        prst.execute();
    }

    public void deleteFlight(String id) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM " + AllConstants.FlightConsts.TABLE + " WHERE " +
                AllConstants.FlightConsts.ID + "=" + id;
        PreparedStatement prst = getConnection().prepareStatement(delete);
        prst.execute();
    }

    public void deletePlane(String id) throws SQLException, ClassNotFoundException {
        String delete = "DELETE FROM " + AllConstants.PlaneConsts.TABLE + " WHERE " +
                AllConstants.PlaneConsts.ID + "=" + id;
        PreparedStatement prst = getConnection().prepareStatement(delete);
        prst.execute();
    }

    public void updatePassenger(Passenger passenger) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + AllConstants.PassengerConsts.TABLE + " SET " + AllConstants.PassengerConsts.PASSPORT + "=?,"
                + AllConstants.PassengerConsts.PHONE + "=?,"+ AllConstants.PassengerConsts.NAME + "=?,"
                + AllConstants.PassengerConsts.AGE + "=?,"+ AllConstants.PassengerConsts.GENDER + "=?,"
                + AllConstants.PassengerConsts.DATE_OF_BIRTH + "=?,"+ AllConstants.PassengerConsts.COUNTRY + "=?," +
                AllConstants.PassengerConsts.FLIGHT_ID + "=?" + " WHERE " + AllConstants.PassengerConsts.ID + " = " + passenger.getId();
        PreparedStatement prst = getConnection().prepareStatement(update);
        prst.setString(1, passenger.getPassport_num());
        prst.setString(2, passenger.getPhone_num());
        prst.setString(3, passenger.getName());
        prst.setString(4, passenger.getAge());
        prst.setString(5, passenger.getGender());
        prst.setString(6, passenger.getDate_of_birth());
        prst.setString(7, passenger.getCountry());
        prst.setString(8, passenger.getFlight_id());
        prst.executeUpdate();
    }

    public ResultSet getAllFlights() throws SQLException, ClassNotFoundException {
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.FlightConsts.TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public ResultSet getAllPlanes() throws SQLException, ClassNotFoundException {
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.PlaneConsts.TABLE;
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset;
    }

    public void addNewFlight(Flight flight) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + AllConstants.FlightConsts.TABLE + '(' + AllConstants.FlightConsts.PLANE_ID + ',' +
                AllConstants.FlightConsts.START_DATE + ',' + AllConstants.FlightConsts.START_TIME + ',' +
                AllConstants.FlightConsts.LAND_DATE + ',' +AllConstants.FlightConsts.LAND_TIME + ',' +
                AllConstants.FlightConsts.START_LOCATION + ',' +AllConstants.FlightConsts.LAND_LOCATION + ',' +
                AllConstants.FlightConsts.TRACK + ')' + "VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement prst = getConnection().prepareStatement(insert);
        prst.setString(1, flight.getPlane_id());
        prst.setString(2, flight.getStart_date());
        prst.setString(3, flight.getStart_time());
        prst.setString(4, flight.getLand_date());
        prst.setString(5, flight.getLand_time());
        prst.setString(6, flight.getStart_location());
        prst.setString(7, flight.getLand_location());
        prst.setString(8, flight.getStart_track());
        prst.executeUpdate();
    }

    public void updateFlight(Flight flight) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + AllConstants.FlightConsts.TABLE + " SET " + AllConstants.FlightConsts.PLANE_ID + "=?,"
                + AllConstants.FlightConsts.START_DATE + "=?,"+ AllConstants.FlightConsts.START_TIME + "=?,"
                + AllConstants.FlightConsts.LAND_DATE + "=?,"+ AllConstants.FlightConsts.LAND_TIME + "=?,"
                + AllConstants.FlightConsts.START_LOCATION + "=?,"+ AllConstants.FlightConsts.LAND_LOCATION + "=?,"
                + AllConstants.FlightConsts.TRACK + "=?" + " WHERE " + AllConstants.FlightConsts.ID + " = " + flight.getId();
        PreparedStatement prst = getConnection().prepareStatement(update);
        prst.setString(1, flight.getPlane_id());
        prst.setString(2, flight.getStart_date());
        prst.setString(3, flight.getStart_time());
        prst.setString(4, flight.getLand_date());
        prst.setString(5, flight.getLand_time());
        prst.setString(6, flight.getStart_location());
        prst.setString(7, flight.getLand_location());
        prst.setString(8, flight.getStart_track());
        prst.executeUpdate();
    }

    public void addNewPlane(Plane plane) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + AllConstants.PlaneConsts.TABLE + '(' + AllConstants.PlaneConsts.MODEL + ',' +
                AllConstants.PlaneConsts.TYPE + ',' + AllConstants.PlaneConsts.CAPACITY + ',' +
                AllConstants.PlaneConsts.PILOT +  ')' + "VALUES(?,?,?,?)";
        PreparedStatement prst = getConnection().prepareStatement(insert);
        prst.setString(1, plane.getModel());
        prst.setString(2, plane.getType());
        prst.setString(3, plane.getCapacity());
        prst.setString(4, plane.getPilot_name());
        prst.executeUpdate();
    }

    public void updatePlane(Plane pickedPlane) throws SQLException, ClassNotFoundException {
        String update = "UPDATE " + AllConstants.PlaneConsts.TABLE + " SET " + AllConstants.PlaneConsts.MODEL + "=?,"
                + AllConstants.PlaneConsts.TYPE + "=?,"+ AllConstants.PlaneConsts.CAPACITY + "=?,"
                + AllConstants.PlaneConsts.PILOT + "=?" + " WHERE " + AllConstants.PlaneConsts.ID + " = " + pickedPlane.getId();
        PreparedStatement prst = getConnection().prepareStatement(update);
        prst.setString(1, pickedPlane.getModel());
        prst.setString(2, pickedPlane.getType());
        prst.setString(3, pickedPlane.getCapacity());
        prst.setString(4, pickedPlane.getPilot_name());
        prst.executeUpdate();
    }

    public boolean authorize(String login, String password) throws SQLException, ClassNotFoundException {
        ResultSet rset = null;
        String select = "SELECT * FROM " + AllConstants.AdminConsts.TABLE + " WHERE " +
                AllConstants.AdminConsts.LOGIN + " ='" + login + "' AND " + AllConstants.AdminConsts.PASSWORD + "='" + password + "'";
        PreparedStatement prst = getConnection().prepareStatement(select);
        rset = prst.executeQuery();
        return rset.next();
    }
}
