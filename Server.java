
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADITI
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(3341);
        Socket s=ss.accept();
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        String str1="",str2="";
        str1=(String)din.readUTF();
        try{
            int a =Integer.parseInt(str1);
            a=a*2;
            str2=Integer.toString(a);
        }
        catch(NumberFormatException e) { 
            str2="please send a proper number";
        }
        dout.writeUTF(str2);
        dout.flush();
        din.close();
        s.close();
        ss.close();
    }

}
