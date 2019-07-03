package com.fusi24.mvcnew.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fusi24.mvcnew.model.Mahasiswa;
import com.fusi24.mvcnew.service.GreetingsService;
import com.fusi24.mvcnew.service.MahasiswaService;

@Controller
public class GreetingsCrontroller {
	
	@Autowired
	private GreetingsService greetingService;
	
	@Autowired
	private MahasiswaService mahasiswaService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "name", defaultValue = "no one") String name,
			Model model) {
		model.addAttribute("greeting", greetingService.createGreeting(name));
		return "hello";
	}
	
	@RequestMapping(value = "/mahasiswa")
	public String getAllMahasiswa(Model model) {
		List<Mahasiswa> listMahasiswa = mahasiswaService.selectAll();
		model.addAttribute("list", listMahasiswa);
		return "mahasiswa";
	}
}
