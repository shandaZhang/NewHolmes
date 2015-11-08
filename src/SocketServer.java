import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
	public static void main(String []args) throws  IOException{
		ServerSocket ss =  new ServerSocket(30000);
		while(true){
			Socket s =ss.accept();
			BufferedReader br = new BufferedReader(
					new InputStreamReader(ss.accept().getInputStream()));
			String line = br.readLine();
			System.out.println(line);
			System.out.println();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("服务器欢迎你");
			ps.close();
			s.close();
			
		}
	}

}
