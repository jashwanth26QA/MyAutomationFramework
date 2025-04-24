package library;

import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class AccessVariablesRepo {
    synchronized public static String getFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    synchronized public static String getFileContent(InputStream fis, String encoding) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fis, encoding))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    synchronized public static String getTagValue(String xml, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        return xml.split(openTag)[1].split(closeTag)[0];
    }

    synchronized public static String[] getMultipleTagValues(String xml, String tag) {
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        ArrayList<String> list = new ArrayList<String>();
        for (; true; ) {
            try {
                list.add(xml.split(openTag)[1].split(closeTag)[0]);
                xml = xml.replaceFirst(tag, "");
                xml = xml.replaceFirst(tag, "");
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        if (list.size() < 1) return null;
        return list.stream().toArray(n -> new String[n]);
    }



    public static JSONObject getContentJsonData() {
        String env = AccessVariablesRepo.convertFileContentsToString("resources/ContentData.json");
        JSONObject jsonObject = new JSONObject(env);
        return jsonObject;
    }

    public synchronized static String convertFileContentsToString(String filePath) {
        String content = null;
        try {
            InputStream ins = AccessVariablesRepo.class.getClassLoader().getResourceAsStream(filePath);
            if (ins == null) {
                content = getFileContent(filePath);
            } else {
                content = getFileContent(ins, "UTF-8");
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return content;
    }

    public HashMap<Integer, String> getFilesContents(String[] filesPath) {
        HashMap<Integer, String> mapping = new HashMap<Integer, String>();
        String content = null;
        int counter = -1;
        for (String filePath : filesPath) {
            content = convertFileContentsToString(filePath);
            mapping.put(++counter, content);
        }
        return mapping;
    }

    public String[] getMultipleTagValues(String xml, String parentTag, String tag) {
        xml = getTagValue(xml, parentTag);
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        ArrayList<String> list = new ArrayList<String>();
        for (; true; ) {
            try {
                list.add(xml.split(openTag)[1].split(closeTag)[0]);
                xml = xml.replaceFirst(tag, "");
                xml = xml.replaceFirst(tag, "");
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        if (list.size() < 1) return null;
        return list.stream().toArray(n -> new String[n]);
    }

    public String getTagValue(String xml, String parentTag, String tag) {
        xml = getTagValue(xml, parentTag);
        String openTag = "<" + tag + ">";
        String closeTag = "</" + tag + ">";
        return xml.split(openTag)[1].split(closeTag)[0];
    }

    public void saveFileContents(String fileWithPath, String fileContents) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileWithPath);
            fw.write(fileContents);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fw != null) try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
