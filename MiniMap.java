import java.util.*;

public class MiniMap {
    public static void main(String[] args) {
        Graph map = new Graph();

        // Adding locations
        Location Entrance = new Location("Entrance", 5.65067, -0.18140);
        Location JQB = new Location("JQB", 5.65067, -0.18174);
        Location geographyDep = new Location("Geography Dep", 5.65114, -0.18329);
        Location lawSchool = new Location("Law School", 5.65440, -0.18323);
        Location mathDepartment = new Location("Math Department", 5.65405, -0.18420);
        Location balmeLibrary = new Location("Balme Library", 5.65202, -0.18701);
        Location engineeringSchool = new Location("Engineering School", 5.65559, -0.18304);
        Location computerScienceDep = new Location("Computer Science Dep", 5.65467, -0.18390);
        Location insOfStatAndSocial = new Location("Ins Of Statistics & Social", 5.65467, -0.18447);
        Location plantBiology = new Location("Plant Biology", 5.65390, -0.18625);
        Location animalBiology = new Location("Animal Biology", 5.65352, -0.18754);
        Location nursingSchool = new Location("Nursing School", 5.65369, -0.19026);
        Location kFolson = new Location("K. Folson", 5.65577, -0.18696);
        Location politicalScience = new Location("Political Science", 5.65483, -0.18647);
        Location newNBlock = new Location("New N Block", 5.65618, -0.18796);
        Location GCB = new Location("GCB", 5.65518, -0.18839);
        Location LOT = new Location("LOT", 5.65080, -0.18700);
        Location homeScience = new Location("Home Science", 5.65300, -0.18448);
        Location UGCS = new Location("UGCS", 5.65225, -0.18816);
        Location CC = new Location("CC", 5.64799, -0.18678);
        Location chemistryDepartment = new Location("Chemistry Department", 5.65296, -0.18524);
        Location schoolOFAgriculture = new Location("School of Agriculture", 5.65043, -0.18375);
        Location biochemistryDepartment = new Location("Biochemistry Department", 5.65517, -0.18965);
        Location businessSchool = new Location("Business School", 5.65384, -0.18878);
        Location cediConference = new Location("Cedi Conference", 5.64799, -0.18678);

        map.addLocation(Entrance);
        map.addLocation(JQB);
        map.addLocation(geographyDep);
        map.addLocation(mathDepartment);
        map.addLocation(balmeLibrary);
        map.addLocation(engineeringSchool);
        map.addLocation(computerScienceDep);
        map.addLocation(insOfStatAndSocial);
        map.addLocation(plantBiology);
        map.addLocation(animalBiology);
        map.addLocation(nursingSchool);
        map.addLocation(kFolson);
        map.addLocation(politicalScience);
        map.addLocation(newNBlock);
        map.addLocation(GCB);
        map.addLocation(LOT);
        map.addLocation(homeScience);
        map.addLocation(UGCS);
        map.addLocation(CC);
        map.addLocation(schoolOFAgriculture);
        map.addLocation(chemistryDepartment);
        map.addLocation(businessSchool);
        map.addLocation(cediConference);
        map.addLocation(biochemistryDepartment);
        map.addLocation(lawSchool);

        // Adding routes with distances
        map.addRoute(Entrance, JQB, 0.5);
        map.addRoute(JQB, geographyDep, 1.5);
        map.addRoute(JQB, lawSchool, 2.0);
        map.addRoute(lawSchool, engineeringSchool, 1.0);
        map.addRoute(lawSchool,mathDepartment,1);
        map.addRoute(mathDepartment, computerScienceDep, 0.5);
        map.addRoute(mathDepartment, chemistryDepartment, 0.5);
        map.addRoute(computerScienceDep, engineeringSchool, 2.0);
        map.addRoute(computerScienceDep, insOfStatAndSocial, 0.5);
        map.addRoute(insOfStatAndSocial, politicalScience, 1.5);
        map.addRoute(politicalScience, kFolson, 0.2);
        map.addRoute(politicalScience, newNBlock, 1.5);
        map.addRoute(kFolson, GCB, 1.0);
        map.addRoute(newNBlock, GCB, 0.5);
        map.addRoute(GCB, biochemistryDepartment, 1.0);
        map.addRoute(biochemistryDepartment, plantBiology, 1.0);
        map.addRoute(plantBiology, LOT, 1.0);
        map.addRoute(LOT, nursingSchool, 1.0);
        map.addRoute(LOT, homeScience, 1.0);
        map.addRoute(homeScience, businessSchool, 1.0);
        map.addRoute(businessSchool, UGCS, 0.5);
        map.addRoute(UGCS, cediConference, 0.5);
        map.addRoute(cediConference, balmeLibrary, 1.0);
        map.addRoute(balmeLibrary, CC, 4.0);
        map.addRoute(Entrance, geographyDep, 0.5);
        map.addRoute(geographyDep, JQB, 1.0);
        map.addRoute(geographyDep, schoolOFAgriculture, 2.5);
        map.addRoute(schoolOFAgriculture, CC, 3.0);
        map.addRoute(CC, balmeLibrary, 5.0);
        map.addRoute(balmeLibrary,kFolson,1.5);

        // Create a list of locations for user selection
        List<Location> locations = new ArrayList<>(map.getLocations());


        boolean continueLooping = true;
        while(continueLooping){
// Print the numbered list of locations
            System.out.println("Available locations:");
            for (int i = 0; i < locations.size(); i++) {
                System.out.println((i + 1) + ": " + locations.get(i).name);
            }

            // User selects current location
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of your current location: ");
            int currentLocationIndex = scanner.nextInt() - 1;
            Location currentLocation = (currentLocationIndex >= 0 && currentLocationIndex < locations.size()) ? locations.get(currentLocationIndex) : null;

            // User selects destination location
            System.out.print("Enter the number of your destination location: ");
            int destinationLocationIndex = scanner.nextInt() - 1;
            Location destinationLocation = (destinationLocationIndex >= 0 && destinationLocationIndex < locations.size()) ? locations.get(destinationLocationIndex) : null;

            if (currentLocation != null && destinationLocation != null) {
                System.out.println("Current location found: " + currentLocation.name);
                System.out.println("Destination location found: " + destinationLocation.name);
                // Find the shortest path from current location to the destination
                List<Location> shortestPath = map.findShortestPath(currentLocation, destinationLocation);
                double totalDistance = 0.0;

                if (!shortestPath.isEmpty()) {
                    System.out.println("Shortest path from " + currentLocation.name + " to " + destinationLocation.name + ":");
                    for (int i = 0; i < shortestPath.size(); i++) {
                        System.out.println("- " + shortestPath.get(i).name);
                        if (i < shortestPath.size() - 1) {
                            // Calculate distance between consecutive locations
                            totalDistance += map.getDistance(shortestPath.get(i), shortestPath.get(i + 1));
                        }
                    }
                    System.out.printf("Total distance: %.2f km%n", totalDistance);
                } else {
                    System.out.println("No path found from " + currentLocation.name + " to " + destinationLocation.name);
                }
            } else {
                if (currentLocation == null) {
                    System.out.println("Current location not found.");
                }
                if (destinationLocation == null) {
                    System.out.println("Destination location not found.");
                }
            }

            System.out.print("Do you want to search for another location?");
            System.out.println("1.Yes    2.No");

            String confirm = scanner.next();


            if (confirm.equals("1")){
                continue;
            } else if (confirm.equals("2")) {
                System.out.println("Closing Program....");
                continueLooping = false;

            }
            else {
                System.out.println("Invalid input!");
            }

        }



    }
}
