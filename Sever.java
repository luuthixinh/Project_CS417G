/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class Sever {
    public static void main(String[] args) {
        try {
           
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server đang đợi kết nối...");

            
            Socket socket = server.accept();
            System.out.println("Client đã kết nối!");

           
            DataInputStream in = new DataInputStream(socket.getInputStream());
           
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Đọc 2 số từ client
            int a = in.readInt();
            int b = in.readInt();

            // Tính tổng
            int sum = a + b;

            // Gửi kết quả lại cho client
            out.writeInt(sum);

            // Đóng kết nối
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
