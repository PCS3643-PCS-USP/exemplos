package br.usp.pcs.labes.gme.pcsgme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppController {
    @GetMapping(value = {"/", ""})
    public String getIndex(HttpServletRequest request) {
        return "/index.html";
    }
}
