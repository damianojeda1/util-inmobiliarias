/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import java.util.Objects;

/**
 *
 * @author Martin
 */
public class Tripla {
    private Object primero;
    private Object segundo;
    private Object tercero;
    
    public Tripla(Object primero, Object segundo, Object tercero) {
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }

    public Tripla() {
        
    }

    public Object getPrimero() {
        return primero;
    }

    public void setPrimero(Object primero) {
        this.primero = primero;
    }

    public Object getSegundo() {
        return segundo;
    }

    public void setSegundo(Object segundo) {
        this.segundo = segundo;
    }

    public Object getTercero() {
        return tercero;
    }

    public void setTercero(Object tercero) {
        this.tercero = tercero;
    }
    
    public void restarSegundo(){
        this.segundo = (Integer) this.segundo-1;
    }
    
    @Override
    public String toString() {
        return (String) this.tercero;
    }

    @Override
    public boolean equals(Object obj) {
        Tripla t = (Objetos.Tripla) obj;
        if (obj == null || !this.primero.equals(t.getPrimero())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.primero);
        return hash;
    }
    
    
}
