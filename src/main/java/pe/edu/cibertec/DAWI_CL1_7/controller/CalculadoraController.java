package pe.edu.cibertec.DAWI_CL1_7.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.cibertec.DAWI_CL1_XXX.model.ResultadoCalculo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
@Controller
public class CalculadoraController {
    @GetMapping("/calculadora")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("limiteInferior") int limiteInferior,
                           @RequestParam("limiteSuperior") int limiteSuperior,
                           Model model) {
        List<ResultadoCalculo> resultados = new ArrayList<>();
        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            ResultadoCalculo resultado = new ResultadoCalculo();
            resultado.setNumero(i);
            resultado.setCuadrado(i * i);
            resultado.setMitad(i / 2.0);
            resultados.add(resultado);
        }
        model.addAttribute("resultados", resultados);
        return "resultado";
    }
