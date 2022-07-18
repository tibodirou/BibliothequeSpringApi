package com.MultiBibliothequeSpringApi.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
/*
import org.springframework.kafka.core.KafkaTemplate;
*/
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MultiBibliothequeSpringApi.dto.LivreDTO;
import com.MultiBibliothequeSpringApi.model.Auteur;
import com.MultiBibliothequeSpringApi.model.Collection;
import com.MultiBibliothequeSpringApi.model.Editeur;
import com.MultiBibliothequeSpringApi.model.Illustrateur;
import com.MultiBibliothequeSpringApi.model.Livre;
import com.MultiBibliothequeSpringApi.serviceImpl.AuteurServiceImpl;
import com.MultiBibliothequeSpringApi.serviceImpl.CollectionServiceImpl;
import com.MultiBibliothequeSpringApi.serviceImpl.EditeurServiceImpl;
import com.MultiBibliothequeSpringApi.serviceImpl.IllustrateurServiceImpl;
import com.MultiBibliothequeSpringApi.serviceImpl.LivreServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LivreResource {
	
	Logger log = LoggerFactory.getLogger(LivreResource.class);
	/*
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
*/
	@Autowired
	private LivreServiceImpl livreService;
	
	@Autowired
	private AuteurServiceImpl auteurService;
	
	@Autowired
	private IllustrateurServiceImpl illustrateurService;
	
	@Autowired
	private EditeurServiceImpl editeurService;
	
	@Autowired
	private CollectionServiceImpl collectionService;
	
	
	
	@RequestMapping(value="fill", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public void fillDatabase(){
		String csvFilePath = "C:/Users/Thibaud Dirou/Desktop/bibliotheque.csv";
		
		BufferedReader csvReader = null;

        
        try {

            
    		csvReader = new BufferedReader(new FileReader(csvFilePath));
    		String lineText = null;
            
    		csvReader.readLine();
			while ((lineText = csvReader.readLine()) != null) {
				
				String[] data = lineText.split(";");
				
				String titre = data[0];
				String auteurName = data.length >= 2 ? data[1] : null ;
				String illustrateurName = data.length >= 3 ? data[2] : null ;
				String editeurName = data.length >= 4 ? data[3] : null ;
				String collectionName = data.length >= 5 ? data[4] : null ; 
				
	                   
	            if (auteurName == null|| auteurName.equals("")) {
	            	auteurName = "Unknown";
	            }
	            if (illustrateurName == null || illustrateurName.equals("") ) {
	            	illustrateurName = "Unknown";
	            }
	            if (editeurName == null|| editeurName.equals("")) {
	            	editeurName = "Unknown";
	            }
	            if (collectionName == null|| collectionName.equals("")) {
	            	collectionName = "Unknown";
	            }

	            
	            Auteur auteur = auteurService.findOne(auteurName);
	            if (auteur == null) {
	            	auteur = new Auteur(auteurName);
	            }

	            Illustrateur illustrateur = illustrateurService.findOne(illustrateurName);
	            if (illustrateur == null) {
	            	illustrateur = new Illustrateur(illustrateurName);
	            }
	            Editeur editeur = editeurService.findOne(editeurName);
	            if (editeur == null) {
	            	editeur = new Editeur(editeurName);
	            }
	            Collection collection = collectionService.findOne(collectionName);
	            if (collection == null) {
	            	collection = new Collection(collectionName);
	            }
	            
	            Livre livre = new Livre();
	            
	            
	            livre.setTitre(titre);
	            livre.setAuteur(auteur);
	            livre.setIllustrateur(illustrateur);
	            livre.setEditeur(editeur);
	            List<Collection> list = Collections.singletonList(collection);
	            livre.setCollections(list);


	            livreService.save(livre);	            
	                
			}
            
        } catch(Exception ex) {

        	ex.printStackTrace();
        } finally {
        	
        	try {
        		if (csvReader != null) {
        			csvReader.close();
        		}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}	
	
	@RequestMapping(value="auteur/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LivreDTO> getLivreofAuthor(@PathVariable String name){
		List<LivreDTO> list = auteurService.findOne(name.replaceAll("%20", " ")).getLivres().stream().map(Converter::entityToDto).collect(Collectors.toList());

		/*
		kafkaTemplate.send("bibliotheque",String.format("Détails sur le livre %d", id) );
		*/

		return list;
	}
		
	@RequestMapping(value="livre", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LivreDTO> getAllLivres(){
		List<LivreDTO> list= livreService.findAll().stream().map(Converter::entityToDto).collect(Collectors.toList());
		/*
		kafkaTemplate.send("bibliotheque","All books displayed");
		*/
		return list;
	}
	
	@RequestMapping(value="livre/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public LivreDTO getLivreDetails(@PathVariable Long id){
		Livre livre = livreService.findOne(id);
		LivreDTO livreDTO = Converter.entityToDto(livre);
		/*
		kafkaTemplate.send("bibliotheque",String.format("Détails sur le livre %d", id) );
		*/

		return livreDTO;
	}
	
	
	@RequestMapping(value="livre", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Livre> createLivre(@RequestBody Livre livre) throws ValidationException, URISyntaxException{
		
        if (livre.getTitre()== null || livre.getTitre()== "") {
            throw new ValidationException("The book need a title");
        }
		Livre result = livreService.save(livre);
		/*
		kafkaTemplate.send("bibliotheque",String.format("New book added whith id : %d", result.getId()));
		*/
		return ResponseEntity.created(new URI("/api/livre/" + result.getId())).body(result);
	}
	
	@RequestMapping(value="livre", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateLivre(@RequestBody Livre livre)throws URISyntaxException, ValidationException{
		if(livre.getId()==0) {
			throw new ValidationException("Id " + 0 +" is incorrect");
		}
		Livre result = livreService.update(livre);
		return ResponseEntity.created(new URI("/api/livre/" + result.getId())).body(result);
	}
	
	@RequestMapping(value="/livre/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteLivre(@PathVariable Long id) throws ValidationException{
		
		
		if (!livreService.exist(id)) {
			throw new ValidationException("Book with id: " + id + " does not exist");
		}
		
		livreService.delete(id);
		
		/*
		kafkaTemplate.send("bibliotheque",String.format("Book %d deleted", id));
		*/
		return ResponseEntity.ok().build();
	}
}
