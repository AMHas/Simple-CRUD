package com.pegawai.controllers;

import com.pegawai.entities.Pegawai;
import com.pegawai.entities.PegawaiContact;
import com.pegawai.services.PegawaiContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PegawaiContactController {

    @Autowired
    private PegawaiContactService pegawaiContactService;

    @RequestMapping(value = "/pegawaiContact", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("pegawaiContacts", pegawaiContactService.listPegawaiContacts());
        model.addAttribute("pegawaiContact", new PegawaiContact());
        return "pegawaiContact";
    }

    @RequestMapping(value = "/pegawaiContact/get", method = RequestMethod.GET)
    public String getPegawaiContact(Model model, @ModelAttribute("pegawaiContact") PegawaiContact pegawaiContact) throws Exception {
        model.addAttribute("pegawaiContact", pegawaiContactService.getPegawaiContact(pegawaiContact.getId()));
        return "pegawaiContactDetail";
    }

    @RequestMapping(value = "/pegawaiContactByPegawai/get", method = RequestMethod.GET)
    public String getPegawaiContactByPegawaiId(Model model, @ModelAttribute("pegawaiContact") PegawaiContact pegawaiContact) throws Exception {
        model.addAttribute("pegawaiContact", pegawaiContactService.getPegawaiContactByPegawaiId(pegawaiContact.getId()));
        return "pegawaiContactDetail";
    }

    @RequestMapping(value = "/pegawaiContact/get/{id}", method = RequestMethod.GET)
    public String getPegawaiContact(Model model, @PathVariable Integer id) throws Exception {
        model.addAttribute("pegawaiContact", pegawaiContactService.getPegawaiContact(id));
        return "pegawaiContactDetail";
    }

    @RequestMapping("/pegawaiContact/add/page")
    public String addPegawaiContactPage(Model model) {
        model.addAttribute("pegawaiContact", new PegawaiContact());
        return "pegawaiContactForm";
    }

    @RequestMapping(value = "/pegawaiContact/add", method = RequestMethod.POST)
    public String addPegawaiContact(PegawaiContact pegawaiContact) throws Exception {
        pegawaiContactService.addPegawaiContact(pegawaiContact);
        return "redirect:/pegawaiContact";
    }

}
