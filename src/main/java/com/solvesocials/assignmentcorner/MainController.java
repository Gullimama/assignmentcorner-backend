package com.solvesocials.assignmentcorner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class MainController {

	@RequestMapping("/assignmentcorner/persistfile")
	public void persistFile(@RequestParam(name = "fileData") String base64String) throws IOException {
		byte[] decoded = Base64.getDecoder().decode(base64String);
		String decodedString = new String(decoded);
		System.out.println("decoded string is: " + decodedString);

		String fileName = "projects.txn";
		FileWriter fileWriter = new FileWriter(fileName, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(decodedString + "\n");
		printWriter.close();
	}

	@RequestMapping("/assignmentcorner/getProjects")
	@ResponseBody
	public String showProjects() throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get("projects.txn"));
		return new String(encoded);
	}

}
