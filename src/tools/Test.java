package tools;




import daos.LocationDAO;
import daos.RegionDAO;
import models.Location;
import models.Region;

public class Test {
    public static void main(String[] args) {
        //test connection
        DbConnection connection = new DbConnection();
        System.out.println(connection.getConnection());//com.mysql.cj.jdbc.ConnectionImpl@49e53c76
       
        RegionDAO rdao = new RegionDAO();
        LocationDAO ldao = new LocationDAO();
        
        rdao.setConnection(connection.getConnection());
        ldao.setConnection(connection.getConnection());
        
        Region region = new Region();
        // //test delete region id ke 3
        // region.setRegionId(3);
        // rdao.delete(region);

        //test insert bandung id 3
        region.setRegionId(3);
        region.setRegionName("bandung");
        rdao.insert(region);

        
        //test update get by id (2)
        region.setRegionId(2);
        for (Region regions : rdao.getById(region)) {
            System.out.println(regions.getRegionId());
            System.out.println(regions.getRegionName());
        }
        
        System.out.println("ALL LOCATION");
        //get all location
        for (Location locations : ldao.getAll()) {
            System.out.println(locations.getLocationId());
            System.out.println(locations.getStreetAddress());
            System.out.println(locations.getRegionId());
        }

        System.out.println("ALL REGION");
        //get all region
        for (Region regions : rdao.getAll()) {
            System.out.println(regions.getRegionId());
            System.out.println(regions.getRegionName());
        }

    }
}
