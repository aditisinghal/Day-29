
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Client {
    public static void main(String args[]) throws IOException
    {
        Socket s=new Socket("localhost",3341);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1="",str2="";
        str1=br.readLine();
        dout.writeUTF(str1);
        str2=din.readUTF();
        System.out.println(str2);
        dout.close();
        s.close();
    }

}
