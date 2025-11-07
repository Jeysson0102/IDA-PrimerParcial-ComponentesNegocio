package pe.idat.backend.solutionEmpresa.app_SolutionEmpresa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteDto {
    private Integer id;
    private @NotBlank(
            message = "El nombre es obligatorio"
    ) String nombre;
    private @NotBlank(
            message = "El correo es obligatorio"
    ) @Email(
            message = "Debe ser un correo válido"
    ) String correo;

    public ClienteDto() {
    }

    public ClienteDto(Integer id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}