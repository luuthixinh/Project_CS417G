/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Client {
     public static void main(String[] args) {
        try {
           
            Socket socket = new Socket("localhost", 1234);

            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Nhập 2 số nguyên từ bàn phím
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập số a: ");
            int a = sc.nextInt();
            System.out.print("Nhập số b: ");
            int b = sc.nextInt();

            // Gửi 2 số tới server
            out.writeInt(a);
            out.writeInt(b);

            // Nhận kết quả từ server
            int sum = in.readInt();
            System.out.println("Tổng a + b = " + sum);

            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
