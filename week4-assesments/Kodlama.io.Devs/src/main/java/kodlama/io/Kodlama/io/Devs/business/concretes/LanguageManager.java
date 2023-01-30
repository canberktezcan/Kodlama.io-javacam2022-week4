package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return this.languageRepository.getAll();
	}

	@Override
	public void add(Language language) throws Exception {

		if (language.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez !");
		} else {
			for (Language addedLanguage : this.languageRepository.getAll()) {
				if (addedLanguage.getName().equals(language.getName())) {
					throw new Exception("Bu kurs daha önce eklenmiş !");
				}
			}

			this.languageRepository.add(language);
		}

	}

	@Override
	public void delete(int id) throws Exception {

		this.languageRepository.delete(id);

	}

	@Override
	public Language getById(int id) {
		return languageRepository.getById(id);
	}

	@Override
	public void update(Language language) throws Exception {

		if(language.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez !");
		}else {
		for (Language addedLanguage : this.languageRepository.getAll()) {
	
			if(addedLanguage.getName().equals(language.getName())) {
				throw new Exception("Bu kurs daha önce eklenmiş !");
			}
		}
		}
		boolean flag = false;
		for (Language addedLanguage : this.languageRepository.getAll()) {
			if(addedLanguage.getId() == language.getId()) {
				this.languageRepository.update(language);
				flag = true;
			}
		}
		if(flag==false)throw new Exception("Bu id numarsı listede yok !");
	
	}
}
