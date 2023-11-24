package com.Laskutusohjelma.web;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Laskutusohjelma.domain.Tyo;
import com.Laskutusohjelma.domain.TyoKerta;
import com.Laskutusohjelma.domain.TyoKertaRepository;
import com.Laskutusohjelma.domain.TyoRepository;

@Controller
public class LaskutusController {
//	@Autowired
//	private TyoRepository tyoRepository;
//	@Autowired
//	private TyoKertaRepository tyokertaRepository;
	
	private List<Tyo> tyot = new ArrayList<>();
	
	@GetMapping(value="/login")
    public String login() {	
        return "login";
    }	

	@GetMapping("/aloitussivu")
	public String aloitussivu(Model model) {
		model.addAttribute("tyot", tyot);
		return "aloitussivu";
	}
	
	@GetMapping("/lisaaTyo")
	public String lisaaTyoSivu(Model model) {
		Tyo uusiTyo = new Tyo();
		uusiTyo.setTyonNimi("");
		model.addAttribute("uusiTyo", uusiTyo);
		return "lisaaTyo";
	}
	
	@PostMapping("/lisaaTyo")
	public String lisaaTyo(@ModelAttribute Tyo uusiTyo) {
		uusiTyo.setPaivapalkka(uusiTyo.getTyonKesto() * uusiTyo.getTuntipalkka());
		tyot.add(uusiTyo);
		return "redirect:/aloitussivu";
	}
	
//	@GetMapping("/tyo/{id}")
//	public String yksittainenTyo(@PathVariable Long id, Model model) {
//		Tyo tyo = tyoRepository.findById(id).orElse(null);
//		if (tyo != null) {
//		List<TyoKerta> tyokerrat = tyokertaRepository.findBytyoId(id);
//		model.addAttribute("tyo", tyo);
//		model.addAttribute("tyokerrat", tyokerrat);
//		return "tyo";
//		} else {
//		 model.addAttribute("virheviesti", "Työtä ei löydy annetulla tunnisteella.");
//			return "redirect:/aloitussivu";
//		}
//	}
//	
//	@PostMapping("/tyo/{id}/lisaaTyokerta")
//	public String lisaaTyoKerta(@PathVariable Long id, @ModelAttribute TyoKerta tyokerta) {
//		Tyo tyo = tyoRepository.findById(id).orElse(null);
//		if (tyo != null) {
//		tyokerta.setTyo(tyo);
//      tyoKertaRepository.save(tyokerta.getTyokerta());
//		tyokertaRepository.save(tyokerta);
//		}
//		return "redirect:/aloitussivu";
//	}
	
	
}
