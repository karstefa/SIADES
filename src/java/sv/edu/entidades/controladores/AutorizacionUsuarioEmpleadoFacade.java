/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades.controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.entidades.AutorizacionUsuarioEmpleado;

/**
 *
 * @author rgluis
 */
@Stateless
public class AutorizacionUsuarioEmpleadoFacade extends AbstractFacade<AutorizacionUsuarioEmpleado> {
    @PersistenceContext(unitName = "AplicacionWebCooperativaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutorizacionUsuarioEmpleadoFacade() {
        super(AutorizacionUsuarioEmpleado.class);
    }
    
}
