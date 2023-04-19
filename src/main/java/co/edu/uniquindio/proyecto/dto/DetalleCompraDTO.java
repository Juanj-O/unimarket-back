package co.edu.uniquindio.proyecto.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetalleCompraDTO {

    private int unidades;

    private Double precio;

    private int codigoProducto;
}
