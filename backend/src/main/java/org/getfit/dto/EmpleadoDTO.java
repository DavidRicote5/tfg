package org.agaray.spring.pap2023.dto;

import org.agaray.spring.pap2023.entities.Empleado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EmpleadoDTO {
	
	public EmpleadoDTO(Empleado empleado) {
		this.id = empleado.getId();
		this.dni = empleado.getDni();
		this.name = empleado.getNombre();
		this.surname = empleado.getApellido();
		this.color = empleado.getColor();
		this.nonsense = empleado.getChorrada();
		String telefono = empleado.getTlf();
		if (telefono!=null) {
			String casiPrefijo = telefono.split(" ")[0];
			String tel = telefono.split(" ")[1];
			casiPrefijo = casiPrefijo.replaceFirst("\\+", "");
			this.prefix = casiPrefijo;
			this.tel = tel;}
		else {
			this.prefix=null;
			this.tel=null;
		}
			
	}

	private Long id;
	
	private String dni;

	private String name;

	private String surname;

	private String color;

	private String nonsense;
	
	private String prefix;
	
	private String tel;

}
