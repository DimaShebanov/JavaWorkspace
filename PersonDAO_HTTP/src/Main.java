import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		URL myurla = new URL("http://localhost/test.php");
		HttpURLConnection con = (HttpURLConnection) myurla.openConnection();

		con.setRequestMethod("POST");
		System.out.println(con.getRequestMethod());
		System.out.println(con.getResponseMessage());
//		InputStream in = con.getInputStream();
//		InputStreamReader read = new InputStreamReader(in);
//		BufferedReader reader = new BufferedReader(read);
		DataInputStream reader = new DataInputStream(con.getInputStream());
		System.out.println(reader.readLine());
	}

}
