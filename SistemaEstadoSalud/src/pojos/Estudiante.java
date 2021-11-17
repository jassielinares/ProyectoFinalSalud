/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Estudiante {
    
    private int idEstudiante;
    private String nombre;
    private String sexo;
    private double edad;
    private double altura;
    private double peso;
    double imc;
    String tiene;
    String actividad;
    String recomendacion;
    //constructor para calcular el indice de masa corporal
    public Estudiante(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
    }
    //constructor que pasa parametros 

    public Estudiante(int idEstudiante, String nombre, String sexo, double edad, double altura, double peso, double imc, String tiene, String actividad, String recomendacion) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
        this.tiene = tiene;
        this.actividad = actividad;
        this.recomendacion = recomendacion;
    }

   
    //constuctor vacio 

    public Estudiante() {
    }
    
    //gets y sets 

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTiene() {
        return tiene;
    }

    public void setTiene(String tiene) {
        this.tiene = tiene;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    
    
    //funcion para calcular el indice de masa corporal 
    public ArrayList<String> calcularImc()
    {
        ArrayList<String> datos = new ArrayList<>();
        imc = ((this.peso)/(this.altura * this.altura));
        String calculo = imc + "";
        tiene = "";
        datos.add(calculo);
        if(imc < 16.0)
        {
            tiene = "Delgadez Severa";
        }
        else
        {
            if(imc >= 16.0 && imc < 17.0)
            {
                tiene = "Delgadez Moderada";
            }
            else
            {
                if(imc >= 17.0 && imc < 18.5)
                {
                    tiene = "Delgadez Aceptable";
                }
                else
                {
                    if(imc >= 18.5 && imc < 25.0)
                    {
                        tiene = "Peso Normal";
                    }
                    else
                    {
                        if(imc >= 25.0 && imc <30.0)
                        {
                            tiene = "Sobrepeso";
                        }
                        else
                        {
                            if(imc >= 30.0 && imc < 35.0)
                            {
                                tiene = "Obeso: Tipo I";
                            }
                            else
                            {
                                if(imc >= 35.0 && imc < 40.0)
                                {
                                    tiene = "Obeso: Tipo II";
                                }
                                else
                                {
                                    tiene = "Obeso: Tipo III";
                                }
                            }
                        }
                    }
                }
            }
        }
        datos.add(tiene);
                
        return datos;
    }
    
}
