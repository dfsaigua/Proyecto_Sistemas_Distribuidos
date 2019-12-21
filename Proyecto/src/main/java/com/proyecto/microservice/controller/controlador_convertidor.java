package com.proyecto.microservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dan
 */@Controller
public class controlador_convertidor {
    @GetMapping("/principal")
	public String convertidor_audio(@RequestParam(name="file", required=false) String name, Model model) {
		File source = new File("source.avi");
                File target = new File("target.mp4");
                File source = new File("source.avi");
                FileOutputStream fileOutputStream = new FileOutputStream(source);
                byte[] bytes = video.getInputStream().readAllBytes();
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
		return "principal";
	}
}
