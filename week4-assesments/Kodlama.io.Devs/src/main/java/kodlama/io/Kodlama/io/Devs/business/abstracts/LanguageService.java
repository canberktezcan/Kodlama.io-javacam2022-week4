package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.Language;

public interface LanguageService {

	public List<Language> getAll();
	public void add(Language language) throws Exception;
	public void delete(int id) throws Exception;
	public Language getById(int id);
	public void update(Language language) throws Exception;
		
}
