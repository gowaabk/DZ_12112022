import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    public static void main(String[] args) {
        String[] paths = { "root/a 1.txt(abcd) 2.txt(efgh)",
                "root/c 3.txt(abcd)",
                "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)" };

        System.out.println(Arrays.toString(findDuplicate(paths).toArray()));
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> myPaths = new ArrayList<>();
        Map<String, List<String>> myPathMap = new HashMap<>();

        for (String data : paths) {
            String[] pathsArray = data.split(" ");
            String directory = pathsArray[0];

            for (int i = 1; i < pathsArray.length; i++) {
                int j;
                StringBuilder content = new StringBuilder();
                StringBuilder fileName = new StringBuilder();
                for (j = 0; pathsArray[i].charAt(j) != '('; j++) {
                    fileName.append(pathsArray[i].charAt(j));
                }

                content.insert(0, pathsArray[i].substring(j + 1, pathsArray[i].length() - 1));

                myPathMap.putIfAbsent(content.toString(), new ArrayList<>());
                myPathMap.get(content.toString()).add(directory + "/" + fileName);
            }

        }

        for (String key : myPathMap.keySet()) {
            if (myPathMap.get(key).size() > 1) {
                myPaths.add(myPathMap.get(key));
            }
        }
        return myPaths;
    }
}
