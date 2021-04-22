package com.beratbadan.controllers;

import com.beratbadan.entities.BeratBadan;
import com.beratbadan.services.BeratBadanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeratBadanController {

    private BeratBadanService beratBadanService;

    @Autowired
    public void setBeratBadanService(BeratBadanService beratBadanService) {
        this.beratBadanService = beratBadanService;
    }

    // Endpoint untuk mendapatkan semua list berat badan
    @RequestMapping(value = "/beratBadan", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("beratBadan", beratBadanService.listAllBeratBadan());
        model.addAttribute("averageMax", beratBadanService.averageMax());
        model.addAttribute("averageMin", beratBadanService.averageMin());
        model.addAttribute("averagePerbedaan", beratBadanService.averagePerbedaan());
        return "beratBadan";
    }

    // Endpoint untuk mendapatkan sebuah data berat badan dengan path variable id berat badan
    @RequestMapping("/beratBadan/{id}")
    public String showBeratBadan(@PathVariable Integer id, Model model) {
        model.addAttribute("beratBadan", beratBadanService.getBeratBadanById(id));
        return "beratBadanDetail";
    }

    // Endpoint untuk menampilkan tampilan penambahan data
    @RequestMapping("/beratBadan/new")
    public String newBeratBadan(Model model) {
        model.addAttribute("beratBadan", new BeratBadan());
        return "beratBadanForm";
    }


    // Endpoint untuk menambahkan data berat badan baru
    @RequestMapping(value = "/beratBadan", method = RequestMethod.POST)
    public String saveBeratBadan(BeratBadan beratBadan) {
        beratBadanService.saveBeratBadan(beratBadan);
        return "redirect:/beratBadan";
    }

}
