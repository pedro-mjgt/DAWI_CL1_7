package pe.edu.cibertec.DAWI_CL1_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_7.model.JubilacionModel;

@Controller
public class JubilacionController {

    @GetMapping("/jubilacion")
    public String jubilacion(Model model) {
        model.addAttribute("jubilacionModel", new JubilacionModel());
        model.addAttribute("mostrarMensaje", false);

        return "jubilacion";
    }

    @PostMapping("/jubilacion")
    public String calcularJubilacion(@ModelAttribute("jubilacionModel") JubilacionModel jubilacionModel, Model model) {
        String sexo = jubilacionModel.getSexo();
        int edad = jubilacionModel.getEdad();
        String resultado = "";

        if (sexo.equals("M")) {
            if (edad >= 60) {
                resultado = "Usted puede jubilarse";
            } else {
                resultado = "Usted no puede jubilarse";
            }
        } else if (sexo.equals("F")) {
            if (edad >= 55) {
                resultado = "Usted puede jubilarse";
            } else {
                resultado = "Usted no puede jubilarse";
            }
        } else {
            resultado = "Sexo no válido. Por favor ingrese H o M";
        }

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("mensaje", resultado);

        return "jubilacion";
    }

}
