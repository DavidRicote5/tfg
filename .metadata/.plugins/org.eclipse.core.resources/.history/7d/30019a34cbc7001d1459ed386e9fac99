package org.getfit.services;

import java.util.List;
import org.getfit.entities.Cliente;
import org.getfit.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	public void saveCliente(String nombre) throws Exception {
		Cliente cliente = Cliente.builder().nombre(nombre).build();
		try {
			clienteRepository.saveAndFlush(cliente);
		} catch (Exception e) {
			throw new Exception("El/la cliente " + nombre + " ya existe");
		}
	}

	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).get();
	}

	public void updateCliente(Long id, String nombre) throws Exception {
		Cliente cliente = clienteRepository.findById(id).get();
		cliente.setNombre(nombre);
		try {
			clienteRepository.saveAndFlush(cliente);
		} catch (Exception e) {
			throw new Exception("El/la cliente " + nombre + " ya existe");
		}
	}

	public void deleteCliente(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
	}
}
