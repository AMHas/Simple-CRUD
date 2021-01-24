package controller;

import model.BeratBadan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.BeratBadanService;

import java.util.List;

// Kita menggunakan ModelAndView untuk mempermudah men-simplekan respond body
@Controller
@RequestMapping(value = "/beratBadan")
public class BeratBadanController {

    @Autowired
    private BeratBadanService beratBadanService;

    // Endpoint untuk mendapatkan semua list berat badan
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("beratBadan-list");
        List<BeratBadan> beratBadanList = beratBadanService.getAll();
        modelAndView.addObject("beratBadanList", beratBadanList);
        modelAndView.addObject("averageMax", beratBadanService.averageMax());
        modelAndView.addObject("averageMin", beratBadanService.averageMin());
        modelAndView.addObject("averagePerbedaan", beratBadanService.averagePerbedaan());
        return modelAndView;
    }

    // Endpoint untuk mendapatkan sebuah data berat badan dengan path variable id berat badan
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ModelAndView getById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("beratBadan-detail");
        BeratBadan beratBadan = beratBadanService.getById(id);
        modelAndView.addObject("beratBadanDetail", beratBadan);
        return modelAndView;
    }

    // Endpoint untuk menambahkan data berat badan baru
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@RequestBody BeratBadan beratBadan) {
        beratBadanService.add(beratBadan);
        return new ModelAndView("redirect:/beratBadan/list");
    }

}
