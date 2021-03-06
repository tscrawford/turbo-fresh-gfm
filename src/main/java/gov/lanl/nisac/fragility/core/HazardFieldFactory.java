package gov.lanl.nisac.fragility.core;

/**
 * Hazard field factory to instantiate and read Esri asc or tif data
 */
public class HazardFieldFactory {

    /**
     * @param fileName - string path for file
     * @param id       - hazard identification
     * @return returns hazard field object
     */
    public HazardField getHazardField(String fileName, String id) {

        String extension = null;
        int idx = fileName.lastIndexOf('.');

        if (idx > 0) {
            extension = fileName.substring(idx + 1);

        } else {
            System.out.println("--> Hazard file has no file extension.");
            System.exit(1);
        }

        // Factory
        if (extension.equalsIgnoreCase("asc")) {
            return new HazardAsc(fileName, id);

        } else if (extension.equalsIgnoreCase("tif")) {
            return new HazardTif(fileName);

        } else {
            System.out.println("Cannot recognize file extension");
            System.exit(1);
        }
        return null;
    }
}
