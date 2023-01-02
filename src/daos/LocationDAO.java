package daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Location;

public class LocationDAO {
    private Connection connection;

    public List<Location> getAll(){
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS";
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                Location location = new Location();
                location.setLocationId(resultSet.getInt(1));
                location.setStreetAddress(resultSet.getString(2));
                location.setRegionId(resultSet.getInt(3));
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean insert(Location location){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO LOCATIONS(location_id, StreetAddress, region_id) VALUES(?,?,?)");
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.setString(2, location.getStreetAddress());
            preparedStatement.setInt(3, location.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Location location){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE LOCATIONS SET StreetAddress = ? WHERE location_id = ?");
            preparedStatement.setString(1, location.getStreetAddress());
            preparedStatement.setInt(2, location.getLocationId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Location location){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Locations WHERE location_id = ?");
            preparedStatement.setInt(1, location.getLocationId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Location> getById(Location location){
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS WHERE location_id = "+location.getLocationId();
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                location.setLocationId(resultSet.getInt(1));
                location.setStreetAddress(resultSet.getString(2));
                location.setRegionId(resultSet.getInt(3));
                locations.add(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }
}
