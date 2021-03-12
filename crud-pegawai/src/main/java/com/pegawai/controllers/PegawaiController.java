package com.pegawai.controllers;

import com.pegawai.entities.Pegawai;
import com.pegawai.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PegawaiController {

    @Autowired
    private PegawaiService pegawaiService;

    @RequestMapping(value = "/pegawai", method = RequestMethod.GET)
    public String list(Model model) throws Exception {
        model.addAttribute("pegawais", pegawaiService.listPegawai());
        model.addAttribute("pegawai", new Pegawai());
        return "pegawai";
    }

    @RequestMapping(value = "/pegawai/get", method = RequestMethod.GET)
    public String getPegawai(Model model, @ModelAttribute("pegawai") Pegawai pegawai) throws Exception {
        model.addAttribute("pegawai", pegawaiService.getPegawai(pegawai.getId()));
        return "pegawaiDetail";
    }

    @RequestMapping(value = "/pegawai/get/{id}", method = RequestMethod.GET)
    public String getPegawai(Model model, @PathVariable Integer id) throws Exception {
        model.addAttribute("pegawai", pegawaiService.getPegawai(id));
        return "pegawaiDetail";
    }

    @RequestMapping("/pegawai/add/page")
    public String addPegawaiPage(Model model) {
        model.addAttribute("pegawai", new Pegawai());
        return "pegawaiForm";
    }

    @RequestMapping(value = "/pegawai/add", method = RequestMethod.POST)
    public String addPegawai(Pegawai pegawai) throws Exception {
        pegawaiService.addPegawai(pegawai);
        return "redirect:/pegawai";
    }

}
