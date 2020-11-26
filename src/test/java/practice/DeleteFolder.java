package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;


public class DeleteFolder {
    public static void main (String args[])
    {
/*        deletefolder(new File("d:\\Profiles\\khkumari\\Desktop\\Hello"));
        renameDirectory(new File("C:\\New folder1"),new File("C:\\New folder"));*/
        createDirectory(new File("d:\\Profiles\\khkumari\\Desktop\\Hello\\"));
    }
    public static void deletefolder(File Location)
    {

        Path rootPath = Paths.get(String.valueOf(Location));
        try {
            Files.walk(rootPath, FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .peek(System.out::println)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void renameDirectory(File sourceFile, File destFile)
    {
        if(sourceFile.renameTo(destFile))
        {
            System.out.println("Renamed Successfully");
        }
        else
            System.out.println("Failed to rename");
    }
    static void createDirectory(File path)
    {
        try {
            Files.createDirectory(Paths.get(String.valueOf(path)));
            System.out.println("Directory is created");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
