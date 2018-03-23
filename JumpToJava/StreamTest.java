import java.io.InputStream;

public class StreamTest{
	public static void main(String[] args) throws Exception
	{
		InputStream in = System.in;

		int a;
		a = in.read();

		System.out.println(a);
	}
}