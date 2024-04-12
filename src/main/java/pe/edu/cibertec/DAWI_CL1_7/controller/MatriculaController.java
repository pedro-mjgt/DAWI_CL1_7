package pe.edu.cibertec.DAWI_CL1_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_7.model.MatriculaModel;

@Controller
public class MatriculaController {

    @GetMapping("/matricula")
    public String matricula(Model model) {
        model.addAttribute("matriculaModel", new MatriculaModel());
        model.addAttribute("mostrarMensaje", false);

        return "matricula";
    }

    @PostMapping("/matricula")
    public String calcularMatricula(@ModelAttribute("matriculaModel") MatriculaModel matriculaModel, Model model) {
        int nromaterias = matriculaModel.getNromaterias();
        double costototal = nromaterias * 520;
        double descuento = 0;

        if (nromaterias > 5) {
            descuento = 0.1 * costototal;
            costototal = costototal - descuento;
        }

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("mensaje", "El costo total de la matricula es: S/" + costototal  + ". Se efectuo un descuento de S/" + descuento);

        return  "matricula";
    }

}
