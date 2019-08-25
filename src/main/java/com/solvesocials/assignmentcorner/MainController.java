package com.solvesocials.assignmentcorner;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/assignmentcorner/persistfile")
	public void persistFile(@RequestParam(name = "fileData") String base64String) throws FileNotFoundException {
		System.out.println("called");
		byte[] decoded = Base64.getDecoder().decode(base64String);
		String decodedString = new String(decoded); 
		System.out.println("decoded string is: " + decodedString);
		String fileName = "/home/hrgprasad/assignmentRequests/" + System.currentTimeMillis() + ".txn"; 
		PrintWriter out = new PrintWriter(fileName);
		out.write(decodedString);
		out.flush(); 
		out.close();
	}

}
