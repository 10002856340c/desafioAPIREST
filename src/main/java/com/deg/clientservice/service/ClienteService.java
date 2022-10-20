package com.deg.clientservice.service;

import com.deg.clientservice.controller.Exceptions.ResourceNotFoundException;
import com.deg.clientservice.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.deg.clientservice.repository.ClienteRepository;
import java.time.LocalDate;
import java.time.Period;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


//metodo para crear
    public Clientes create (Clientes newClient){
        return this.clienteRepository.save(newClient);
    }

//metodo para traer todos los datos
    public List<Clientes> findAll(){
        return this.clienteRepository.findAll();
    }


//metodo para actualizar o cargar
    public Clientes update(Clientes client, Long id) throws ResourceNotFoundException {
        Optional<Clientes> clientBD = this.clienteRepository.findById(id);
        if (clientBD.isPresent()){
            Clientes c = clientBD.get();
            c.setApellido(client.getApellido());
            c.setNombre(client.getNombre());
            c.setFecha_nacimiento(client.getFecha_nacimiento());
            return this.clienteRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }

//metodo para eliminar
    public void delete(Long id){
        this.clienteRepository.deleteById(id);
    }

}
