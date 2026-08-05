package one.digitalinnovation.gof.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;




/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * 
 */

@Service
public class ClienteServiceImpl implements ClienteService{
    // Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		if (id == null) {
			throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
		}
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
        if (id == null) {
        throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
    }
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		if (id == null) {
			throw new IllegalArgumentException("O ID do cliente não pode ser nulo.");
		}
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
    // Validação estrita para evitar nulos e satisfazer o compilador
    if (cliente == null || cliente.getEndereco() == null) {
        throw new IllegalArgumentException("O cliente e o endereço não podem ser nulos.");
    }

    String cep = cliente.getEndereco().getCep();
    
    if (cep == null || cep.trim().isEmpty()) {
        throw new IllegalArgumentException("O CEP do endereço não pode ser nulo ou vazio.");
    }

    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
        Endereco novoEndereco = viaCepService.consultarCep(cep);
        if (novoEndereco == null) {
            throw new RuntimeException("Não foi possível encontrar o endereço para o CEP informado: " + cep);
        }
        enderecoRepository.save(novoEndereco);
        return novoEndereco;
    });
    
    cliente.setEndereco(endereco);
    clienteRepository.save(cliente);

	}

}
