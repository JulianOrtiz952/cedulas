package com.cedulas.cedulas.services;

import com.cedulas.cedulas.entities.Cedula;
import com.cedulas.cedulas.repositories.CedulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;

@Service
public class CedulaService {

    private int temp;

    @Autowired
    private CedulaRepository cedulaRepository;

    public Cedula createCedula(Cedula cedula){
        return cedulaRepository.save(cedula);
    }

    public Cedula getCedula(Long id){
        return cedulaRepository.findById(id).orElseThrow();
    }

    public int[] getCedulasOrdenadas(Long id){
        Cedula cedula = getCedula(id);
        int[] cedulas = cedula.getCedulas();
        return ordenamiento(cedulas);
    }

    public int[] ordenamiento(int[] cedulas){
        int temp=0;
        for(int i=0; i<cedulas.length; i++){
            for(int j=0; j<cedulas.length; j++){
                if(cedulas[j]>cedulas[i]){
                    temp=cedulas[j];
                    cedulas[j] = cedulas[i];
                    cedulas[i]=temp;
                }
            }
        }
        return cedulas;
    }

    public int findNumero(Long id, int numero){
        int []numeros = getCedulasOrdenadas(id);
        int izquierda=0, derecha=numeros.length-1;
        int mid=(izquierda+derecha)/2;
        while(izquierda<=derecha){
            mid=(izquierda+derecha)/2;
            if(numero<numeros[mid]) derecha=mid;
            if(numero>numeros[mid]) izquierda=mid;
            if(numero==numeros[mid]) {
                temp=mid;
                return numeros[mid];
            }
        }
        return 0;
    }

    public int numerosRestantes(Long id, int numero){
        int[] cedulas = getCedula(id).getCedulas();
        findNumero(id, numero);
        return cedulas.length-temp;
    }

}
