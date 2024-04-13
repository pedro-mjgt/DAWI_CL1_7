package pe.edu.cibertec.DAWI_CL1_7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.DAWI_CL1_7.model.MenorModel;

@Controller
public class MenorController {

    @GetMapping ("/menor")
    public String inicioMenor(Model model) {
        model.addAttribute("menorModel", new MenorModel());
        model.addAttribute("mostrarMensaje", false);
        return "menor";
    }

    @PostMapping ("/menor")
    public String calcularMenor(@ModelAttribute ("menorModel") MenorModel menorModel,
                                Model model) {
        double n1= menorModel.getA();
        double n2= menorModel.getB();
        double n3= menorModel.getC();
        double n4= menorModel.getD();
        double menor = 0;

        if ( n1 > n2 )
        {
            menor =n2;
        }
        else
        { menor =n1;
        }
        if( menor > n3 ) {
            menor =n3;
        } else
        { menor =menor;
        }

        if( menor > n4 ) {
            menor =n4;
        } else
        { menor =menor;
        }

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "El número menor es: "
                + menor);


        return "menor";
    }


}

