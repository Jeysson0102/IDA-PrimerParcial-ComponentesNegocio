package pe.idat.backend.solutionEmpresa.app_SolutionEmpresa.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.idat.backend.solutionEmpresa.app_SolutionEmpresa.dto.ClienteDto;
import pe.idat.backend.solutionEmpresa.app_SolutionEmpresa.model.Cliente;
import pe.idat.backend.solutionEmpresa.app_SolutionEmpresa.service.ClienteService;

@RestController
@RequestMapping({"/api/clientes"})
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> crearCliente(@RequestBody @Valid ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        Cliente guardado = this.clienteService.guardarCliente(cliente);
        return ResponseEntity.ok("Cliente creado con éxito con ID: " + guardado.getId());
    }

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {
        List<ClienteDto> lista = (List)this.clienteService.listarClientes().stream().map((c) -> new ClienteDto(c.getId(), c.getNombre(), c.getCorreo())).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<String> actualizarCliente(@PathVariable Integer id, @RequestBody ClienteDto clienteDto) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNombre(clienteDto.getNombre());
        clienteEntity.setCorreo(clienteDto.getCorreo());
        Cliente actualizado = this.clienteService.actualizarCliente(id, clienteEntity);
        return ResponseEntity.ok("Cliente actualizado con éxito con ID: " + actualizado.getId());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<ClienteDto> obtenerCliente(@PathVariable Integer id) {
        Cliente cliente = this.clienteService.obtenerClientePorIdOError(id);
        ClienteDto dto = new ClienteDto(cliente.getId(), cliente.getNombre(), cliente.getCorreo());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> eliminarCliente(@PathVariable Integer id) {
        this.clienteService.eliminarClientePorId(id);
        return ResponseEntity.ok("Cliente eliminado con éxito con ID: " + id);
    }
}