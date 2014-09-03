package socket.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
	public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("Digite algo para enviar ao servidor TCP...");
			//Abre conexão com destino: local e porta: 6789
			Socket clientSocket = new Socket("localhost", 6789);
			//Lê entrada do usuário.
			sentence = inFromUser.readLine();
			//Cria canal de comunicação com o servidor
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			//Enviar a mensagem ao servidor.
			outToServer.writeBytes(sentence + '\n');
			//Lê resposta do servidor.
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			modifiedSentence = inFromServer.readLine();
			System.out.println("Recebido do servidor TCP: " + modifiedSentence);
			clientSocket.close();
		}
	}
}