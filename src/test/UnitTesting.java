package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import models.Location;

import org.junit.Test;

import daos.LocationDAO;
import tools.DbConnection;
import daos.RegionDAO;
import models.Region;

public class UnitTesting {
    

    @Test
    public void testInsert_returnTrue_region(){
        //Arrange
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO();
        rdao.setConnection(connection.getConnection());

        Region region = new Region();
        region.setRegionId(7);
        region.setRegionName("Jogja");

        //Act
        boolean actual = rdao.insert(region);

        //Assert
        assertEquals(true, actual);
    }

    @Test
    public void testUpdate_returnTrue_region(){
        //Arrange
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO();
        rdao.setConnection(connection.getConnection());

        Region region = new Region();
        region.setRegionId(7);
        region.setRegionName("Palembang");

        //Act
        boolean actual = rdao.update(region);

        //Assert
        assertEquals(true, actual);
    }

    @Test
    public void testDelete_returnTrue_region(){
        //Arrange
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO();
        rdao.setConnection(connection.getConnection());

        Region region = new Region();
        region.setRegionId(7);

        //Act
        boolean actual = rdao.delete(region);

        //Assert
        assertEquals(true, actual);
    }
    @Test
    public void testGetAll_returnAsExpected_region(){
        //Arrange
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO();
        rdao.setConnection(connection.getConnection());


        //Act
        List<Region> regions = rdao.getAll();
        
        //Assert

        //check if not empty
        assertNotNull(regions);

        //check if list size is equal
        assertEquals(3, regions.size());

        Region region1 = regions.get(0);
        assertEquals(1, region1.getRegionId());
        assertEquals("Jakarta", region1.getRegionName());

        Region region2 = regions.get(1);
        assertEquals(2, region2.getRegionId());
        assertEquals("Tangerang", region2.getRegionName());

        Region region3 = regions.get(2);
        assertEquals(3, region3.getRegionId());
        assertEquals("Bekasi", region3.getRegionName());

    }
    @Test
    public void testGetById_returnAsExpected_region(){
        //Arrange
        DbConnection connection = new DbConnection();
        RegionDAO rdao = new RegionDAO();
        rdao.setConnection(connection.getConnection());
        Region region = new Region();
        region.setRegionId(1);

        //Act
        List<Region> regions = rdao.getById(region);
        
        //check if not empty
        assertNotNull(regions);

        //check if list size is one sized
        assertEquals(1, regions.size());

        Region actualRegion = regions.get(0);
        assertEquals(1, actualRegion.getRegionId());
        assertEquals("Jakarta", actualRegion.getRegionName());
    }

    @Test
    public void testInsert_returnTrue_location(){
        //Arrange
        DbConnection connection = new DbConnection();
        LocationDAO ldao = new LocationDAO();
        ldao.setConnection(connection.getConnection());

        models.Location location = new Location();
        location.setLocationId(7);
        location.setRegionId(2);
        location.setStreetAddress("chase plaza lantai 15");

        //Act
        boolean actual = ldao.insert(location);

        //Assert
        assertEquals(true, actual);
    }

    @Test
    public void testUpdate_returnTrue_location(){
        //Arrange
        DbConnection connection = new DbConnection();
        LocationDAO ldao = new LocationDAO();
        ldao.setConnection(connection.getConnection());

        Location location = new Location();
        location.setLocationId(7);
        location.setRegionId(2);
        location.setStreetAddress("chase plaza lantai 9");

        //Act
        boolean actual = ldao.update(location);

        //Assert
        assertEquals(true, actual);
    }

    @Test
    public void testDelete_returnTrue_location(){
        //Arrange
        DbConnection connection = new DbConnection();
        LocationDAO ldao = new LocationDAO();
        ldao.setConnection(connection.getConnection());

        Location location = new Location();
        location.setLocationId(7);

        //Act
        boolean actual = ldao.delete(location);

        //Assert
        assertEquals(true, actual);
    }
    @Test
    public void testGetAll_returnAsExpected_(){
        //Arrange
        DbConnection connection = new DbConnection();
        LocationDAO ldao = new LocationDAO();
        ldao.setConnection(connection.getConnection());


        //Act
        List<Location> locations = ldao.getAll();
        
        //Assert

        //check if not empty
        assertNotNull(locations);


        Location location1 = locations.get(0);
        assertEquals(1, location1.getLocationId());
        assertEquals(1, location1.getRegionId());
        assertEquals("chase plaza lantai 9", location1.getStreetAddress());

        Location location2 = locations.get(1);
        assertEquals(2, location2.getLocationId());
        assertEquals(2, location2.getRegionId());
        assertEquals("jalan malioboro", location2.getStreetAddress());

    }

    @Test
    public void testGetById_returnAsExpected_location(){
        //Arrange
        DbConnection connection = new DbConnection();
        LocationDAO ldao = new LocationDAO();
        ldao.setConnection(connection.getConnection());
        Location location = new Location();
        location.setLocationId(1);
        //Act
        List<Location> locations = ldao.getById(location);
        
        //Assert

        //check if not empty
        assertNotNull(locations);

        //check if list size is equal
        assertEquals(1, locations.size());


        Location actualLocation = locations.get(0);
        assertEquals(1, actualLocation.getLocationId());
        assertEquals(1, actualLocation.getRegionId());
        assertEquals("chase plaza lantai 9", actualLocation.getStreetAddress());
    }
}
