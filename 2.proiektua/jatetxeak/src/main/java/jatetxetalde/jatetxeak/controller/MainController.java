package jatetxetalde.jatetxeak.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jatetxetalde.jatetxeak.model.Jatetxea;
import jatetxetalde.jatetxeak.model.JatetxeakRepository;

@RestController
@RequestMapping(path = "/jatetxeak")
public class MainController {
    @Autowired
    private JatetxeakRepository jatetxeakRepository;

	//APLIKAZIÑORA SARTZEKO NABEGADORIN HAU IPINI: http://localhost:8080/swagger-ui/index.html#


    @GetMapping(path = "/jatetxeguztiak")
	public @ResponseBody Iterable<Jatetxea> getJatetxeGuztiak() {
		return jatetxeakRepository.findAll();
	}

    @GetMapping(path = "/jatetxebatizena/{name}")
	public @ResponseBody Iterable<Jatetxea> getJatetxeBat(@RequestParam String name) {
		return jatetxeakRepository.findName(name);
	}

	@GetMapping(path = "/jatetxebatid/{id}")
	public @ResponseBody Iterable<Jatetxea> getJatetxeBatId(@RequestParam String _id) {
		return jatetxeakRepository.findId(_id);
	}


	@PutMapping("/helbidealdatu/{id}")
	public Jatetxea updateHelbidea(@RequestParam String _id,
									@RequestParam String address) {
										Jatetxea jatetxea = new Jatetxea();
										jatetxea.setId(_id);
										jatetxea.setAddress(address);
										jatetxeakRepository.updateHelbidea(jatetxea);
		return jatetxea;
	}

	@PutMapping("/jatetxealdatu/{id}")
	public Jatetxea updateJatetxea(@RequestParam String _id,
									@RequestParam String url,
									@RequestParam String address,
									@RequestParam String address_line_2,
									@RequestParam String name,
									@RequestParam String outcode,
									@RequestParam String postcode,
									@RequestParam int rating,
									@RequestParam String type_of_food) {
										Jatetxea jatetxea = new Jatetxea();
										jatetxea.setId(_id);
										jatetxea.setUrl(url);
										jatetxea.setAddress(address);
										jatetxea.setAddress_line_2(address_line_2);
										jatetxea.setName(name);
										jatetxea.setOutcode(outcode);
										jatetxea.setPostcode(postcode);
										jatetxea.setRating(rating);
										jatetxea.setType_of_food(type_of_food);
										jatetxeakRepository.updateJatetxea(jatetxea);
		return jatetxea;
	}









	@PostMapping(path = "/jatetxeberria")
	public @ResponseBody String addNewUser(@RequestParam String _id, @RequestParam String url, @RequestParam String address, @RequestParam String address_line_2, @RequestParam String name, @RequestParam String outcode, @RequestParam String postcode, @RequestParam int rating, @RequestParam String type_of_food) {

		Jatetxea jatetxea = new Jatetxea();
		jatetxea.setId(_id);
        jatetxea.setUrl(url);
        jatetxea.setAddress(address);
        jatetxea.setAddress_line_2(address_line_2);
        jatetxea.setName(name);
        jatetxea.setOutcode(outcode);
		jatetxea.setPostcode(postcode);
        jatetxea.setRating(rating);
        jatetxea.setType_of_food(type_of_food);
		jatetxeakRepository.save(jatetxea);
		return "Saved";
	}








	@DeleteMapping(path = "/ezabatu/{name}")
	public ResponseEntity<Void> deleteJatetxea(@PathVariable String name) {
		try {
			long zenbat = jatetxeakRepository.delete(name);
			System.out.println("Ezabatutako jatetxe kopurua🔆: "+zenbat);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + name + " jatetxea ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
		}
	}
}
