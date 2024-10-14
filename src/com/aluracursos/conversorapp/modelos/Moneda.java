package com.aluracursos.conversorapp.modelos;

public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {
}
