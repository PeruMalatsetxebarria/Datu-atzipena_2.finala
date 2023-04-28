package jatetxetalde.jatetxeak.controller;

import java.util.List;

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




    @GetMapping(path = "/jatetxeguztiak")
	public @ResponseBody Iterable<Jatetxea> getJatetxeGuztiak() {
		return jatetxeakRepository.findAll();
	}

    @GetMapping(path = "/jatetxebat/{name}")
	public @ResponseBody Iterable<Jatetxea> getJatetxeBat(@RequestParam String name) {
		return jatetxeakRepository.findName(name);
	}

}
