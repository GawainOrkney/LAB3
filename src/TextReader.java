import java.io.*;
import java.util.ArrayList;

class TextReader
{
    static public String ReadText(String path)
    {
        String original = "";
        String pathname = path;
        String line;
        original = new String();

        try {

            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            line = reader.readLine();

            while (line != null) {

                line += '\n';
                original += line;
                line = reader.readLine();
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

        return original;
    }

    static public void WriteText(String path, String text)
    {
        try(FileWriter writer = new FileWriter(path, false))
        {

            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    static public void WriteArrayText(String path, ArrayList<String> encodeResult) {

        try(FileWriter writer = new FileWriter(path, false))
        {

            for (int i = 0; i < encodeResult.size(); i++) {
                writer.write(encodeResult.get(i) + "\n");
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    static public ArrayList<String> ReadArrayText(String path) {

        ArrayList <String> original = new ArrayList<>();
        String pathname = path;
        String line;

        try {

            File file = new File(pathname);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            line = reader.readLine();

            while (line != null) {
                original.add(line);
                line = reader.readLine();
            }

        } catch (Exception err) {
            err.printStackTrace();
        }

        return original;
    }
}