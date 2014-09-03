package socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import Criptografia.Criptografia;
public class UDPServer {
	public static void main(String args[]) throws Exception {
		//Cria um servidor UDP na porta 9876
                
		DatagramSocket serverSocket = new DatagramSocket(9876);
		//Sockets apenas enviam bytes
                Criptografia crip = new Criptografia();
		byte[] receiveData = new byte[16];
		byte[] sendData = new byte[16];
		while (true) {
			System.out.println("Servidor UDP ouvindo...");
			//Recebe as mensagens dos clientes
			DatagramPacket receivePacket = new DatagramPacket(receiveData,	receiveData.length);
			serverSocket.receive(receivePacket);
                         System.out.print("cipher:  ");
			for (int i = 0; i < receiveData.length; i++)
				System.out.print(new Integer(receiveData[i]) + " ");
			System.out.println("");
			String sentence = crip.decrypt(receivePacket.getData());
			System.out.println("Recebido: " + sentence);
			//Responde ao mesmo IP e Porta do pacote recebido.
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			
			for(int i =0; i < receiveData.length; i++)
				receiveData[i] = 0;
		}
	}
}
