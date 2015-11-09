import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while (true) {
			Socket s = ss.accept();
			PrintStream ps = null;
			BufferedReader br = null;

			try {
				br = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				String line;
				while (true) {
					line = br.readLine();
					//if (line.equals("END"))
					//	break;
					System.out.println(line);
					break;
				}
				
				ps = new PrintStream(s.getOutputStream());
				ps.println("服务器欢迎你");
				System.out.println("已发送");
			} catch (Exception e) {
				System.out.println("e: "+e);
			} finally {
				ps.close();
				br.close();
				s.close();
			}

		}
	}
}
