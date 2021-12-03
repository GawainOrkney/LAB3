import java.util.ArrayList;

class Main
{
    public static void main(String[] args)
    {
        RivestShamirAdleman rsa = new RivestShamirAdleman();

        String text = TextReader.ReadText("messages/Input.txt");

        ArrayList<String> encodeResult = rsa.Encode(text);
        TextReader.WriteArrayText("messages/Encrypted.txt", encodeResult);

        ArrayList<String> input = TextReader.ReadArrayText("messages/Encrypted.txt");

        String decodeResult = rsa.Decode(input);
        TextReader.WriteText("messages/Decrypted.txt", decodeResult);
    }
}