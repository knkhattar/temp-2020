package com.example.deletepackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HostNameUtils {
	public static String getHostNameUsingInetAddress() {
		 
        InetAddress ip;
        String hostname="";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
        return hostname;
    }
	
	public static String getHostNameUsingEtcHostname() throws IOException {
		
	    try (Scanner s = new Scanner(Runtime.getRuntime().exec("cat /etc/hostname").getInputStream()).useDelimiter("\\A")) {
	    	String hostname = s.hasNext() ? s.next() : "";
	    	s.close();
	        return hostname;
	        
	    }
	}
}
