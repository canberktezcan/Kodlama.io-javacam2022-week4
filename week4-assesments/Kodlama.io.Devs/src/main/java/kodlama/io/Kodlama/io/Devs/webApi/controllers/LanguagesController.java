package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAll() {
		return this.languageService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody Language language) throws Exception {
		this.languageService.add(language);
	}
	@GetMapping("/delete")	
	public void delete (int id) throws Exception {
		 this.languageService.delete(id);
	}
	@GetMapping("/getById")
	public Language getById(int id)
	{
		return languageService.getById(id);
	}
	@PostMapping("/update")
	public void update(@RequestBody Language language) throws Exception {
		this.languageService.update(language);
	}

}
