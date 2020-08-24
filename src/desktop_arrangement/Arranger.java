package desktop_arrangement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

public class Arranger {

    private String path = "";
    private String[][] types = File_Types.allTypes;

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void listFiles() {

        File folder = new File(this.path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                String[] separated = file.getName().split("\\.");
                System.out.println(file.getName());
                System.out.println(separated[separated.length - 1]);
            }
        }
    }

    public void listTypes() {
        for (String[] type : types) {
            for (String extension : type) {
                System.out.println(extension);
            }
        }
    }

    public void reArrange() {

        File folder = new File(this.path);
        File[] listOfFiles = folder.listFiles();

        for (String[] type : types) {

            for (String extension : type) {

                for (File file : listOfFiles) {

                    if (file.isFile()) {

                        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

                        String newpath = this.path + "\\" + type[0] + "\\" + timeStamp + file.getName();
                        String[] separated = file.getName().split("\\.");
                        String file_extension = "." + separated[separated.length - 1];

                        if (file_extension.equals(extension)) {

                            try {
                                System.out.println(newpath);
                                file.renameTo(new File(newpath));
                            } catch (Exception e) {
                                System.out.println("Cannot move file " + file.getName());
                            }

                        }

                    }
                }
            }
        }

    }

    public void createFolder() {

        for (String[] type : types) {

            String newFolder = this.path + "\\" + type[0];
            new File(newFolder).mkdirs();
        }

    }

}